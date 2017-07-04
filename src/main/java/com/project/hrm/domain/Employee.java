package com.project.hrm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Employee {
  private Integer id;
  private Dept dept;
  private Job job;
  private String name;
  private String card_id;
  private String address;
  private String post_code;
  private String tel;
  private String phone;
  private String qq_num;
  private String email;
  private Integer sex;
  private String party;
  @DateTimeFormat(pattern="yyyy-MM-dd")
  private Date birthday;
  private String race;
  private String education;
  private String speciality;
  private String hobby;
  private String remarks;
  private Date createDate;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Dept getDept() {
	return dept;
}
public void setDept(Dept dept) {
	this.dept = dept;
}
public Job getJob() {
	return job;
}
public void setJob(Job job) {
	this.job = job;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCard_id() {
	return card_id;
}
public void setCard_id(String card_id) {
	this.card_id = card_id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPost_code() {
	return post_code;
}
public void setPost_code(String post_code) {
	this.post_code = post_code;
}
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getQq_num() {
	return qq_num;
}
public void setQq_num(String qq_num) {
	this.qq_num = qq_num;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Integer getSex() {
	return sex;
}
public void setSex(Integer sex) {
	this.sex = sex;
}
public String getParty() {
	return party;
}
public void setParty(String party) {
	this.party = party;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getRace() {
	return race;
}
public void setRace(String race) {
	this.race = race;
}
public String getEducation() {
	return education;
}
public void setEducation(String education) {
	this.education = education;
}
public String getSpeciality() {
	return speciality;
}
public void setSpeciality(String speciality) {
	this.speciality = speciality;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getRemarks() {
	return remarks;
}
public void setRemarks(String remarks) {
	this.remarks = remarks;
}
public Date getCreateDate() {
	return createDate;
}
public void setCreateDate(Date createDate) {
	this.createDate = createDate;
}
public String toString() {
	
    return "Employee [id=" + id + "name=" + name +"]" ;
}    
}
