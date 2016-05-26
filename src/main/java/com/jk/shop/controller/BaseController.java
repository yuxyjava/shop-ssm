/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:BaseController.java 
 * 包名:com.jk.shop.controller 
 * 创建日期:2016年4月13日下午2:26:02 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：BaseController    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月13日 下午2:26:02    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月13日 下午2:26:02    
 * 修改备注：       
 * @version </pre>    
 */
public class BaseController {

	public void outJson(String json, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
		   response.setCharacterEncoding("utf-8");
		   //response.setContentType("application/json");
		   writer = response.getWriter();
		   writer.write(json);
		   writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (null != writer) {
				writer.close();
				writer = null;
			}
		}
	}
	
	public String getRealPath(String path, HttpServletRequest request) {
		String realPath = request.getSession().getServletContext().getRealPath(path);
		return realPath;
	}
}
