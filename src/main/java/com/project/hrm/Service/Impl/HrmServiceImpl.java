package com.project.hrm.Service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.hrm.Dao.DeptDao;
import com.project.hrm.Dao.DocumentDao;
import com.project.hrm.Dao.EmployeeDao;
import com.project.hrm.Dao.JobDao;
import com.project.hrm.Dao.NoticeDao;
import com.project.hrm.Dao.UserDao;
import com.project.hrm.Page.PageModel;
import com.project.hrm.Service.HrmService;
import com.project.hrm.domain.Dept;
import com.project.hrm.domain.Document;
import com.project.hrm.domain.Employee;
import com.project.hrm.domain.Job;
import com.project.hrm.domain.Notice;
import com.project.hrm.domain.User;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("hrmService")
public class HrmServiceImpl implements HrmService{

@Autowired
private UserDao userdao;
@Autowired
private DeptDao deptdao;
@Autowired
private JobDao jobdao;
@Autowired
private EmployeeDao employeedao;
@Autowired
private NoticeDao noticedao;
@Autowired
private DocumentDao documentdao;

@Transactional(readOnly=true)
@Override
public User login(String loginname,String password){
	return userdao.selectByLoginnameAndPassword(loginname,password);
}
@Transactional(readOnly=true)
@Override
public User selectUserByid(Integer id){
	return userdao.selectuserByid(id);
}
@Override
 public void updateUser(User user){
	 userdao.updateUser(user);
	
}
 @Transactional(readOnly=true)
 @Override
 public List<User> selectAllUser(User user,PageModel pageModel){
	 Map<String,Object> params=new HashMap<String,Object>();
	 params.put("user",user);
	 int recordCount=userdao.countUser(params);
	 System.out.println("recordCount-->"+recordCount);
	 pageModel.setRecordCount(recordCount);
	 pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
	 if(recordCount>0)
	 {
		 params.put("pageModel", pageModel);
	 }
	 List<User> users=userdao.selectBypage(params);
	 return users;
 }
 @Override
 public void insertUser(User user){
	userdao.insertUser(user); 
 }
 @Override
 public void deleteUser(Integer id){
	 userdao.deleteuserByid(id);
 }
 @Override
 public int countUser(User user){
	 Map<String,Object> params=new HashMap<String,Object>();
	 if(user!=null){
		 params.put("user", user);
	 }
	 return userdao.countUser(params);
 }
 @Transactional(readOnly=true)
 @Override
 public List<Dept> findAllDept(){
	 return deptdao.selectAlldept();
 }
 @Transactional(readOnly=true)
 @Override
 public List<Dept> selectAllDept(Dept dept,PageModel pageModel){
	 Map<String,Object> params=new HashMap<String,Object>();
	 params.put("dept", dept);
	 int recordCount=deptdao.countDept(params);
	 pageModel.setRecordCount(recordCount);
	 pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
	 System.out.println("recordCount-->"+recordCount);
	 if(recordCount>0){
		 params.put("pageModel", pageModel);
	 }
	 List<Dept> depts=deptdao.selectBypage(params);
	 
	 return depts;
 }
 @Override
 public void deleteDeptById(Integer id){
    deptdao.deletedeptById(id);
 }
 @Override
 public void insertDept(Dept dept){
	 deptdao.insertDept(dept);
 }
 @Transactional(readOnly=true)
 @Override
 public Dept findDeptById(Integer id){
	 return deptdao.selectdeptById(id);
 }
 @Override
 public void updateDept(Dept dept){
	  deptdao.updateDept(dept);
 }
 @Transactional(readOnly=true)
 @Override
 public List<Job> findAllJob(){
	 return jobdao.findAllJob();
 }
 @Transactional(readOnly=true)
 @Override
 public List<Job> SelectBypage(Job job,PageModel pageModel){
	 Map<String,Object> params=new HashMap<String,Object>();
	 params.put("job", job);
	 int recordCount=jobdao.countJob(params);
	 pageModel.setRecordCount(recordCount);
	 pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
	 System.out.println("recordCount-->"+recordCount);
	 if(recordCount>0){
		 params.put("pageModel", pageModel);
	 }
	 List<Job> jobs=jobdao.SelectBypage(params);
	 
	 return jobs;
 }
 @Override
 public void deletejobById(Integer id){
    jobdao.deletejobById(id);
 }
 @Override
 public void insertJob(Job job){
	jobdao.insertJob(job);
 }
 @Transactional(readOnly=true)
 @Override
 public Job selectJobById(Integer id){
	 return jobdao.selectjobById(id);
 }
 @Override
 public void updateJob(Job job){
	  jobdao.updateJob(job);
 }
 
 @Transactional(readOnly=true)
 @Override
 public List<Employee> SelectBypage(Employee employee,PageModel pageModel){
	 Map<String,Object> params=new HashMap<String,Object>();
	 params.put("employee", employee);
	 
	 int recordCount=employeedao.countEmployee(params);
	 pageModel.setRecordCount(recordCount);
	 pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
	 System.out.println("recordCount-->"+recordCount);
	 if(recordCount>0){
		 params.put("pageModel", pageModel);
	 }
	 List<Employee> employees=employeedao.selectByPage(params);
	 for(int i=0;i<employees.size();i++){
		 System.out.println(employees.get(i));
	 }
	 return employees;
 }
 @Override
 public void deleteemployeeById(Integer id){
    employeedao.deleteById(id);
 }
 @Override
 public void insertEmployee(Employee employee){
	 employeedao.insertEmployee(employee);
 }
 @Transactional(readOnly=true)
 @Override
 public Employee selectEmployeeById(Integer id){
	 return employeedao.selectemployeeById(id);
 }
 @Override
 public void updateEmployee(Employee employee){
	   employeedao.updateEmployee(employee);
 }
 @Transactional(readOnly=true)
 @Override
 public List<Notice> SelectBypage(Notice notice,PageModel pageModel){
	 Map<String,Object> params=new HashMap<String,Object>();
	 params.put("notice", notice);
	 
	 int recordCount=noticedao.countNotice(params);
	 pageModel.setRecordCount(recordCount);
	 pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
	 System.out.println("recordCount-->"+recordCount);
	 if(recordCount>0){
		 params.put("pageModel", pageModel);
	 }
	 List<Notice> notices=noticedao.selectByPage(params);
	 for(int i=0;i<notices.size();i++){
		 System.out.println(notices.get(i));
	 }
	 return notices;
 }
 @Override
 public void deletenoticeById(Integer id){
     noticedao.deletenoticeById(id);
 }
 @Override
 public void insertNotice(Notice notice){
	  noticedao.insertNotice(notice);
 }
 @Transactional(readOnly=true)
 @Override
 public Notice selectNoticeById(Integer id){
	 return noticedao.selectnoticeById(id);
 }
 @Override
 public void updateNotice(Notice notice){
	   noticedao.updateNotice(notice);
 }
 @Transactional(readOnly=true)
 @Override
 public List<Document> SelectBypage(Document document,PageModel pageModel){
	 Map<String,Object> params=new HashMap<String,Object>();
	 params.put("document", document);
	 
	 int recordCount=documentdao.countDocument(params);
	 pageModel.setRecordCount(recordCount);
	 pageModel.setFirstLimitParam(pageModel.getFirstLimitParam());
	 System.out.println("recordCount-->"+recordCount);
	 if(recordCount>0){
		 params.put("pageModel", pageModel);
	 }
	 List<Document> documents=documentdao.selectByPage(params);
	 for(int i=0;i<documents.size();i++){
		 System.out.println("documents "+documents.get(i));
	 }
	 return documents;
 }
 @Override
 public void deletedocumentById(Integer id){
      documentdao.deletedocumentById(id);
 }
 @Override
 public void insertDocument(Document document){
	  documentdao.insertDocument(document);
 }
 @Transactional(readOnly=true)
 @Override
 public Document selectDocumentById(Integer id){
	 return documentdao.selectdocumentById(id);
 }
 @Override
 public void updateDocument(Document document){
	   documentdao.updateDocument(document);
 }
}
