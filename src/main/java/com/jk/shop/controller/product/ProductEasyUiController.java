/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:ProductEasyUiController.java 
 * 包名:com.jk.shop.controller.product 
 * 创建日期:2016年4月28日上午10:00:01 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.controller.product;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.shop.controller.BaseController;
import com.jk.shop.model.brand.Brand;
import com.jk.shop.model.product.Product;
import com.jk.shop.model.product.ProductImage;
import com.jk.shop.service.brand.BrandService;
import com.jk.shop.service.product.ProductImageService;
import com.jk.shop.service.product.ProductService;

import net.sf.json.JSONObject;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：ProductEasyUiController    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月28日 上午10:00:01    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月28日 上午10:00:01    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/productEasyUi")
public class ProductEasyUiController extends BaseController{
	
	@Resource(name="productService")
	private ProductService productService;
	
	@Resource(name="brandService")
	private BrandService brandService;
	
	@Resource(name="productImageService")
	private ProductImageService productImageService;
	
	@RequestMapping("toProductList")
	public String toProductList(ModelMap modelMap) {
		List<Brand> brandList = brandService.findBrandList();
		modelMap.put("brandList", brandList);
		return "product_easyui/productList";
	}
	
	@RequestMapping("addProduct")
	public void addProduct(Product product, HttpServletResponse response) {
		productService.addProduct(product);
		outJson("{\"success\":true}", response);
	}
	
	@RequestMapping("toAddProduct")
	public String toAddProduct(ModelMap modelMap) {
		List<Brand> brandList = brandService.findBrandList();
		modelMap.put("brandList", brandList);
		return "product_easyui/addProduct";
	}
	
	@RequestMapping("toUpdateProduct")
	public String toUpdateProduct(int id, ModelMap modelMap) {
		Product product = productService.findProductById(id);
		List<Brand> brandList = brandService.findBrandList();
		List<ProductImage> productImageList = productImageService.findProductImageList(id);
		modelMap.put("brandList", brandList);
		modelMap.put("product", product);
		modelMap.put("productImageList", productImageList);
		return "product_easyui/updateProduct";
	}
	
	@RequestMapping("updateProduct")
	public void updateProduct(Product product, HttpServletResponse response) {
		productService.updateProduct(product);
		outJson("{\"success\":true}", response);
	}
	
	@RequestMapping("findProductList")
	public void findProductList(Product product, HttpServletResponse response, HttpServletRequest request) {
		int pageIndex = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("rows"));
		long total = productService.findProductListCount(product);
		int startPos =  ( pageIndex - 1 ) * pageSize;
		int endPos = pageIndex * pageSize;
		product.setStartPos(startPos);
		product.setEndPos(endPos);
		List<Product> productList = productService.findProductPageList(product);
		Map map = new HashMap();
		map.put("total", total);
		map.put("rows", productList);
		String productListJson = JSONObject.fromObject(map).toString();
		outJson(productListJson, response);
	}
}
