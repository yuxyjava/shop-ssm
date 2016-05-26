/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductImage.java 
 * 包名:com.jk.shop.model.product 
 * 创建日期:2016年4月14日下午2:24:16 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.model.product;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductImage    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月14日 下午2:24:16    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月14日 下午2:24:16    
 * 修改备注：       
 * @version </pre>    
 */
public class ProductImage implements Serializable{
	
	private static final long serialVersionUID = -734890189617698836L;

	private int id;
	
	private String path;
	
	private int productId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
