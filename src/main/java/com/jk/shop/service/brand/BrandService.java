/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:BrandService.java 
 * 包名:com.jk.shop.service.brand 
 * 创建日期:2016年4月16日上午11:12:18 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.brand;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.jk.shop.model.brand.Brand;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：BrandService    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月16日 上午11:12:18    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月16日 上午11:12:18    
 * 修改备注：       
 * @version </pre>    
 */
@WebService
public interface BrandService {
	
	
	public List<Brand> findBrandList();
	
	public void addBrand(Brand brand);
	
	public void addBrandList(List<Brand> brandList);
}
