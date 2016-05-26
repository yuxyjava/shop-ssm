/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductImageService.java 
 * 包名:com.jk.shop.service.product 
 * 创建日期:2016年4月14日下午3:16:35 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.service.product;

import java.util.List;

import com.jk.shop.model.product.ProductImage;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductImageService    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午3:16:35    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午3:16:35    
 * 修改备注：       
 * @version </pre>    
 */
public interface ProductImageService {

	public void addProductImage(ProductImage productImage);
	
	public List<ProductImage> findProductImageList(int id);
	
	public void deleteProductImage(int id);
}
