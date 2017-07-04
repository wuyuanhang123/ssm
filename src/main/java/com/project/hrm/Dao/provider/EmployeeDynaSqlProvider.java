package com.project.hrm.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.project.hrm.domain.Employee;



public class EmployeeDynaSqlProvider {
	 public String selectBypage(Map<String,Object> params){
		  String sql=new SQL(){
			  {
				  SELECT("*");
				  FROM("employee_inf");
				  if(params.get("employee")!=null){
					  Employee employee=(Employee) params.get("employee");
					  if(employee.getDept()!=null&&employee.getDept().getId()!=null&&employee.getDept().getId()!=0){
						  WHERE("dept_id=#{employee.dept.id}");
					  }
					  if(employee.getJob()!=null&&employee.getJob().getId()!=null&&employee.getJob().getId()!=0){
						  WHERE("job_id=#{employee.job.id}");
					  }
					  if(employee.getName()!=null&&!employee.getName().equals("")){
						  WHERE("name LIKE CONCAT('%',#{employee.name},'%')");
					  }
					  if(employee.getPhone()!=null&&!employee.getPhone().equals("")){
						  WHERE("phone LIKE CONCAT('%',#{employee.phone},'%')");
					  }
					  if(employee.getCard_id()!=null&&!employee.getCard_id().equals("")){
						  WHERE("phone LIKE CONCAT('%',#{employee.card_id},'%')");
					  }
					  if(employee.getSex()!=null&&employee.getSex()!=0){
						  WHERE("sex=#{employee.sex}");
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
				FROM("employee_inf");
				if(params.get("employee")!=null){
					Employee employee=(Employee) params.get("employee");
					if(employee.getDept()!=null&&employee.getDept().getId()!=null&&employee.getDept().getId()!=0){
						WHERE("dept_id=#{employee.dept.id}");
					}
					if(employee.getJob()!=null&&employee.getJob().getId()!=null&&employee.getJob().getId()!=0){
						WHERE("job_id=#{employee.job.id}");
					}
					if(employee.getName()!=null&&!employee.getName().equals("")){
						WHERE(" name LIKE CONCAT('%',#{employee.name},'%')");
					}
					if(employee.getPhone()!=null&&!employee.getPhone().equals("")){
						  WHERE("phone LIKE CONCAT('%',#{employee.phone},'%')");
					  }
					  if(employee.getCard_id()!=null&&!employee.getCard_id().equals("")){
						  WHERE("phone LIKE CONCAT('%',#{employee.card_id},'%')");
					  }
					  if(employee.getSex()!=null&&employee.getSex()!=0){
						  WHERE("sex=#{employee.sex}");
					  }
				}
			  }
		  }.toString();
	  }
	  public String insertEmployee(Employee employee){
		  return new SQL(){
			  {
				  INSERT_INTO("employee_inf");
				  if(employee.getName()!=null&&!employee.getName().equals("")){
					  VALUES("name","#{name}");
				  }
				  if(employee.getCard_id()!=null&&!employee.getCard_id().equals("")){
					  VALUES("card_id","#{card_id}");
				  }
				  if(employee.getAddress()!=null&&!employee.getAddress().equals("")){
					  VALUES("address","#{address}");
				  }
				  if(employee.getPost_code()!=null&&!employee.getPost_code().equals("")){
					  VALUES("post_code","#{post_code}");
				  }
				  if(employee.getTel()!=null&&!employee.getTel().equals("")){
					  VALUES("tel","#{tel}");
				  }
				  if(employee.getPhone()!=null&&!employee.getPhone().equals("")){
					  VALUES("phone","#{phone}");
				  }
				  if(employee.getQq_num()!=null&&!employee.getQq_num().equals("")){
					  VALUES("qq_num","#{qq_num}");
				  }
				  if(employee.getEmail()!=null&&!employee.getEmail().equals("")){
					  VALUES("email","#{email}");
				  }
				  if(employee.getSex()!=null&&!employee.getEmail().equals("")){
					  VALUES("sex","#{sex}");
				  }
				  if(employee.getParty()!=null&&!employee.getParty().equals("")){
					  VALUES("party","#{party}");
				  }
				  if(employee.getBirthday()!=null&&!employee.getBirthday().equals("")){
					  VALUES("birthday","#{birthday}");
				  }
				  if(employee.getRace()!=null&&!employee.getRace().equals("")){
					  VALUES("race","#{race}");
				  }
				  if(employee.getEducation()!=null&&!employee.getEducation().equals("")){
					  VALUES("education","#{education}");
				  }
				  if(employee.getSpeciality()!=null&&!employee.getSpeciality().equals("")){
					  VALUES("speciality","#{speciality}");
				  }
				  if(employee.getHobby()!=null&&!employee.getHobby().equals("")){
					  VALUES("hobby","#{hobby}");
				  }
				  if(employee.getRemarks()!=null&&!employee.getRemarks().equals("")){
					  VALUES("remark","#{remarks}");
				  }
				  if(employee.getCreateDate()!=null&&!employee.getCreateDate().equals("")){
					  VALUES("createDate","#{createDate}");
				  }
				  if(employee.getDept()!=null&&!employee.getDept().equals("")){
					  VALUES("dept_id","#{dept.id}");
				  }
				  if(employee.getJob()!=null&&!employee.getJob().equals("")){
					  VALUES("job_id","#{job.id}");
				  }
			  }
		  }.toString();
	  }
	  public String updateEmployee(Employee employee){
		  return new SQL(){
			  {
				UPDATE("dept_inf");
				if(employee.getName()!=null&&!employee.getName().equals("")){
					  SET("name=#{name}");
				  }
				  if(employee.getCard_id()!=null&&!employee.getCard_id().equals("")){
					  SET("card_id=#{card_id}");
				  }
				  if(employee.getAddress()!=null&&!employee.getAddress().equals("")){
					  SET("address=#{address}");
				  }
				  if(employee.getPost_code()!=null&&!employee.getPost_code().equals("")){
					  SET("post_post=#{post_post}");
				  }
				  if(employee.getTel()!=null&&!employee.getTel().equals("")){
					  SET("tel=#{tel}");
				  }
				  if(employee.getPhone()!=null&&!employee.getPhone().equals("")){
					  SET("phone=#{phone}");
				  }
				  if(employee.getQq_num()!=null&&!employee.getQq_num().equals("")){
					  SET("qq_num=#{qq_num}");
				  }
				  if(employee.getEmail()!=null&&!employee.getEmail().equals("")){
					  SET("email=#{email}");
				  }
				  if(employee.getSex()!=null&&!employee.getEmail().equals("")){
					  SET("sex=#{sex}");
				  }
				  if(employee.getParty()!=null&&!employee.getParty().equals("")){
					  SET("party=#{party}");
				  }
				  if(employee.getBirthday()!=null&&!employee.getBirthday().equals("")){
					  SET("birthday=#{birthday}");
				  }
				  if(employee.getRace()!=null&&!employee.getRace().equals("")){
					  SET("race=#{race}");
				  }
				  if(employee.getEducation()!=null&&!employee.getEducation().equals("")){
					  SET("education=#{education}");
				  }
				  if(employee.getSpeciality()!=null&&!employee.getSpeciality().equals("")){
					  SET("speciality=#{speciality}");
				  }
				  if(employee.getHobby()!=null&&!employee.getHobby().equals("")){
					  SET("hobby=#{hobby}");
				  }
				  if(employee.getRemarks()!=null&&!employee.getRemarks().equals("")){
					  SET("remarks=#{remarks}");
				  }
				  if(employee.getCreateDate()!=null&&!employee.getCreateDate().equals("")){
					  SET("createDate=#{createDate}");
				  }
				  if(employee.getDept()!=null&&!employee.getDept().equals("")){
					  SET("dept_id=#{dept.id}");
				  }
				  if(employee.getJob()!=null&&!employee.getJob().equals("")){
					  SET("job_id=#{job.id}");
				  }
				  WHERE("id=#{id}");
			  }
		  }.toString();
	  }
}
