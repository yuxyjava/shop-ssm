/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:BrandDao.java 
 * 包名:com.jk.shop.dao.brand 
 * 创建日期:2016年4月16日上午11:14:12 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.dao.brand;

import java.util.List;

import com.jk.shop.model.brand.Brand;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：BrandDao    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月16日 上午11:14:12    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月16日 上午11:14:12    
 * 修改备注：       
 * @version </pre>    
 */
public interface BrandDao {

	public List<Brand> findBrandList();

	/** <pre>addBrand(这里用一句话描述这个方法的作用)   
	 * 创建人：于笑扬 yuxy123@gmail.com    
	 * 创建时间：2016年4月18日 上午11:11:52    
	 * 修改人：于笑扬 yuxy123@gmail.com     
	 * 修改时间：2016年4月18日 上午11:11:52    
	 * 修改备注： 
	 * @param brand</pre>    
	 */
	public void addBrand(Brand brand);
}
