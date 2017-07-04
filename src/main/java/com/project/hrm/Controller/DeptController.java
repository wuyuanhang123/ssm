package com.project.hrm.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.hrm.Page.PageModel;
import com.project.hrm.Service.HrmService;
import com.project.hrm.domain.Dept;


@Controller
public class DeptController {
   @Autowired
   @Qualifier("hrmService")
   private HrmService hrmService;
   
   /*
	 * 模拟查询
	 * @param pageIndex  当前页码
	 * @param Dept 对象
	 * @param Model model
	 * @return 跳转页
	 */
	@RequestMapping(value="/dept/selectDept")
	public String selectDept(Integer pageIndex,
			@ModelAttribute Dept dept,
			Model model){
		System.out.println("dept-->"+dept);
		PageModel pageModel=new PageModel();
		if(pageIndex!=null){
			pageModel.setPageIndex(pageIndex);
		}
		List<Dept> depts=hrmService.selectAllDept(dept, pageModel);
		model.addAttribute("dept",dept);
		model.addAttribute("depts",depts);
		model.addAttribute("pageModel",pageModel);
		return "dept/dept";
	}
	/*
	 * 处理更改请求
	 * @param String flag 数字1表示跳转到更新页面，2表示执行修改操作
	 * @param Dept 对象
	 * @param ModelAndView mv
	 * @return 跳转页面
	 */
	@RequestMapping(value="/dept/updateDept")
	public ModelAndView updateDept(
			String flag,
			@ModelAttribute Dept dept,
			ModelAndView mv){
		if(flag.equals("1")){
                
			Dept target=hrmService.findDeptById(dept.getId());
			mv.addObject("dept",target);
			mv.setViewName("dept/showupdateDept");
		}else{
			hrmService.updateDept(dept);
			mv.setViewName("redirect:/dept/selectDept");
		}	
		return mv;
	}
	/*
	 * 处理插入请求
	  @param String flag 数字1表示跳转到插入页面，2表示执行插入操作
	 * @param Dept 对象
	 * @param ModelAndView mv
	 * @return 跳转页面
	 */
	@RequestMapping(value="/dept/insertDept")
	public ModelAndView insertDept(
			String flag,
			@ModelAttribute Dept dept,
			ModelAndView mv,
			HttpServletRequest request) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    System.out.println(dept.getName());
		if(flag.equals("1")){
			mv.setViewName("dept/showinsertDept");
		}else{
			hrmService.insertDept(dept);
			mv.setViewName("redirect:/dept/selectDept");
		}
		return mv;
	}
	
	@RequestMapping(value="/dept/deleteDept")
	public ModelAndView removeDept(String ids,ModelAndView mv){
		System.out.println("ids "+ids);
		String[] idArray=ids.split(",");
		for(String id:idArray){
			System.out.println(id);
			hrmService.deleteDeptById(Integer.parseInt(id));
		}
		mv.setViewName("redirect:/dept/selectDept");
		return mv;
	}
}
