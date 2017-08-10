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
import kr.co.redcore.domain.Tbl_banner_mgr;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.service.banner.BannerMgrService;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

@Controller
@SessionAttributes(value = { "tbl_banner_mgr" })
public class BannerManagerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BannerManagerController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private BannerMgrService bannerMgrService;

	@Autowired
	MessageSource messageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// WebDataBinder에서 수정불가능한 필드를 나열한다.
		dataBinder.setDisallowedFields("banner_mgr_seq");
	}

	@RequestMapping(value = "/admin/banner_manager/searchList.do")
	public ModelAndView searchList(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		ParamMap paramMap = new ParamMap();
		paramMap.put("sch_banner_name", params.get("sch_banner_name"));
		paramMap.put("sch_start_date", params.get("sch_start_date"));
		paramMap.put("sch_end_date", params.get("sch_end_date"));

		PageHelper pageHelper;
		if (params.get("curr_page") != null && !params.get("curr_page").equals("")) {
			pageHelper = new PageHelper(Long.parseLong((String) params.get("curr_page")), PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		} else {
			pageHelper = new PageHelper(PageHelper.DEFAULT_CURR_PAGE, PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		}
		bannerMgrService.getPageHelperByParamEtc(paramMap, pageHelper);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/banner_manager/searchList");
		mv.addObject("paramMap", paramMap);
		mv.addObject("pageHelper", pageHelper);
		
		return mv;
	}
	
	@RequestMapping(value = "/admin/banner_manager/registForm.do")
	public ModelAndView registForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		Tbl_banner_mgr tbl_banner_mgr = new Tbl_banner_mgr();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/banner_manager/registForm");
		mv.addObject("tbl_banner_mgr", tbl_banner_mgr);
		
		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/admin/banner_manager/regist.do", method = RequestMethod.POST)
	public ModelAndView regist(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Tbl_banner_mgr tbl_banner_mgr, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/banner_manager/registForm");
		} else {
			logger.debug("tbl_banner_mgr.toString() >>> " + tbl_banner_mgr.toString());
			
			tbl_banner_mgr.setIs_valid(GlobalConstants.IS_VALID_Y);
			tbl_banner_mgr.setRegby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
			tbl_banner_mgr.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());	
			bannerMgrService.insertTbl_banner_mgr(tbl_banner_mgr);
			
			status.setComplete();				
			mv.setViewName("admin/banner_manager/registDone");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/admin/banner_manager/updateForm.do")
	public ModelAndView updateForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		String banner_mgr_seq = (String) params.get("banner_mgr_seq");
		String curr_page = (String) params.get("curr_page");
		
		Tbl_banner_mgr tbl_banner_mgr = bannerMgrService.getTbl_banner_mgrByBanner_mgr_seq(Long.parseLong(banner_mgr_seq));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/banner_manager/updateForm");
		mv.addObject("tbl_banner_mgr", tbl_banner_mgr);
		mv.addObject("curr_page", curr_page);
		
		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/admin/banner_manager/update.do", method = RequestMethod.POST)
	public ModelAndView update(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Tbl_banner_mgr tbl_banner_mgr, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		String curr_page = (String) params.get("curr_page");
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/banner_manager/updateForm");
		} else {
			tbl_banner_mgr.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
			bannerMgrService.updateTbl_banner_mgr(tbl_banner_mgr);
			
			status.setComplete();
			mv.setViewName("admin/banner_manager/updateDone");
			mv.addObject("curr_page", curr_page);
		}
		
		return mv;
	}
}