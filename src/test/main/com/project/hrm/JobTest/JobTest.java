package com.project.hrm.JobTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hrm.BaseTest.BaseTest;

import com.project.hrm.Dao.JobDao;
import com.project.hrm.Page.PageModel;
import com.project.hrm.domain.Job;


/*
 * 测试jobdao方法
 */
public class JobTest  extends BaseTest{
	@Autowired
	  private JobDao jobdao;
	

	  @Test
	  public void selectjobByidTest(){
		  Integer ids=1;
		  Job job=jobdao.selectjobById(ids);
		  System.out.println(job);
	  }

	  @Test
	  public void insertJobTest(){
		  Job job=new Job();
		  job.setName("职员");
		  jobdao.insertJob(job);
	  }

	  @Test
	  public void updateJobTest(){
		 Job job=new Job();
		 job.setId(2);
		 job.setName("职员");
		 jobdao.updateJob(job);
    }
	  @Test
	  public void countDeptTest(){
		  Job job=new Job();
		  job.setName("职员");
		  Map<String,Object> params=new HashMap<String,Object>();
		  params.put("job", job);
		  int i=jobdao.countJob(params);
		  System.out.println(i);
	  }

	  @Test
	  public void selectBypageTest(){
		  Map<String,Object> params=new HashMap<String,Object>();
				  PageModel pagemodel=new PageModel();
		  pagemodel.setPageIndex(1);
		  int limit=pagemodel.getFirstLimitParam();	 
		  pagemodel.setFirstLimitParam(limit);	  
		  params.put("pageModel",pagemodel );	 
		 List<Job> list=jobdao.SelectBypage(params);
		  for(int i = 0;i < list.size(); i ++){
			   System.out.println(list.get(i));
			}
	  }
}
