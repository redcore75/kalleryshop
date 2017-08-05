package kr.co.redcore.controller.admin;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import kr.co.redcore.controller.BaseController;
import kr.co.redcore.util.ParamMap;

@Controller
public class CateManagerController extends BaseController {
	private static final Logger logger = LoggerFactory.getLogger(CateManagerController.class);

	@Autowired
	MessageSource messageSource;
	
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		// WebDataBinder에서 수정불가능한 필드를 나열한다.
	}

	@RequestMapping(value = "/admin/cate_manager/cateList.do")
	public ModelAndView cateList(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		ParamMap paramMap = new ParamMap();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/cate_manager/cateList");
		mv.addObject("paramMap", paramMap);
		
		return mv;
	}
	
	@RequestMapping(value = "/admin/cate_manager/catePrdList.do")
	public ModelAndView catePrdList(HttpSession session, HttpServletRequest req, HttpServletResponse res, @RequestParam Map<String, Object> params) throws Exception {		
		ParamMap paramMap = new ParamMap();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/cate_manager/catePrdList");
		mv.addObject("paramMap", paramMap);
		
		return mv;
	}
}