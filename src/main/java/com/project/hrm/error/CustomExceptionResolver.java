package com.project.hrm.error;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class CustomExceptionResolver implements HandlerExceptionResolver{
  public ModelAndView resolveException(HttpServletRequest request,
		  HttpServletResponse response,Object handler,Exception ex){
	 ex.printStackTrace();
	 CustomException customException=null;
	 
	 if(ex instanceof CustomException){
		 customException=(CustomException) ex;
	 }else{
		 customException=new CustomException("ÏµÍ³Î´Öª´íÎó");
	 }
	 
	 ModelAndView modelAndView=new ModelAndView();
	 modelAndView.addObject("message",customException.getMessage());
	 modelAndView.setViewName("error");
	 
	 return modelAndView;
  }
}
