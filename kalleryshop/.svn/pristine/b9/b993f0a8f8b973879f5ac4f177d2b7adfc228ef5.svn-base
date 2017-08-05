package kr.co.redcore.controller.admin;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import kr.co.redcore.GlobalConstants;
import kr.co.redcore.annotation.CheckToken;
import kr.co.redcore.controller.BaseController;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

@Controller
@SessionAttributes(value = { "tbl_member" })
public class AdminMemberController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(AdminMemberController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private MemberService memberService;

	@Autowired
	MessageSource messageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// WebDataBinder에서 수정불가능한 필드를 나열한다.
		dataBinder.setDisallowedFields("member_seq", "member_type");
	}

	@RequestMapping(value = "/admin/admin_member/searchList.do")
	public ModelAndView searchList(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		ParamMap paramMap = new ParamMap();
		paramMap.put("sch_member_id", params.get("sch_member_id"));
		paramMap.put("sch_member_name", params.get("sch_member_name"));
		paramMap.put("sch_start_date", params.get("sch_start_date"));
		paramMap.put("sch_end_date", params.get("sch_end_date"));
		paramMap.put("sch_member_type", GlobalConstants.MEMBER_TYPE_ADMIN);// 관리자

		PageHelper pageHelper;
		if (params.get("curr_page") != null && !params.get("curr_page").equals("")) {
			pageHelper = new PageHelper(Long.parseLong((String) params.get("curr_page")), PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		} else {
			pageHelper = new PageHelper(PageHelper.DEFAULT_CURR_PAGE, PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		}
		memberService.getPageHelperByParamEtc(paramMap, pageHelper);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_member/searchList");
		mv.addObject("paramMap", paramMap);
		mv.addObject("pageHelper", pageHelper);
		
		return mv;
	}

	@RequestMapping(value = "/admin/admin_member/registForm.do")
	public ModelAndView registForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		Tbl_member tbl_member = new Tbl_member();
		tbl_member.setMember_type(GlobalConstants.MEMBER_TYPE_ADMIN);
		
		mv.setViewName("admin/admin_member/registForm");
		mv.addObject("tbl_member", tbl_member);
		
		return mv;
	}

	@CheckToken
	@RequestMapping(value = "/admin/admin_member/regist.do", method = RequestMethod.POST)
	public ModelAndView regist(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Tbl_member tbl_member, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/admin_member/registForm");
		} else {
			try {
				logger.debug("tbl_member.toString() >>> " + tbl_member.toString());
	
				tbl_member.setCurr_point(0);
				tbl_member.setIs_del(GlobalConstants.IS_VALID_N);
				tbl_member.setIs_valid(GlobalConstants.IS_VALID_Y);
				tbl_member.setRegby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
				tbl_member.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());	
				memberService.insertTbl_member(tbl_member);
	
				status.setComplete();				
				mv.setViewName("admin/admin_member/registDone");
			} catch (DuplicateKeyException ex) {
				bindingResult.rejectValue("member_id", "error.member_id_dup");
				mv.setViewName("admin/admin_member/registForm");
			} catch (Member_id_dupException ex) {
				bindingResult.rejectValue("member_id", "error.member_id_dup");
				mv.setViewName("admin/admin_member/registForm");
			}
		}
		
		return mv;
	}

	@RequestMapping(value = "/admin/admin_member/updateForm.do")
	public ModelAndView updateForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		String member_id = (String) params.get("member_id");
		String curr_page = (String) params.get("curr_page");
		Tbl_member tbl_member = memberService.getTbl_memberByMember_id(member_id);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/admin_member/updateForm");
		mv.addObject("tbl_member", tbl_member);
		mv.addObject("curr_page", curr_page);

		return mv;
	}

	@CheckToken
	@RequestMapping(value = "/admin/admin_member/update.do", method = RequestMethod.POST)
	public ModelAndView update(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Tbl_member tbl_member, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		String curr_page = (String) params.get("curr_page");
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/admin_member/updateForm");
		} else {
			tbl_member.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
			memberService.updateTbl_member(tbl_member);
	
			status.setComplete();
			mv.setViewName("admin/admin_member/updateDone");
			mv.addObject("curr_page", curr_page);
		}
		
		return mv;
	}
}