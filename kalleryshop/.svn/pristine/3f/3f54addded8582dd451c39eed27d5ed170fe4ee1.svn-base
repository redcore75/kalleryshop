package kr.co.redcore.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class AnnotationExceptionHandler {
	private static final Log logger = LogFactory.getLog(AnnotationExceptionHandler.class);
	
    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception ex) {
    	logger.error(this, ex);
    	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/exception");
		mv.addObject("exception", ex.getMessage());
		
		return mv;
    }
    
    @ExceptionHandler(RuntimeException.class) 
    public ModelAndView handleRuntimeException(RuntimeException ex) {
    	logger.error(this, ex);
    	
		ModelAndView mv = new ModelAndView();
		mv.setViewName("common/exception");
		mv.addObject("exception", ex.getMessage());
		
		return mv;
    }
}