package kr.co.redcore.controller.admin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import kr.co.redcore.domain.Tbl_cate_prd;
import kr.co.redcore.domain.Tbl_member;
import kr.co.redcore.domain.Tbl_prd_detail;
import kr.co.redcore.domain.Tbl_prd_opt;
import kr.co.redcore.domain.Tbl_shop_env;
import kr.co.redcore.domain.view.Vw_member;
import kr.co.redcore.domain.view.Vw_prd_mst;
import kr.co.redcore.exception.ImageFileTypeException;
import kr.co.redcore.exception.Member_id_dupException;
import kr.co.redcore.exception.Member_id_not_existException;
import kr.co.redcore.service.CategoryService;
import kr.co.redcore.service.OptGroupService;
import kr.co.redcore.service.ProductService;
import kr.co.redcore.service.ShopEnvService;
import kr.co.redcore.service.member.LoginService;
import kr.co.redcore.service.member.MemberService;
import kr.co.redcore.util.PageHelper;
import kr.co.redcore.util.ParamMap;

@Controller
@SessionAttributes(value = { "tbl_shop_env" })
public class ShopEnvController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(ShopEnvController.class);

	@Autowired
	private Properties configProp;
	
	@Autowired
	private ShopEnvService shopEnvService;
	
	@Autowired
	MessageSource messageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// WebDataBinder에서 수정불가능한 필드를 나열한다.
		dataBinder.setDisallowedFields("shop_id");
	}

	@RequestMapping(value = "/admin/shop_env/updateForm.do")
	public ModelAndView updateForm(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {	
		ModelAndView mv = new ModelAndView();
		
		// 기본shop_id를 셋팅한다.
		Tbl_shop_env tbl_shop_env = shopEnvService.getTbl_shop_envByShop_id(configProp.getProperty("shop_id"));
		if(tbl_shop_env == null) {
			tbl_shop_env = new Tbl_shop_env();
			tbl_shop_env.setShop_id(configProp.getProperty("shop_id"));
		}
		
		mv.setViewName("admin/shop_env/updateForm");
		mv.addObject("tbl_shop_env", tbl_shop_env);
		
		return mv;
	}
	
	@CheckToken
	@RequestMapping(value = "/admin/shop_env/update.do", method = RequestMethod.POST)
	public ModelAndView update(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params, @ModelAttribute @Valid Tbl_shop_env tbl_shop_env, BindingResult bindingResult, SessionStatus status) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		if (!super.validateTokenBindResult(req, bindingResult)) {
			mv.setViewName("admin/shop_env/updateForm");
		} else {
			tbl_shop_env.setShop_id(configProp.getProperty("shop_id"));
			shopEnvService.updateTbl_shop_env(tbl_shop_env);
			
			status.setComplete();
			mv.setViewName("admin/shop_env/updateDone");
		}

		return mv;
	}
}