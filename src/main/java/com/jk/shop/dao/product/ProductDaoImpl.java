/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductDaoImpl.java 
 * 包名:com.jk.shop.dao.product 
 * 创建日期:2016年4月11日下午3:22:28 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.dao.product;

import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.jk.shop.model.product.Product;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductDaoImpl    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月11日 下午3:22:28    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月11日 下午3:22:28    
 * 修改备注：       
 * @version </pre>    
 */
@Repository
public class ProductDaoImpl extends SqlMapClientDaoSupport implements ProductDao {

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#addProduct(com.jk.shop.model.product.Product)    
	 */
	@Override
	public void addProduct(Product product) {
		this.getSqlMapClientTemplate().insert("product.addProduct", product);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#findProductPageList(com.jk.shop.model.product.Product)    
	 */
	@Override
	public List<Product> findProductPageList(Product product) {
		return this.getSqlMapClientTemplate().queryForList("product.findProductPageList", product);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#findProductListCount(com.jk.shop.model.product.Product)    
	 */
	@Override
	public long findProductListCount(Product product) {
		return (long) this.getSqlMapClientTemplate().queryForObject("product.findProductListCount", product);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#deleteProduct(int)    
	 */
	@Override
	public void deleteProduct(int id) {
		this.getSqlMapClientTemplate().delete("product.deleteProduct", id);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#findProductById(int)    
	 */
	@Override
	public Product findProductById(int id) {
		return (Product) this.getSqlMapClientTemplate().queryForObject("product.findProductById", id);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#updateProduct(com.jk.shop.model.product.Product)    
	 */
	@Override
	public void updateProduct(Product product) {
		this.getSqlMapClientTemplate().update("product.updateProduct", product);
	}

	/* (non-Javadoc)    
	 * @see com.jk.shop.dao.product.ProductDao#deleteBatchProduct(java.util.List)    
	 */
	@Override
	public void deleteBatchProduct(List<Integer> idList) {
		this.getSqlMapClientTemplate().delete("product.deleteBatchProduct", idList);
	}

}
