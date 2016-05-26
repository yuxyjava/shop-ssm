/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:Product.java 
 * 包名:com.jk.shop.model.product 
 * 创建日期:2016年4月11日上午11:17:40 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.model.product;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.jk.shop.model.Page;
import com.jk.shop.model.brand.Brand;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：Product    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月11日 上午11:17:40    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月11日 上午11:17:40    
 * 修改备注：       
 * @version </pre>    
 */
public class Product extends Page implements Serializable{
	
	private static final long serialVersionUID = -8120890579115921480L;

	private int id;
	
	private String productName;
	
	private float price;
	
	private String enterDate;
	
	private int flag;
	
	private float minPrice;
	
	private float maxPrice;
	
	private String productMainImageUrl;
	
	private String productImageUrls;
	
	private String deletedProductImages;
	
	private String productDesc;
	
	private Brand brand = new Brand();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getEnterDate() {
			return enterDate;
	}

	public void setEnterDate(String enterDate) {
		this.enterDate = enterDate;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public float getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(float minPrice) {
		this.minPrice = minPrice;
	}

	public float getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(float maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getProductMainImageUrl() {
		return productMainImageUrl;
	}

	public void setProductMainImageUrl(String productMainImageUrl) {
		this.productMainImageUrl = productMainImageUrl;
	}

	public String getProductImageUrls() {
		return productImageUrls;
	}

	public void setProductImageUrls(String productImageUrls) {
		this.productImageUrls = productImageUrls;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getDeletedProductImages() {
		return deletedProductImages;
	}

	public void setDeletedProductImages(String deletedProductImages) {
		this.deletedProductImages = deletedProductImages;
	}

}
