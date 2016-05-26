/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:Brand.java 
 * 包名:com.jk.shop.model.brand 
 * 创建日期:2016年4月16日上午11:12:37 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.model.brand;

import java.io.Serializable;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：Brand    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月16日 上午11:12:37    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月16日 上午11:12:37    
 * 修改备注：       
 * @version </pre>    
 */
public class Brand implements Serializable{

	private static final long serialVersionUID = -8389885351926189830L;

	private int id;
	
	private String brandName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	
}
