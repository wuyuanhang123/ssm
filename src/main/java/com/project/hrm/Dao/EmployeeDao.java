package com.project.hrm.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.project.hrm.Dao.provider.EmployeeDynaSqlProvider;
import com.project.hrm.domain.Employee;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;

public interface EmployeeDao {
  @SelectProvider(type=EmployeeDynaSqlProvider.class ,method="selectCount")
  Integer countEmployee(Map<String,Object> params);
  
  @SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectBypage")
     @Results({
    	 @Result(id=true,column="id",property="id"),
    	 @Result(column="card_id",property="card_id"),
    	 @Result(column="post_code",property="post_code"),
    	 @Result(column="qq_num",property="qq_num"),
    	 @Result(column="birthday",property="birthday",javaType=java.util.Date.class),
    	 @Result(column="create_date",property="createDate",javaType=java.util.Date.class),
    	 @Result(column="dept_id",property="dept",
    	 one=@One(select="com.project.hrm.Dao.DeptDao.selectdeptById",
    	 fetchType=FetchType.EAGER)),
    	 @Result(column="job_id",property="job",
    	 one=@One(select="com.project.hrm.Dao.JobDao.selectjobById",
    	 fetchType=FetchType.EAGER))   	 
     })
     List<Employee> selectByPage(Map<String,Object> params);
  
  @InsertProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
   void insertEmployee(Employee employee);
  
  @Delete("DELETE FROM employee_inf WHERE id=#{id}")
   void deleteById(Integer id);
  
  @Select("SELECT * FROM employee_inf WHERE id=#{id}")
   @Results({
	   @Result(id=true,column="id",property="id"),
	   @Result(column="card_id",property="card_id"),
	   @Result(column="post_code",property="post_code"),
	   @Result(column="qq_num",property="qq_num"),
	   @Result(column="birthday",property="birthday",javaType=java.util.Date.class),
	   @Result(column="create_date",property="createDate",javaType=java.util.Date.class),
	   @Result(column="dept_id",property="dept",
  	   one=@One(select="com.project.hrm.Dao.DeptDao.selectdeptById",
  	 fetchType=FetchType.EAGER)),
  	   @Result(column="job_id",property="job",
  	   one=@One(select="com.project.hrm.Dao.JobDao.selectjobById",
  	 fetchType=FetchType.EAGER))   	 
   })
   Employee selectemployeeById(Integer id);
  
  @UpdateProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
  void updateEmployee(Employee employee);
}
