package com.project.hrm.EmployeeTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hrm.BaseTest.BaseTest;

import com.project.hrm.Dao.EmployeeDao;
import com.project.hrm.Page.PageModel;

import com.project.hrm.domain.Employee;

public class EmployeeTest  extends BaseTest{
	
	@Autowired
	private EmployeeDao employeedao;
	private final Logger log = LoggerFactory.getLogger(EmployeeTest.class);
	
	@Ignore
	@Test
	  public void selectBypageTest(){
		  Map<String,Object> params=new HashMap<String,Object>();
		  PageModel pageModel=new PageModel();
		  pageModel.setPageIndex(1);
		  pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
		  params.put("pageModel", pageModel);
		  List<Employee> employees=employeedao.selectByPage(params);
		  int record=employeedao.countEmployee(params);
		  System.out.println(record);
		  for(int i=0;i<employees.size();i++){
				 System.out.println(employees.get(i));
			 }
	
}
	@Ignore
	@Test
	public void selectemployeeByIdTest(){
		Integer id=1;
		Employee employee=employeedao.selectemployeeById(id);
		System.out.println(employee);
		log.debug("´íÎó");
	}
	@Ignore
	@Test
	public void insertEmployeeTest(){
		Employee employee=new Employee();
		employee.setEmail("1231@qq.com");
		employee.setRemarks("2222");
		employee.setHobby("2");
		employeedao.insertEmployee(employee);
	}

	  @Test
	  public void updateDeptTest(){
		 Employee employee=new Employee();
		 employee.setId(1);
		 employee.setName("Lisa");
		 employeedao.updateEmployee(employee);
	  }

	  @Test
	  public void countDeptTest(){
		  Employee employee=new Employee();
		  employee.setName("Lisa");
		  Map<String,Object> params=new HashMap<String,Object>();
		  params.put("employee",employee);
		  int i=employeedao.countEmployee(params);
		  System.out.println(i);
	  }
}