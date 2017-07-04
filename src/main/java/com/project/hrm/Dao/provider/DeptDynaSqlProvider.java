package com.project.hrm.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.project.hrm.domain.Dept;

public class DeptDynaSqlProvider {
  public String selectBypage(Map<String,Object> params){
	  String sql=new SQL(){
		  {
			  SELECT("*");
			  FROM("dept_inf");
			  if(params.get("dept")!=null){
				  Dept dept=(Dept) params.get("dept");
				  if(dept.getName()!=null&&!dept.getName().equals("")){
					  WHERE("name LIKE CONCAT('%',#{dept.name},'%')");
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
			FROM("dept_inf");
			if(params.get("dept")!=null){
				Dept dept=(Dept) params.get("dept");
				if(dept.getName()!=null&&!dept.getName().equals("")){
					WHERE(" name LIKE CONCAT('%',#{dept.name},'%')");
				}
			}
		  }
	  }.toString();
  }
  public String insertDept(Dept dept){
	  return new SQL(){
		  {
			  INSERT_INTO("dept_inf");
			  if(dept.getName()!=null&&!dept.getName().equals("")){
				  VALUES("name","#{name}");
			  }
			  if(dept.getRemarks()!=null&&!dept.getRemarks().equals("")){
				  VALUES("remarks","#{remarks}");
			  }
		  }
	  }.toString();
  }
  public String updateDept(Dept dept){
	  return new SQL(){
		  {
			UPDATE("dept_inf");
			if(dept.getName()!=null&&!dept.getName().equals("")){
				SET("name=#{name}");
			}
			if(dept.getRemarks()!=null&&!dept.getRemarks().equals("")){
				SET("remarks=#{remarks}");
			}
			WHERE("id=#{id}");
		  }
	  }.toString();
  }
}
