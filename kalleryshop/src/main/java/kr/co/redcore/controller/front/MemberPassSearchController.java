package kr.co.redcore.controller.front;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.annotation.CheckToken;
import kr.co.redcore.controller.BaseController;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.service.AuthNumService;
import kr.co.redcore.service.EmailService;
import kr.co.redcore.service.member.MemberService;

@Controller
@SessionAttributes(value = { "tbl_member" })
public class MemberPassSearchController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(MemberPassSearchController.class);

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AuthNumService authNumService;	
	
	@Autowired
	private MemberService memberService;

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// WebDataBinder에서 수정불가능한 필드를 나열한다.
		//dataBinder.setDisallowedFields("member_id");
	}

	@RequestMapping(value = "/front/member/pass_search/emailInputForm.do")
	public ModelAndView emailInputForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		ModelAndView mv = new ModelAndView();		
		mv.setViewName(this.getFrontThemeRoute("member/pass_search/emailInputForm"));

		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/front/member/pass_search/emailAuthForm.do")
	public ModelAndView emailAuthForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute Tbl_member tbl_member, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();

		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName(this.getFrontThemeRoute("member/pass_search/emailInputForm"));
		} else {
			logger.debug("tbl_member.getEmail_addr() >>>> " + tbl_member.getEmail_addr());
			
			try {
				// 이메일 인증시 사용할 인증번호를 생성하고, 이메일로 전송처리 한다.
				String authNum = authNumService.getAuthNum(GlobalConstants.AUTH_TYPE_PSS_EAMIL, tbl_member.getEmail_addr());
				
				StringBuffer content = new StringBuffer();
				content.append("이메일 : " + tbl_member.getEmail_addr() + "\n");
				content.append("인증번호 : " + authNum + "\n");
				
				emailService.sendEmail(tbl_member.getEmail_addr(), "[TOTO SNS 비밀번호찾기]인증번호 도착 !!!", content.toString());
			} catch(Exception ex) {
				bindingResult.rejectValue("email_addr", "error.send_email");
				mv.setViewName(this.getFrontThemeRoute("member/pass_search/emailInputForm"));
			}
			
			mv.setViewName(this.getFrontThemeRoute("member/pass_search/emailAuthForm"));
		}
		
		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/front/member/pass_search/passUpdateForm.do")
	public ModelAndView passUpdateForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute Tbl_member tbl_member, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName(this.getFrontThemeRoute("member/pass_search/emailAuthForm"));
		} else {
			logger.debug("tbl_member.getEmail_addr() >>>> " + tbl_member.getEmail_addr());
			logger.debug("tbl_member.getAuth_num() >>>> " + tbl_member.getAuth_num());			

			boolean trueAuthNum = authNumService.checkAuthNum(GlobalConstants.AUTH_TYPE_PSS_EAMIL, tbl_member.getEmail_addr(), tbl_member.getAuth_num() != null ? tbl_member.getAuth_num() : "");

			logger.debug("authNumService.checkAuthNum >>>> " + trueAuthNum);
			if(trueAuthNum) {
				// 인증번호가 맞다면
				tbl_member.setMember_id(tbl_member.getEmail_addr());//이메일을 member_id로 사용함. 
				
				mv.setViewName(this.getFrontThemeRoute("member/pass_search/passUpdateForm"));
			} else {
				// 인증번호가 틀리다면
				bindingResult.rejectValue("auth_num", "error.auth_num");
				mv.setViewName(this.getFrontThemeRoute("member/pass_search/emailAuthForm"));
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/front/member/pass_search/passUpdate.do")
	public ModelAndView passUpdate(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute Tbl_member tbl_member, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName(this.getFrontThemeRoute("member/pass_search/passUpdateForm"));
		} else {
			logger.debug("tbl_member.getMember_id() >>>> " + tbl_member.getMember_id());
			logger.debug("tbl_member.getEmail_addr() >>>> " + tbl_member.getEmail_addr());
			logger.debug("tbl_member.getAuth_num() >>>> " + tbl_member.getAuth_num());		
			
			boolean trueAuthNum = authNumService.checkAuthNum(GlobalConstants.AUTH_TYPE_PSS_EAMIL, tbl_member.getEmail_addr(), tbl_member.getAuth_num() != null ? tbl_member.getAuth_num() : "");

			logger.debug("authNumService.checkAuthNum >>>> " + trueAuthNum);
			if(trueAuthNum) {
				// 비밀번호를 변경하면서, 인증번호가 맞다면
				memberService.updateTbl_memberForPassword(tbl_member.getMember_id(), tbl_member.getPassword());
				
				mv.setViewName(this.getFrontThemeRoute("member/pass_search/passUpdateDone"));
			} else {
				// 비밀번호를 변경하면서, 인증번호가 맞다면
				bindingResult.rejectValue("auth_num", "error.auth_num");
				mv.setViewName(this.getFrontThemeRoute("member/pass_search/passUpdateForm"));
			}
		}
		
		return mv;
	}
}