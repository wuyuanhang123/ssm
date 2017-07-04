package com.project.hrm.Controller;



import java.util.List;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.hrm.Page.PageModel;
import com.project.hrm.Service.HrmService;
import com.project.hrm.domain.User;

@Controller

public class UserController {
	
	@Autowired
	@Qualifier("hrmService")
	private HrmService hrmService;
	/*
	 * 处理登录请求
	 * @param String loginname 登录名
	 * @param String password 密码
	 * @return 跳转的视图
	 */
	@RequestMapping(value="/login")	
	public ModelAndView login(
			@RequestParam("loginname") String loginname,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView mv
			){
		
		User user=hrmService.login(loginname, password);
		session.setAttribute("user",user);
		if(user!=null){
		mv.setViewName("main");
		}else{
			mv.setViewName("forward:/index.jsp");
		}
		return mv;
	}
	/*
	 * 模拟查询
	 * @param pageIndex  当前页码
	 * @param User 对象
	 * @param Model model
	 * @return 跳转页
	 */
	@RequestMapping(value="/user/selectUser")
	public String selectUser(Integer pageIndex,
			@ModelAttribute User user,
			Model model){
		System.out.println("user-->"+user);
		PageModel pageModel=new PageModel();
		if(pageIndex!=null){
			pageModel.setPageIndex(pageIndex);
		}
		List<User> users=hrmService.selectAllUser(user, pageModel);
		model.addAttribute("user",user);
		model.addAttribute("users",users);
		model.addAttribute("pageModel",pageModel);
		return "user/user";
	}
	/*
	 * 处理更改请求
	 * @param String flag 数字1表示跳转到更新页面，2表示执行修改操作
	 * @param User 对象
	 * @param ModelAndView mv
	 * @return 跳转页面
	 */
	@RequestMapping(value="/user/updateUser")
	public ModelAndView updateUser(
			String flag,
			@ModelAttribute User user,
			ModelAndView mv){
		if(flag.equals("1")){

			User target=hrmService.selectUserByid(user.getId());
			mv.addObject("user",target);
			mv.setViewName("user/showupdateUser");
		}else{
			hrmService.updateUser(user);
			mv.setViewName("redirect:/user/selectUser");
		}	
		return mv;
	}
	/*
	 * 处理插入请求
	  @param String flag 数字1表示跳转到插入页面，2表示执行插入操作
	 * @param User 对象
	 * @param ModelAndView mv
	 * @return 跳转页面
	 */
	@RequestMapping(value="/user/insertUser")
	public ModelAndView insertUser(
			String flag,
			@ModelAttribute User user,
			ModelAndView mv){
		if(flag.equals("1")){
			mv.setViewName("user/showinsertUser");
		}else{
			hrmService.insertUser(user);
			mv.setViewName("redirect:/user/selectUser");
		}
		return mv;
	}
	
	@RequestMapping(value="/user/deleteUser")
	public ModelAndView removeUser(String ids,ModelAndView mv){
		String[] idArray=ids.split(",");
		for(String id:idArray){
			hrmService.deleteUser(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/user/selectUser");
		return mv;
	}

}