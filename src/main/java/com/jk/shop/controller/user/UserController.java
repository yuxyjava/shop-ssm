/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:UserController.java 
 * 包名:com.jk.shop.controller.user 
 * 创建日期:2016年4月14日下午4:47:37 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.controller.user;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jk.shop.controller.BaseController;
import com.jk.shop.model.user.User;
import com.jk.shop.service.user.UserService;
import com.jk.shop.util.SystemConstants;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：UserController    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午4:47:37    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午4:47:37    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(User user, HttpServletRequest request) {
		int flag = 0;
		User userInfo = null;
		String validateCode = user.getValidateCode();
		String sessionCode = (String) request.getSession().getAttribute("code");
		if (validateCode.equals(sessionCode)) {
			String userName = user.getUserName();
			String userPassword = user.getUserPassword();
			userInfo = userService.findUserByUserName(userName);
			if (null != userInfo) {
				String userDBPassword = userInfo.getUserPassword();
				if (!userPassword.equals(userDBPassword)) {
					flag = SystemConstants.PASSWORD_ERROR;
				}
			} else {
				flag = SystemConstants.USERNAME_ERROR;
			}
		} else {
			flag = SystemConstants.CODE_ERROR;
		}
		if (flag == 0) {
			request.getSession().setAttribute("user", userInfo);
			return "redirect:/product/findProductList.jhtml";
		} else {
			return "redirect:/login.jsp?error="+flag;
		}
	}
}
