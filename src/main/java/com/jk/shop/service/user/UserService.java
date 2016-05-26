/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:UserService.java 
 * 包名:com.jk.shop.service.user 
 * 创建日期:2016年4月14日下午4:48:15 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.user;

import com.jk.shop.model.user.User;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：UserService    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午4:48:15    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午4:48:15    
 * 修改备注：       
 * @version </pre>    
 */
public interface UserService {

	public User findUserByUserName(String userName);
}
