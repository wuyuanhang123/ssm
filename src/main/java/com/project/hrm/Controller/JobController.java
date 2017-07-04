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

import com.project.hrm.domain.Job;

@Controller
public class JobController {
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
		@RequestMapping(value="/job/selectJob")
		public String selectJob(Integer pageIndex,
				@ModelAttribute Job job,
				Model model){
			System.out.println("job-->"+job);
			PageModel pageModel=new PageModel();
			if(pageIndex!=null){
				pageModel.setPageIndex(pageIndex);
			}
			List<Job> jobs=hrmService.SelectBypage(job, pageModel);
			model.addAttribute("job",job);
			model.addAttribute("jobs",jobs);
			model.addAttribute("pageModel",pageModel);
			return "job/job";
		}
		/*
		 * 处理更改请求
		 * @param String flag 数字1表示跳转到更新页面，2表示执行修改操作
		 * @param Job 对象
		 * @param ModelAndView mv
		 * @return 跳转页面
		 */
		@RequestMapping(value="/job/updateJob")
		public ModelAndView updateDept(
				String flag,
				@ModelAttribute Job job,
				ModelAndView mv){
			if(flag.equals("1")){
	                
				Job target=hrmService.selectJobById(job.getId());
				mv.addObject("job",target);
				mv.setViewName("job/showupdateJob");
			}else{
				hrmService.updateJob(job);
				mv.setViewName("redirect:/job/selectJob");
			}	
			return mv;
		}
		/*
		 * 处理插入请求
		  @param String flag 数字1表示跳转到插入页面，2表示执行插入操作
		 * @param Job 对象
		 * @param ModelAndView mv
		 * @return 跳转页面
		 */
		@RequestMapping(value="/job/insertJob")
		public ModelAndView insertDept(
				String flag,
				@ModelAttribute Job job,
				ModelAndView mv,
				HttpServletRequest request) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if(flag.equals("1")){
				mv.setViewName("job/showinsertJob");
			}else{
				hrmService.insertJob(job);
				mv.setViewName("redirect:/job/selectJob");
			}
			return mv;
		}
		
		@RequestMapping(value="/dept/deleteJob")
		public ModelAndView removeDept(String ids,ModelAndView mv){
			String[] idArray=ids.split(",");
			for(String id:idArray){
				hrmService.deletejobById(Integer.parseInt(id));
			}
			mv.setViewName("redirect:/job/selectJob");
			return mv;
		}
}
