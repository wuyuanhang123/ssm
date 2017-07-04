package com.project.hrm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.project.hrm.domain.User;

public class Authorizedlnterceptor implements HandlerInterceptor{
   private static final String[] IGNORE_URI={"/index","/login"};
   /*
    * 该方法将在整个请求完成后执行,主要用于清理资源
    */
   @Override
   public void afterCompletion(HttpServletRequest request,
		   HttpServletResponse response,Object handler,Exception exception)throws Exception{
	   
   }
   /*
    * 该方法在Controller的方法调用后执行,对ModelAndView进行操作
    */
   @Override
   public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView mv)throws Exception{
	   
   }
   /*
    * preHandle方法用于处理器拦截，该方法在Controller处理前调用
    */
   @Override
   public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler)throws Exception{
	  boolean flag=false;
	  String servletPath=request.getServletPath();
	  for(String s:IGNORE_URI){
		  if(servletPath.contains(s))
			  flag=true;
		  break;
	  }
	  if(!flag){
		  User user=(User)request.getSession().getAttribute("user");
		  if(user==null){
			  System.out.println("拦截请求");
			  request.getRequestDispatcher("/index.jsp").forward(request,response);
		  }else{
			  flag=true;
		  }
	  }
	  return flag;
   }
}
