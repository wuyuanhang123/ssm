package com.project.hrm.Dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.project.hrm.Dao.provider.NoticeDynaSqlProvider;
import com.project.hrm.domain.Notice;

public interface NoticeDao {
   @SelectProvider(type=NoticeDynaSqlProvider.class,method="selectBypage")
   @Results({
	   @Result(id=true,column="id",property="id"),
	   @Result(column="create_date",property="createDate",javaType=java.util.Date.class),
	   @Result(column="user_id",property="user",
	   one=@One(select="com.project.hrm.Dao.UserDao.selectuserByid",
	   fetchType=FetchType.EAGER))
   })
   List<Notice> selectByPage(Map<String,Object> params);
   
   @SelectProvider(type=NoticeDynaSqlProvider.class,method="selectCount")
   Integer countNotice(Map<String,Object> params);
   
   @Select("SELECT * FROM notice_inf WHERE id=#{id}")
   @Results({
	   @Result(id=true,column="id",property="id"),
	   @Result(column="create_date",property="createDate",javaType=java.util.Date.class),
	   @Result(column="user_id",property="user",
	   one=@One(select="com.project.hrm.Dao.UserDao.selectuserByid",
	   fetchType=FetchType.EAGER))
   })
   Notice selectnoticeById(Integer id);
   
   @InsertProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
   void insertNotice(Notice notice);
   
   @UpdateProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
   void updateNotice(Notice notice);
   
   @Delete("DELETE FROM notice_inf WHERE id=#{id}")
   void deletenoticeById(Integer id);
}
