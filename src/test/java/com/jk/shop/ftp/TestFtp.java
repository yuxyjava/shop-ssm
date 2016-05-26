/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:TestFtp.java 
 * 包名:com.jk.shop.ftp 
 * 创建日期:2016年4月20日上午8:25:52 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.ftp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：TestFtp    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月20日 上午8:25:52    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月20日 上午8:25:52    
 * 修改备注：       
 * @version </pre>    
 */
public class TestFtp {
	@Test
	public void testUpload() throws FileNotFoundException {
//		FileInputStream fis = new FileInputStream("d:/info.jpg");
//		FtpUtil.uploadFile("192.168.66.100", 21, "yuxy", "123456", "/s1/s2", "a.jpg", fis);
		String userName = "aaa;bbb;ccc;ddd";
		String[] userNameArr = userName.split(";");
		System.out.println(userNameArr[1]);
	}
}
