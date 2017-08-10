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
import kr.co.redcore.domain.Tbl_banner;
import kr.co.redcore.domain.Tbl_banner_mgr;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.view.Vw_banner;
import kr.co.redcore.exception.ImageFileTypeException;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.service.banner.BannerMgrService;
import kr.co.redcore.service.banner.BannerService;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

@Controller
@SessionAttributes(value = { "tbl_banner" })
public class BannerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(BannerController.class);

	@Autowired
	private LoginService loginService;

	@Autowired
	private BannerService bannerService;

	@Autowired
	MessageSource messageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// WebDataBinder에서 수정불가능한 필드를 나열한다.
		dataBinder.setDisallowedFields("banner_seq");
	}

	@RequestMapping(value = "/admin/banner/searchList.do")
	public ModelAndView searchList(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		ParamMap paramMap = new ParamMap();
		paramMap.put("sch_banner_mgr_seq", params.get("sch_banner_mgr_seq"));
		paramMap.put("sch_banner_name", params.get("sch_banner_name"));
		paramMap.put("sch_start_date", params.get("sch_start_date"));
		paramMap.put("sch_end_date", params.get("sch_end_date"));
		
		PageHelper pageHelper;
		if (params.get("curr_page") != null && !params.get("curr_page").equals("")) {
			pageHelper = new PageHelper(Long.parseLong((String) params.get("curr_page")), PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		} else {
			pageHelper = new PageHelper(PageHelper.DEFAULT_CURR_PAGE, PageHelper.DEFAULT_GROUP_SIZE, PageHelper.DEFAULT_PAGE_SIZE);
		}
		bannerService.getPageHelperByParamEtc(paramMap, pageHelper);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/banner/searchList");
		mv.addObject("paramMap", paramMap);
		mv.addObject("pageHelper", pageHelper);
		
		return mv;
	}
	
	@RequestMapping(value = "/admin/banner/registForm.do")
	public ModelAndView registForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		Vw_banner vw_banner = new Vw_banner();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/banner/registForm");
		mv.addObject("vw_banner", vw_banner);
		
		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/admin/banner/regist.do", method = RequestMethod.POST)
	public ModelAndView regist(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Vw_banner vw_banner, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/banner/registForm");
		} else {
			logger.debug("vw_banner.toString() >>> " + vw_banner.toString());
			
			// 파일업로드 처리
			try {
				vw_banner.setImg_path(uploadFile(vw_banner.getImg_file(), getSubImagePath(GlobalConstants.UPLOAD_PATH_IMAGE_BNR)));
			} catch (ImageFileTypeException ex) {
				bindingResult.rejectValue("img_file", "error.image_file");
				mv.setViewName("admin/banner/updateForm");
				return mv;
			} catch (Exception ex) {
				bindingResult.rejectValue("img_file", "error.image_file");
				mv.setViewName("admin/banner/updateForm");				
				return mv;
			}
			
			Tbl_banner tbl_banner = new Tbl_banner();
			tbl_banner.setBanner_mgr_seq(vw_banner.getBanner_mgr_seq());
			tbl_banner.setUrl_addr(vw_banner.getUrl_addr());
			tbl_banner.setText_data(vw_banner.getText_data());
			tbl_banner.setImg_path(vw_banner.getImg_path());
			tbl_banner.setIs_valid(GlobalConstants.IS_VALID_Y);
			tbl_banner.setRegby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());
			tbl_banner.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());	
			bannerService.insertTbl_banner(tbl_banner);
			
			status.setComplete();
			mv.setViewName("admin/banner/registDone");
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/admin/banner/updateForm.do")
	public ModelAndView updateForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {
		String banner_seq = (String) params.get("banner_seq");
		String curr_page = (String) params.get("curr_page");
		
		Vw_banner vw_banner = bannerService.getVw_bannerByBanner_seq(Long.parseLong(banner_seq));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/banner/updateForm");
		mv.addObject("vw_banner", vw_banner);
		mv.addObject("curr_page", curr_page);
		
		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/admin/banner/update.do", method = RequestMethod.POST)
	public ModelAndView update(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Vw_banner vw_banner, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		String curr_page = (String) params.get("curr_page");
		
		if(!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/banner/updateForm");
		} else {
			logger.debug("vw_banner.toString() >>> " + vw_banner.toString());
			
			// 파일업로드 처리
			try {
				vw_banner.setImg_path(uploadFile(vw_banner.getImg_file(), getSubImagePath(GlobalConstants.UPLOAD_PATH_IMAGE_BNR)));
			} catch (ImageFileTypeException ex) {
				bindingResult.rejectValue("img_file", "error.image_file");
				mv.setViewName("admin/banner/updateForm");
				return mv;
			} catch (Exception ex) {
				bindingResult.rejectValue("img_file", "error.image_file");
				mv.setViewName("admin/banner/updateForm");				
				return mv;
			}
			
			Tbl_banner tbl_banner = new Tbl_banner();
			tbl_banner.setBanner_seq(vw_banner.getBanner_seq());
			tbl_banner.setBanner_mgr_seq(vw_banner.getBanner_mgr_seq());
			tbl_banner.setUrl_addr(vw_banner.getUrl_addr());
			tbl_banner.setText_data(vw_banner.getText_data());
			tbl_banner.setImg_path(vw_banner.getImg_path());
			tbl_banner.setIs_valid(vw_banner.getIs_valid());
			tbl_banner.setUptby(loginService.getLoginInfo(req, GlobalConstants.ADMIN_LOGININFO_KEY).getMember_id());	
			bannerService.updateTbl_banner(tbl_banner);
			
			status.setComplete();
			mv.setViewName("admin/banner/updateDone");
		}
		
		return mv;
	}
}