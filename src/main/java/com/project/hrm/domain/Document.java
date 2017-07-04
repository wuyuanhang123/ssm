package com.project.hrm.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class Document {
   private Integer id;
   private String title;
   private String filename;
   private String remark;
   private Date createDate;
   private User user;
   private MultipartFile file;
public MultipartFile getFile() {
	return file;
}
public void setFile(MultipartFile file) {
	this.file = file;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getFilename() {
	return filename;
}
public void setFilename(String filename) {
	this.filename = filename;
}
public String getRemark() {
	return remark;
}
public void setRemark(String remark) {
	this.remark = remark;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}

public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public String toString() {
	
    return "Document [id=" + id + "title=" + title +"]" ;
}    
   
}
