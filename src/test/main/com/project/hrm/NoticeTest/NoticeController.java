package com.project.hrm.NoticeTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.project.hrm.BaseTest.BaseTest;

@WebAppConfiguration(value="src/main/resources")
@TransactionConfiguration(defaultRollback = true)  
@Transactional 
public class NoticeController extends BaseTest{
	@Autowired  
    private WebApplicationContext wac;  //注入Web环境的applicationContext环境
    private MockMvc mockMvc; 
    
    @Before  
    public void setup() {   
        this.mockMvc =MockMvcBuilders.webAppContextSetup(this.wac).build();  
    } 
  
      
    /*
       * 测试模糊查询
       */

    @Test
    public void testselectNotice() throws Exception{
    	mockMvc.perform((post("/employee/selectNotice").param("pageIndex", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
    
    /*
     *测试更新请求 
     */

    @Test
    public void testupdateDept() throws Exception{
    	mockMvc.perform((post("/employee/updateNotice").param("title","abc").param("content", "abc").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
    
    /*
     * 测试添加请求
     */

    @Test
    public void testinsertDept() throws Exception{
    	mockMvc.perform((post("/employee/insertNotice").param("title", "abc").param("content", "1").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
   /*
    * 测试删除请求
    */
    @Test
    public void testdeleteDept() throws Exception{
    	mockMvc.perform((post("/employee/deleteNotice").param("title", "1,2").param("content", "1").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
}
