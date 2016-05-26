/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:LoginInterceptor.java 
 * 包名:com.jk.shop.interceptor 
 * 创建日期:2016年4月14日下午5:21:58 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jk.shop.model.user.User;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：LoginInterceptor    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午5:21:58    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午5:21:58    
 * 修改备注：       
 * @version </pre>    
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		User userInfo = (User) request.getSession().getAttribute("user");
		String requestURI = request.getRequestURI();
		System.out.println("============"+requestURI);
		if (requestURI.indexOf("login.jhtml") >= 0) {
			return true;
		} 
		if (null != userInfo) {
			return true;
		} else {
			response.sendRedirect("/login.jsp");
			return false;
		}
	}
}
