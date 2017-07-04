package com.project.hrm.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.project.hrm.domain.Job;

public class JobDynaSqlProvider {
	 public String selectBypage(Map<String,Object> params){
		  String sql=new SQL(){
			  {
				  SELECT("*");
				  FROM("Job_inf");
				  if(params.get("job")!=null){
					  Job job=(Job) params.get("job");
					  if(job.getName()!=null&&!job.getName().equals("")){
						  WHERE("name LIKE CONCAT('%',#{job.name},'%')");
					  }
				  }
			  }
		  }.toString();
		  if(params.get("pageModel")!=null){
			  sql+=" LIMIT #{pageModel.FirstLimitParam},#{pageModel.pageSize}";
		  }
		  return sql;
	  }
	  public String selectCount(Map<String,Object> params){
		  return new SQL(){
			  {
				SELECT("count(*)");
				FROM("job_inf");
				if(params.get("job")!=null){
					Job job=(Job) params.get("job");
					if(job.getName()!=null&&!job.getName().equals("")){
						WHERE(" name LIKE CONCAT('%',#{job.name},'%')");
					}
				}
			  }
		  }.toString();
	  }
	  public String insertJob(Job job){
		  return new SQL(){
			  {
				  INSERT_INTO("job_inf");
				  if(job.getName()!=null&&!job.getName().equals("")){
					  VALUES("name","#{name}");
				  }
				  if(job.getRemarks()!=null&&!job.getRemarks().equals("")){
					  VALUES("remarks","#{remarks}");
				  }
			  }
		  }.toString();
	  }
	  public String updateJob(Job job){
		  return new SQL(){
			  {
				UPDATE("job_inf");
				if(job.getName()!=null&&!job.getName().equals("")){
					SET("name=#{name}");
				}
				if(job.getRemarks()!=null&&!job.getRemarks().equals("")){
					SET("remarks=#{remarks}");
				}
				WHERE("id=#{id}");
			  }
		  }.toString();
	  }
}
