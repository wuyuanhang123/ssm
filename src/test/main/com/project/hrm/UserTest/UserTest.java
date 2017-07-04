package com.project.hrm.UserTest;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.hrm.BaseTest.BaseTest;
import com.project.hrm.Dao.UserDao;
import com.project.hrm.Page.PageModel;
import com.project.hrm.domain.User;
/*
 * 对UseDao的方法进行测试
 */
public class UserTest extends BaseTest {
	
	
  @Autowired
  private UserDao userdao;
  
  @Ignore
  @Test
  public void selectByLoginnameAndPasswordTest(){
	  String loginname="admin";
	  String password="123456";
	  User user=userdao.selectByLoginnameAndPassword(loginname, password);
	  System.out.println(user);
  }
  @Ignore
  @Test
  public void selectuserByidTest(){
	  Integer ids=1;
	  User user=userdao.selectuserByid(ids);
	  System.out.println(user);
  }
  @Ignore
  @Test
  public void insertUserTest(){
	  User user=new User();
	  user.setUsername("jaz");
	  user.setLoginname("ho");
	  user.setStatus(2);
	  user.setPassword("123456");
	  userdao.insertUser(user);
  }
  @Ignore
  @Test
  public void updateUserTest(){
	  User user=new User();
	  user.setUsername("Lisa");
	  user.setLoginname("root2");
	  user.setStatus(1);
	  user.setId(2);
	  userdao.updateUser(user);
  }
  @Ignore
  @Test
  public void countUserTest(){
	  User user=new User();
	  user.setUsername("Lisa");
	  Map<String,Object> params=new HashMap<String,Object>();
	  params.put("user", user);
	  int i=userdao.countUser(params);
	  System.out.println(i);
  }
  @Ignore
  @Test
  public void selectBypageTest(){
	  Map<String,Object> params=new HashMap<String,Object>();
	  User user=new User();
	  user.setPassword("123456");
	  PageModel pagemodel=new PageModel();
	  pagemodel.setPageIndex(4);
	  int limit=pagemodel.getFirstLimitParam();
	  System.out.println(limit);
	  pagemodel.setFirstLimitParam(limit);
	  params.put("user",user);
	  params.put("pageModel",pagemodel );
	  List<User> list=new ArrayList<User>();
	  list=userdao.selectBypage(params);
	  for(int i = 0;i < list.size(); i ++){
		   System.out.println(list.get(i));
		}
  }
}
