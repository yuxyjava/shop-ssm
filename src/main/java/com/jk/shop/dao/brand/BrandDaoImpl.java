/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:BrandDaoImpl.java 
 * 包名:com.jk.shop.dao.brand 
 * 创建日期:2016年4月16日上午11:14:35 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.dao.brand;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jk.shop.model.brand.Brand;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：BrandDaoImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月16日 上午11:14:35    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月16日 上午11:14:35    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class BrandDaoImpl extends SqlMapClientDaoSupport implements BrandDao {

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.brand.BrandDao#findBrandList()    
	 */
	@Override
	public List<Brand> findBrandList() {
		return this.getSqlMapClientTemplate().queryForList("brand.findBrandList");
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.brand.BrandDao#addBrand(com.jk.shop.model.brand.Brand)    
	 */
	@Override
	public void addBrand(Brand brand) {
		this.getSqlMapClientTemplate().insert("brand.addBrand", brand);
	}

}
