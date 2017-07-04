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
import com.project.hrm.domain.Employee;
import com.project.hrm.domain.Job;


@Controller
public class EmployeeController {
	@Autowired
	   @Qualifier("hrmService")
	   private HrmService hrmService;
	   
	   /*
		 * 模拟查询
		 * @param pageIndex  当前页码
		 * @param Employee 对象
		 * @param job_id 指代对应职位
 		 * @param dept_id 指代对应部门
		 * @param Model model
		 * @return 跳转页
		 */
		@RequestMapping(value="/employee/selectEmployee")
		public String selectEmployee(Integer pageIndex,
				@ModelAttribute Employee employee,
				Integer dept_id,Integer job_id,
				Model model){
			this.genericaAssociation(job_id, dept_id, employee);
			System.out.println("employee-->"+employee);
			PageModel pageModel=new PageModel();
			if(pageIndex!=null){
				pageModel.setPageIndex(pageIndex);
			}
			
			List<Dept> depts=hrmService.findAllDept();
			List<Job> jobs=hrmService.findAllJob();
			List<Employee> employees=hrmService.SelectBypage(employee, pageModel);
			model.addAttribute("depts",depts);
			model.addAttribute("jobs",jobs);
			model.addAttribute("employee",employee);
			model.addAttribute("employees",employees);
			model.addAttribute("pageModel",pageModel);
			return "employee/employee";
		}
		/*
		 * 处理更改请求
		 * @param String flag 数字1表示跳转到更新页面，2表示执行修改操作
		 * @param Job 对象
		 * @param ModelAndView mv
		 * @return 跳转页面
		 */
		@RequestMapping(value="/employee/updateEmployee")
		public ModelAndView updateEmployee(
				String flag,
				Integer dept_id,Integer job_id,
				@ModelAttribute Employee employee,
				ModelAndView mv){
			if(flag.equals("1")){
				List<Job> jobs=hrmService.findAllJob();
				List<Dept> depts=hrmService.findAllDept();
				Employee target=hrmService.selectEmployeeById(employee.getId());
				mv.addObject("employee",target);
				mv.addObject("jobs",jobs);
				mv.addObject("depts",depts);
				mv.setViewName("employee/showupdateEmployee");
			}else{
				this.genericaAssociation(job_id, dept_id, employee);
				hrmService.updateEmployee(employee);
				mv.setViewName("redirect:/employee/selectEmployee");
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
		@RequestMapping(value="/employee/insertEmployee")
		public ModelAndView insertEmployee(
				String flag,
				@ModelAttribute Employee employee,
				Integer job_id,Integer dept_id,
				ModelAndView mv,
				HttpServletRequest request) {
			try {
				request.setCharacterEncoding("UTF-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			if(flag.equals("1")){
				List<Job> jobs=hrmService.findAllJob();
				List<Dept> depts=hrmService.findAllDept();
				mv.addObject("jobs",jobs);
				mv.addObject("depts",depts);
				mv.setViewName("employee/showinsertEmployee");
			}else{
				this.genericaAssociation(job_id, dept_id, employee);
				hrmService.insertEmployee(employee);
				mv.setViewName("redirect:/employee/selectEmployee");
			}
			return mv;
		}
		
		@RequestMapping(value="/employee/deleteEmployee")
		public ModelAndView removeEmployee(String ids,ModelAndView mv){
			String[] idArray=ids.split(",");
			for(String id:idArray){
				hrmService.deleteemployeeById(Integer.parseInt(id));
			}
			mv.setViewName("redirect:/employee/selectEmployee");
			return mv;
		}
		private void genericaAssociation(Integer job_id,Integer dept_id,Employee employee){
			if(job_id!=null){
				Job job=new Job();
				job.setId(job_id);
				employee.setJob(job);
			}
			if(dept_id!=null){
				Dept dept=new Dept();
				dept.setId(dept_id);
				employee.setDept(dept);
			}
		}
}
