/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductImageDaoImpl.java 
 * 包名:com.jk.shop.dao.product 
 * 创建日期:2016年4月14日下午3:18:52 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.dao.product;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jk.shop.model.product.ProductImage;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductImageDaoImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午3:18:52    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午3:18:52    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class ProductImageDaoImpl extends SqlMapClientDaoSupport implements ProductImageDao {

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductImageDao#addProductImage(com.jk.shop.model.product.ProductImage)    
	 */
	@Override
	public void addProductImage(ProductImage productImage) {
		this.getSqlMapClientTemplate().insert("productImage.addProductImage", productImage);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductImageDao#findProductImageList(int)    
	 */
	@Override
	public List<ProductImage> findProductImageList(int id) {
		return this.getSqlMapClientTemplate().queryForList("productImage.findProductImageList", id);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductImageDao#deleteProductImage(int)    
	 */
	@Override
	public void deleteProductImage(int id) {
		this.getSqlMapClientTemplate().delete("productImage.deleteProductImage", id);
	}

}
