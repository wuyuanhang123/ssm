package com.project.hrm.Dao.provider;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;


import com.project.hrm.domain.User;

public class UserDynaSqlProvider {
	
	public String selectBypage(Map<String,Object> params){
		String sql= new SQL(){
			{
				SELECT("*");
				FROM("user_inf");
				if(params.get("user")!=null){
					User user=(User)params.get("user");
				if(user.getUsername()!=null&&!user.getUsername().equals("")){
					WHERE("username LIKE CONCAT ('%',#{user.username},'%')");
				}
				if(user.getStatus()!=null&&!user.getStatus().equals("")){
					WHERE("status LIKE CONCAT ('%',#{user.status},'%')");
				}
				}
			}
		}.toString();
		if(params.get("pageModel")!=null){
			sql+=" limit #{pageModel.FirstLimitParam} , #{pageModel.pageSize}";
		}
		return sql;
	}
	
	public String selectCount(Map<String,Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM("user_inf");
				if(params.get("user")!=null){
					User user=(User)params.get("user");
					if(user.getUsername()!=null&&!user.getUsername().equals("")){
						WHERE("username LIKE CONCAT('%',#{user.username},'%')");
					}
					if(user.getStatus()!=null&&!user.getStatus().equals("")){
						WHERE("status LIKE CONCAT('%',#{user.status},'%')");	
					}
				}
			}
		}.toString();
	}
	
    public String updateUser(User user){
    	return new SQL(){
    		{
    		UPDATE("user_inf");
    		if(user.getUsername()!=null){
    			SET("username=#{username}");
    		}
    		if(user.getLoginname()!=null){
    			SET("loginname=#{loginname}");
    		}
    		if(user.getPassword()!=null){
    			SET("password=#{password}");
    		}
    		if(user.getStatus()!=null){
    			SET("status=#{status}");
    		}
    		if(user.getCreateDate()!=null){
    			SET("createdate=#{createdate}");
    		}
    		WHERE ("id=#{id}");
    		}
    	}.toString();
    }
    
    public String insertUser(User user){
    	return new SQL(){
    		{
    		INSERT_INTO("user_inf");
    		if(user.getLoginname()!=null&&!user.getLoginname().equals("")){
    			VALUES("loginname","#{loginname}");
    		}
    		if(user.getUsername()!=null&&!user.getUsername().equals("")){
    			VALUES("username","#{username}");
    		}
    		if(user.getPassword()!=null&&!user.getPassword().equals("")){
    			VALUES("password","#{password}");
    		}
    		if(user.getStatus()!=null&&!user.getStatus().equals("")){
    			VALUES("status","#{status}");
    		}
    		}
    	}.toString();
    }
}
