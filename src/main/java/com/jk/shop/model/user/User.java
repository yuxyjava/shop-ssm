/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:User.java 
 * 包名:com.jk.shop.model.user 
 * 创建日期:2016年4月14日下午4:46:37 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.model.user;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：User    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午4:46:37    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午4:46:37    
 * 修改备注：       
 * @version </pre>    
 */
public class User implements Serializable{


	private static final long serialVersionUID = -2775477147696076392L;

	private int id;
	
	private String userName;
	
	private String userPassword;
	
	private String validateCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
