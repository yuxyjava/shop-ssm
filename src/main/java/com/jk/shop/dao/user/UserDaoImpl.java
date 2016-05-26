/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:UserDaoImpl.java 
 * 包名:com.jk.shop.dao.user 
 * 创建日期:2016年4月14日下午4:50:16 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.dao.user;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jk.shop.model.user.User;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：UserDaoImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午4:50:16    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午4:50:16    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.user.UserDao#findUserByUserName(java.lang.String)    
	 */
	@Override
	public User findUserByUserName(String userName) {
		return (User) this.getSqlMapClientTemplate().queryForObject("user.findUserByUserName", userName);
	}

}
