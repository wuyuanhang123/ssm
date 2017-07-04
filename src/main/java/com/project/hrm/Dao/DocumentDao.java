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

import com.project.hrm.Dao.provider.DocumentDynaSqlProvider;
import com.project.hrm.domain.Document;



public interface DocumentDao {
	 @SelectProvider(type=DocumentDynaSqlProvider.class,method="selectBypage")
	   @Results({
		   @Result(id=true,column="id",property="id"),
		   @Result(column="create_date",property="createDate",javaType=java.util.Date.class),
		   @Result(column="user_id",property="user",
		   one=@One(select="com.project.hrm.Dao.UserDao.selectuserByid",
		   fetchType=FetchType.EAGER))
	   })
	   List<Document> selectByPage(Map<String,Object> params);
	   
	   @SelectProvider(type=DocumentDynaSqlProvider.class,method="selectCount")
	   Integer countDocument(Map<String,Object> params);
	   
	   @Select("SELECT * FROM document_inf WHERE id=#{id}")
	   @Results({
		   @Result(id=true,column="id",property="id"),
		   @Result(column="create_date",property="createDate",javaType=java.util.Date.class),
		   @Result(column="user_id",property="user",
		   one=@One(select="com.project.hrm.Dao.UserDao.selectuserByid",
		   fetchType=FetchType.EAGER))
	   })
	   Document selectdocumentById(Integer id);
	   
	   @InsertProvider(type=DocumentDynaSqlProvider.class,method="insertDocument")
	   void insertDocument(Document document);
	   
	   @UpdateProvider(type=DocumentDynaSqlProvider.class,method="updateDocument")
	   void updateDocument(Document document);
	   
	   @Delete("DELETE FROM document_inf WHERE id=#{id}")
	   void deletedocumentById(Integer id);
}
