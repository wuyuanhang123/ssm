package com.project.hrm.Dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.project.hrm.Dao.provider.UserDynaSqlProvider;
import com.project.hrm.domain.User;


public interface UserDao {
   @Select ("SELECT * FROM user_inf WHERE loginname=#{loginname} and password=#{password}")
   User selectByLoginnameAndPassword(
			@Param("loginname") String loginname,
			@Param("password") String password);
   
   @Select("SELECT * FROM user_inf WHERE id=#{id}")
   User selectuserByid(Integer id);
   
   @Delete("DELETE FROM user_inf WHERE id=#{id}")
   void deleteuserByid(Integer id);
   
   @UpdateProvider(type=UserDynaSqlProvider.class,method="updateUser")
   void updateUser(User user);
   
   @InsertProvider(type=UserDynaSqlProvider.class,method="insertUser")
   void insertUser(User user);
   
   @SelectProvider(type=UserDynaSqlProvider.class,method="selectBypage")
   List<User> selectBypage(Map<String,Object> params);
   
   @SelectProvider(type=UserDynaSqlProvider.class,method="selectCount")
   Integer countUser(Map<String,Object> params);
}