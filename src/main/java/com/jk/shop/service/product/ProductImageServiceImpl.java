/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductImageServiceImpl.java 
 * 包名:com.jk.shop.service.product 
 * 创建日期:2016年4月14日下午3:17:29 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.shop.dao.product.ProductImageDao;
import com.jk.shop.model.product.ProductImage;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductImageServiceImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午3:17:29    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午3:17:29    
 * 修改备注：       
 * @version </pre>    
 */
@Service("productImageService")
public class ProductImageServiceImpl implements ProductImageService {
	
	@Autowired
	private ProductImageDao productImageDao;

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductImageService#addProductImage(com.jk.shop.model.product.ProductImage)    
	 */
	@Override
	public void addProductImage(ProductImage productImage) {
		productImageDao.addProductImage(productImage);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductImageService#findProductImageList(int)    
	 */
	@Override
	public List<ProductImage> findProductImageList(int id) {
		return productImageDao.findProductImageList(id);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.service.product.ProductImageService#deleteProductImage(int)    
	 */
	@Override
	public void deleteProductImage(int id) {
		productImageDao.deleteProductImage(id);
	}

}
