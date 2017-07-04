package com.project.hrm.UserTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.project.hrm.BaseTest.BaseTest;
import com.project.hrm.Controller.UserController;
import com.project.hrm.domain.User;

/*
 * 对UserController类的方法测试
 */
@WebAppConfiguration(value="src/main/resources")
	@TransactionConfiguration(defaultRollback = true)  
	@Transactional 
public class UserControllerTest extends BaseTest{
	private final Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired  
    private WebApplicationContext wac;  //注入Web环境的applicationContext环境
    private MockMvc mockMvc; 
    
    @Before  
    public void setup() {   
        this.mockMvc =MockMvcBuilders.webAppContextSetup(this.wac).build();  
    } 
    /*
     * 对登录验证方法测试
     */
    @Ignore
    @Test  
    public void testLogin() throws Exception {  
    	
        mockMvc.perform((post("/login").param("loginname", "admin").param("password", "123456"))).andExpect(status().isOk())  
                .andDo(print());  
    }
      
    /*
       * 测试模糊查询
       */
   @Ignore
    @Test
    public void testselectUser() throws Exception{
    	mockMvc.perform((post("/user/selectUser").param("username", "Lisa").param("status", "1").param("pageIndex", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
    
    /*
     *测试更新请求 
     */
   @Ignore
    @Test
    public void testupdateUser() throws Exception{
    	mockMvc.perform((post("/user/updateUser").param("username", "Rita").param("id", "1").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
    
    /*
     * 测试添加请求
     */
    @Ignore
    @Test
    public void testinsertUser() throws Exception{
    	mockMvc.perform((post("/user/insertUser").param("username", "Rita").param("status", "1").param("loginname", "admin2").param("password","123").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
}
