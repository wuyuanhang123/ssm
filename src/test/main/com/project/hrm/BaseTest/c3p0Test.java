package com.project.hrm.BaseTest;



import java.sql.Connection;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/*
 * 检测数据库连接情况
 */

public class c3p0Test extends BaseTest{
  @Autowired
  private SqlSessionFactory sqlSessionFactory;
  
@Test
public void testConn() throws SQLException{
	Connection con=sqlSessionFactory.openSession().getConnection();
	System.out.println(con);
	con.close();
}
  
}
