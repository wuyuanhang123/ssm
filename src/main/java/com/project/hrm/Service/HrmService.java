package com.project.hrm.Service;

import java.util.List;


import com.project.hrm.Page.PageModel;
import com.project.hrm.domain.Dept;
import com.project.hrm.domain.Document;
import com.project.hrm.domain.Employee;
import com.project.hrm.domain.Job;
import com.project.hrm.domain.Notice;
import com.project.hrm.domain.User;

public interface HrmService {
   /*
    * 用户登录
    * @param loginname
    * @param password
    * @return User 对象
    */
   User login(String loginname,String password);
   /*
    * 根据id查询用户
    * @param id
    * @return User 对象
    */
   User selectUserByid(Integer id);
   /*
    * 修改用户
    * @param User 对象
    */
   void updateUser(User user);
   /*
    * 模糊查询用户
    * @param User 对象,PageModel 对象
    * return User对象集合List
    */
   List<User> selectAllUser(User user,PageModel pageModel);
   /*
    * 插入用户
    * @param User 对象
    */
   void insertUser(User user);
   /*
    * 根据id删除用户
    * @param id
    */
   void deleteUser(Integer id);
   /*
    * 查询用户总数
    * @param User 对象
    */
   int countUser(User user);
   /*
    * 模糊查询部门，分页查询
    * @param Dept 部门对象
    * @param PageModel 对象
    * @return 返回部门对象集合List
    */
   List<Dept> selectAllDept(Dept dept,PageModel pageModel);
   /*
    * 查询所有部门
    * @return 返回所有部门
    */
   	List<Dept> findAllDept();
   	/*
   	 * 插入新部门
   	 * @param Dept 对象
   	 */
   	void insertDept(Dept dept);
   	/*
   	 * 根据id查询部门
   	 * @param id
   	 * @return 部门
   	 */
   	Dept findDeptById(Integer id);
   	/*
   	 * 修改部门
   	 * @param Dept 部门
   	 */
   	void updateDept(Dept dept);
   	/*
   	 * 根据id删除部门
   	 * @param id
   	 */
   	void deleteDeptById(Integer id);
   	/*
     * 模糊查询部门，分页查询
     * @param Job 职位对象
     * @param PageModel 对象
     * @return 返回职位对象集合List
     */
    List<Job> SelectBypage(Job job,PageModel pageModel);
    /*
     * 查询所有部门
     * @return 返回所有职位
     */
    	List<Job> findAllJob();
    	/*
    	 * 插入新部门
    	 * @param Job 对象
    	 */
    	void insertJob(Job job);
    	/*
    	 * 根据id查询职位
    	 * @param id
    	 * @return 职位
    	 */
    	Job selectJobById(Integer id);
    	/*
    	 * 修改部门
    	 * @param Job 职位
    	 */
    	void updateJob(Job job);
    	/*
    	 * 根据id删除职位
    	 * @param id
    	 */
    	void deletejobById(Integer id);
    	
    	/*
         * 模糊查询部门，分页查询
         * @param Employee 职位对象
         * @param PageModel 对象
         * @return 返回员工对象集合List
         */
    	List<Employee> SelectBypage(Employee employee,PageModel pageModel);

        	/*
        	 * 插入新员工
        	 * @param Employee 对象
        	 */
        	void insertEmployee(Employee employee);
        	/*
        	 * 根据id查询员工
        	 * @param id
        	 * @return 员工
        	 */
        	Employee selectEmployeeById(Integer id);
        	/*
        	 * 修改员工
        	 * @param Employee 员工
        	 */
        	void updateEmployee(Employee employee);
        	/*
        	 * 根据id删除职员
        	 * @param id
        	 */
        	void deleteemployeeById(Integer id);
        	/*
             * 模糊查询部门，分页查询
             * @param Document 公告对象
             * @param PageModel 对象
             * @return 返回公告对象集合List
             */
        	List<Document> SelectBypage(Document document,PageModel pageModel);

            	/*
            	 * 插入新公告
            	 * @param Document 对象
            	 */
            	void insertDocument(Document document);
            	/*
            	 * 根据id查询文件
            	 * @param id
            	 * @return 文件
            	 */
            	Document selectDocumentById(Integer id);
            	/*
            	 * 修改公告
            	 * @param Document 文件
            	 */
            	void updateDocument(Document document);
            	/*
            	 * 根据id删除文件
            	 * @param id
            	 */
            	void deletedocumentById(Integer id);
            	/*
                 * 模糊查询部门，分页查询
                 * @param Notice 公告对象
                 * @param PageModel 对象
                 * @return 返回文件对象集合List
                 */
            	List<Notice> SelectBypage(Notice notie,PageModel pageModel);

                	/*
                	 * 插入新公告
                	 * @param Notice 对象
                	 */
                	void insertNotice(Notice notice);
                	/*
                	 * 根据id查询公告
                	 * @param id
                	 * @return 公告
                	 */
                	Notice selectNoticeById(Integer id);
                	/*
                	 * 修改公告
                	 * @param Notice 公告
                	 */
                	void updateNotice(Notice notice);
                	/*
                	 * 根据id删除公告
                	 * @param id
                	 */
                	void deletenoticeById(Integer id);
}
