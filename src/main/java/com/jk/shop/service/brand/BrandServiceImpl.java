/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:BrandServiceImpl.java 
 * 包名:com.jk.shop.service.brand 
 * 创建日期:2016年4月16日上午11:13:42 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.brand;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.shop.dao.brand.BrandDao;
import com.jk.shop.model.brand.Brand;
import com.jk.shop.util.CacheManager;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：BrandServiceImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月16日 上午11:13:42    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月16日 上午11:13:42    
 * 修改备注：       
 * @version </pre>    
 */
@Service("brandService")
@WebService
public class BrandServiceImpl implements BrandService {
	
	@Autowired
	private BrandDao brandDao;

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.brand.BrandService#findBrandList()    
	 */
	@Override
	public List<Brand> findBrandList() {
		Object brandListInfo = CacheManager.getInstance().getObj("brandList");
		/*if (null != brandListInfo) {
			return (List) brandListInfo;
		} else {
			List<Brand> brandList = brandDao.findBrandList();
			CacheManager.getInstance().putObj("brandList", brandList);
			return brandList;
		}*/
		if (null == brandListInfo) {
			brandListInfo = brandDao.findBrandList();
			CacheManager.getInstance().putObj("brandList", brandListInfo);
		}
		return (List<Brand>) brandListInfo;
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.brand.BrandService#addBrand(com.jk.shop.model.brand.Brand)    
	 */
	@Override
	public void addBrand(Brand brand) {
		brandDao.addBrand(brand);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.brand.BrandService#addBrandList(java.util.List)    
	 */
	@Override
	public void addBrandList(List<Brand> brandList) {
		for (Brand brand : brandList) {
			brandDao.addBrand(brand);
		}
		CacheManager.getInstance().remove("brandList");
	}

}
