/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:Product.java 
 * 包名:com.jk.shop 
 * 创建日期:2016年4月19日下午5:00:19 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：Product    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月19日 下午5:00:19    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月19日 下午5:00:19    
 * 修改备注：       
 * @version </pre>    
 */
public class Product {

	private int id;
	
	private String name;
	
	private int price;
	
	private String productExplain;
	
	private String productRemark;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getProductExplain() {
		return productExplain;
	}

	public void setProductExplain(String productExplain) {
		this.productExplain = productExplain;
	}

	public String getProductRemark() {
		return productRemark;
	}

	public void setProductRemark(String productRemark) {
		this.productRemark = productRemark;
	}
}
