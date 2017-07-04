package com.project.hrm.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.project.hrm.Dao.provider.DeptDynaSqlProvider;
import com.project.hrm.domain.Dept;

public interface DeptDao {
  
@Select("SELECT * FROM dept_inf WHERE id=#{id}")
  public Dept selectdeptById(Integer id);
  
 @Delete("DELETE FROM dept_inf WHERE id=#{id}")
  public void deletedeptById(Integer id);
 
 @Select("SELECT * FROM dept_inf")
  public List<Dept> selectAlldept(); 
 
 @SelectProvider(type=DeptDynaSqlProvider.class,method="selectBypage")
  public List<Dept> selectBypage(Map<String,Object> params);
 
 @SelectProvider(type=DeptDynaSqlProvider.class ,method="selectCount")
 public int countDept(Map<String,Object> params);
 
 @UpdateProvider(type=DeptDynaSqlProvider.class,method="updateDept")
 public void updateDept(Dept dept);
 
 @InsertProvider(type=DeptDynaSqlProvider.class,method="insertDept")
 public void insertDept(Dept dept);
}
