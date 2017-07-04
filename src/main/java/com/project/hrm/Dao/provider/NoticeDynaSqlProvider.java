package com.project.hrm.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.project.hrm.domain.Notice;



public class NoticeDynaSqlProvider {
	public String selectBypage(Map<String,Object> params){
		  String sql=new SQL(){
			  {
				  SELECT("*");
				  FROM("notice_inf");
				  if(params.get("notice")!=null){
					  Notice notice=(Notice) params.get("notice");
					  if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
						  WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
					  }
					  if(notice.getContent()!=null&&!notice.getContent().equals("")){
						  WHERE("content LIKE CONCAT('%',#{notice.content},'%')");
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
				  FROM("notice_inf");
				  if(params.get("notice")!=null){
					  System.out.println("3");
					  Notice notice=(Notice) params.get("notice");
					  if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
						  WHERE("title LIKE CONCAT('%',#{notice.title},'%')");
					  }
					  if(notice.getContent()!=null&&!notice.getContent().equals("")){
						  WHERE("content LIKE CONCAT('%',#{notice.content},'%')");
					  }
				  }
			  }
		  }.toString();
	  }
	  public String insertNotice(Notice notice){
		  return new SQL(){
			  {
				  INSERT_INTO("notice_inf");
				  if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
					  VALUES("title","#{title}");
				  }
				  if(notice.getContent()!=null&&!notice.getContent().equals("")){
					  VALUES("content","#{content}");
				  }
				  if(notice.getUser()!=null&&notice.getUser().getId()!=null){
					  VALUES("user_id","#{user.id}");
				  }
			  }
		  }.toString();
	  }
	  public String updateNotice(Notice notice){
		  return new SQL(){
			  {
				UPDATE("notice_inf");
				if(notice.getTitle()!=null&&!notice.getTitle().equals("")){
					SET("title=#{title}");
				}
				if(notice.getContent()!=null&&!notice.getContent().equals("")){
					SET("content=#{content}");
				}
				if(notice.getUser()!=null&&notice.getUser().getId()!=null){
					SET("user_id=#{user.id}");
				}
				WHERE("id=#{id}");
			  }
		  }.toString();
	  }
}
