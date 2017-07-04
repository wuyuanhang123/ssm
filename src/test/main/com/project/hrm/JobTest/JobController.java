package com.project.hrm.JobTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
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
public class JobController  extends BaseTest{
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
    public void testselectJob() throws Exception{
    	mockMvc.perform((post("/job/selectJob").param("pageIndex", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
    
    /*
     *测试更新请求 
     */
   
    @Test
    public void testupdateJob() throws Exception{
    	mockMvc.perform((post("/job/updateJob").param("name","abc").param("remarks", "abc").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
    
    /*
     * 测试添加请求
     */
    
    @Test
    public void testinsertJob() throws Exception{
    	mockMvc.perform((post("/job/insertJob").param("name", "abc").param("remarks", "1").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
   /*
    * 测试删除请求
    */
    @Test
    public void testdeleteJob() throws Exception{
    	mockMvc.perform((post("/job/deleteJob").param("ids", "1,2").param("remarks", "1").param("flag", "1"))).andExpect(status().isOk())
    	.andDo(print());
    }
}
