/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:UserServiceImpl.java 
 * 包名:com.jk.shop.service.user 
 * 创建日期:2016年4月14日下午4:49:07 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.shop.dao.user.UserDao;
import com.jk.shop.model.user.User;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：UserServiceImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午4:49:07    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午4:49:07    
 * 修改备注：       
 * @version </pre>    
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.user.UserService#findUserByUserName(java.lang.String)    
	 */
	@Override
	public User findUserByUserName(String userName) {
		User userInfo = userDao.findUserByUserName(userName);
		return userInfo;
	}

}
