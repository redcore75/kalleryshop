package kr.co.redcore.controller.front;

import java.util.Map;
import java.util.Properties;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import kr.co.redcore.controller.BaseController;
import kr.co.redcore.domain.Tbl_shop_env;
import kr.co.redcore.service.ShopEnvService;

@Controller
public class pageViewController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(pageViewController.class);
	
	@Autowired
	private Properties configProp;
	
	@Autowired
	private ShopEnvService shopEnvService;
	
	@RequestMapping(value = "/front/main/pageView.do")
	public ModelAndView pageView(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		String page_id = (String) params.get("page_id");
		
		Tbl_shop_env tbl_shop_env = shopEnvService.getTbl_shop_envByShop_id(configProp.getProperty("shop_id"));
		
		ModelAndView mv = new ModelAndView();
		if(page_id.equals("company")) {
			mv.setViewName(this.getFrontThemeRoute("main/company"));
		} else if(page_id.equals("agreement")) {
			mv.setViewName(this.getFrontThemeRoute("main/agreement"));
		} else if(page_id.equals("private")) {
			mv.setViewName(this.getFrontThemeRoute("main/private"));
		} else if(page_id.equals("privateitem")) {
			mv.setViewName(this.getFrontThemeRoute("main/privateitem"));
		}
		mv.addObject("tbl_shop_env", tbl_shop_env);
		
		return mv;
	}
}
