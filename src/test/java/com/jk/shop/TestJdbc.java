/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:TestJdbc.java 
 * 包名:com.jk.shop 
 * 创建日期:2016年4月18日上午11:42:35 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;


/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：TestJdbc    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月18日 上午11:42:35    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月18日 上午11:42:35    
 * 修改备注：       
 * @version </pre>    
 */
public class TestJdbc {
	
	@Test
	public void TestBatchAdd() {
		  PreparedStatement pstmt = null;
		  Connection conn = null;  
		  try {  
		   Class.forName("oracle.jdbc.driver.OracleDriver");  
		   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "shop_ssi", "123");  
		   String sql = "insert into t_book (id, bookName, bookPrice) values (SEQ_BOOK_ID.nextval, ?, ?)";
		   pstmt = conn.prepareStatement(sql);
		   for (int i = 0; i < 999999999; i++) {
			   pstmt.setString(1, "zhangsan"+i); 
			   pstmt.setInt(2, i);
//			   pstmt.execute();
			   System.out.println("============="+i);
			   pstmt.addBatch();
				if (i > 0 && i % 1000 == 0) {
					System.out.println("=============");
					pstmt.executeBatch();
				}
		   }
		   pstmt.executeBatch();
		  } catch (ClassNotFoundException e) {  
		   e.printStackTrace();  
		  } catch (SQLException e) {  
		   e.printStackTrace();  
		  } finally {  
		   try {  
		    if(pstmt != null) {  
		    	pstmt.close();  
		    	pstmt = null;  
		    }  
		    if(conn != null) {  
		     conn.close();  
		     conn = null;  
		    }  
		   } catch (SQLException e) {  
		    e.printStackTrace();  
		   }  
		  }  
	}
}
