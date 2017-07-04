package com.project.hrm.DeptTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hrm.BaseTest.BaseTest;
import com.project.hrm.Dao.DeptDao;

import com.project.hrm.Page.PageModel;
import com.project.hrm.domain.Dept;

/*
 * 测试DeptDao包的sql方法
 */
public class DeptTest extends BaseTest{
	
	@Autowired
	  private DeptDao deptdao;
	
    @Ignore
	  @Test
	  public void selectdeptByidTest(){
		  Integer ids=1;
		  Dept dept=deptdao.selectdeptById(ids);
		  System.out.println(dept);
	  }
      @Ignore
	  @Test
	  public void insertDeptTest(){
		  Dept dept=new Dept();
		  dept.setName("管理部");
		  deptdao.insertDept(dept);
	  }
      @Ignore
	  @Test
	  public void updateDeptTest(){
		 Dept dept=new Dept();
		 dept.setId(2);
		 dept.setName("技术部");
		 dept.setRemarks("技术部");
		 deptdao.updateDept(dept);
	  }
      @Ignore
	  @Test
	  public void countDeptTest(){
		  Dept dept=new Dept();
		  dept.setName("技术部");
		  Map<String,Object> params=new HashMap<String,Object>();
		  params.put("dept", dept);
		  int i=deptdao.countDept(params);
		  System.out.println(i);
	  }
      @Ignore
	  @Test
	  public void selectBypageTest(){
		  Map<String,Object> params=new HashMap<String,Object>();
		 Dept dept=new Dept();
		 dept.setName("技术部");
		  PageModel pagemodel=new PageModel();
		  pagemodel.setPageIndex(1);
		  int limit=pagemodel.getFirstLimitParam();
		  System.out.println(limit);
		  pagemodel.setFirstLimitParam(limit);
		  params.put("dept",dept);
		  params.put("pageModel",pagemodel );
		  List<Dept> list=new ArrayList<Dept>();
		  list=deptdao.selectBypage(params);
		  for(int i = 0;i < list.size(); i ++){
			   System.out.println(list.get(i));
			}
	  }
}
