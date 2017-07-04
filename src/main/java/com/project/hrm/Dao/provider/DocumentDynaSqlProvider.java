package com.project.hrm.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.project.hrm.domain.Document;



public class DocumentDynaSqlProvider {
	public String selectBypage(Map<String,Object> params){
		  String sql=new SQL(){
			  {
				  SELECT("*");
				  FROM("document_inf");
				  if(params.get("document")!=null){
					  Document document=(Document) params.get("document");
					  if(document.getTitle()!=null&&!document.getTitle().equals("")){
						  WHERE("title LIKE CONCAT('%',#{document.title},'%')");
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
				  FROM("document_inf");
				  if(params.get("document")!=null){
					  Document document=(Document) params.get("document");
					  if(document.getTitle()!=null&&!document.getTitle().equals("")){
						  WHERE("title LIKE CONCAT('%',#{document.title},'%')");
					  }
				  }
			  }
		  }.toString();
	  }
	  public String insertDocument(Document document){
		  return new SQL(){
			  {
				  INSERT_INTO("document_inf");
				  if(document.getTitle()!=null&&!document.getTitle().equals("")){
					  VALUES("title","#{title}");
				  }
				  if(document.getFilename()!=null&&!document.getFilename().equals("")){
					  VALUES("filename","#{filename}");
				  }
				  if(document.getUser()!=null&&document.getUser().getId()!=null){
					  VALUES("user_id","#{user.id}");
				  }
				  if(document.getRemark()!=null&&!document.getRemark().equals("")){
					  VALUES("remark","#{remark}");
				  }
			  }
		  }.toString();
	  }
	  public String updateDocument(Document document){
		  return new SQL(){
			  {
				UPDATE("document_inf");
				if(document.getTitle() != null && !document.getTitle().equals("")){
					SET(" title = #{title} ");
				}
				if(document.getFilename() != null && !document.getFilename().equals("")){
					SET(" filename = #{fileName} ");
				}
				if(document.getRemark() != null && !document.getRemark().equals("")){
					SET("remark = #{remark}");
				}
				if(document.getUser() != null && document.getUser().getId() != null){
					SET("user_id = #{user.id}");
				}
				WHERE(" id = #{id} ");
			  }
		  }.toString();
	  }
}
