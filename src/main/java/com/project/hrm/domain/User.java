package com.project.hrm.domain;

import java.util.Date;

public class User {
  private Integer id;
  private String loginname;
  private String password;
  private Integer status;
  private Date createDate;
  private String username;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getLoginname() {
	return loginname;
}
public void setLoginname(String loginname) {
	this.loginname = loginname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String toString() {
    return "User [id=" + id + ", userName=" + username + ", password=" + password + ",   ]";
}    
}
