/** 
 * <pre>项目名称:shop-ssi 
 * 文件名称:ProductController.java 
 * 包名:com.jk.shop.controller.product 
 * 创建日期:2016年4月11日上午11:19:11 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.controller.product;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jk.shop.controller.BaseController;
import com.jk.shop.model.brand.Brand;
import com.jk.shop.model.product.Product;
import com.jk.shop.service.brand.BrandService;
import com.jk.shop.service.product.ProductService;
import com.jk.shop.util.FileUtil;
import com.jk.shop.util.FtpUtil;
import com.jk.shop.util.SystemConstants;

/** 
 * <pre>项目名称：shop-ssi    
 * 类名称：ProductController    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月11日 上午11:19:11    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月11日 上午11:19:11    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/product")
public class ProductController extends BaseController{
	
	@Resource(name="productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("brandService")
	private BrandService brandService;
	
	@RequestMapping(value="/toAddProduct.jhtml", method=RequestMethod.GET)
	public String toAddProduct(ModelMap productMap) {
		List<Brand> brandList = brandService.findBrandList();
		productMap.put("brandList", brandList);
		return "product/addProduct";
	}
	
	@RequestMapping(value="/addProduct.jhtml", method=RequestMethod.POST)
	public String addProduct(Product product, String productName, HttpServletRequest request, HttpServletResponse response) {
		productService.addProduct(product);
		return "redirect:/product/findProductList.jhtml";
	}
	
	@RequestMapping(value="deleteBatchProduct", method=RequestMethod.POST)
	public void deleteBatchProduct(String ids, HttpServletResponse response) {
		productService.deleteBatchProduct(ids);
		outJson("{\"success\":true}", response);
	}
	
	@RequestMapping(value="/findProductList.jhtml")
	public String findProductList(ModelMap map, Product product) {
//		List<Product> productList = new ArrayList<Product>();
//		Product p1 = new Product();
//		p1.setProductName("小米");
//		p1.setPrice(500);
//		Product p2 = new Product();
//		p2.setProductName("华为");
//		p2.setPrice(700);
//		productList.add(p1);
//		productList.add(p2);
//		map.put("productList", productList);
		// 获取总条数
		long totalCount = productService.findProductListCount(product);
		// 设置总条数
		product.setTotalCount(totalCount);
		// 计算分页信息
		product.calculatePage();
		// 获取分页列表
		List<Product> productList = productService.findProductPageList(product);
		map.put("productList", productList);
		map.put("page", product);
		if (1 == product.getFlag()) {
			// ajaxPage
			return "product/productPageList";
		} else {
			return "product/productList";
		}
	}
	
	@RequestMapping(value="uploadProductImage")
	public void uploadProductImage(@RequestParam MultipartFile productImage, HttpServletRequest request, HttpServletResponse response) {
		try {
			// 获取输入流
			InputStream is = productImage.getInputStream();
			// 获取上传的文件名
			String fileName = productImage.getOriginalFilename();
			// 获取上传的文件路径
			String folderPath = getRealPath("/uploadImage", request);
			// 上传文件
			String uploadFileName = FileUtil.uploadFile(is, fileName, folderPath);
			// 向客户端输出信息
			String uploadedImagePath = "/uploadImage/"+uploadFileName;
			outJson(uploadedImagePath, response);
//			String uploadedImagePath = FtpUtil.uploadFile("/uploadImage/", fileName, is);
//			outJson(SystemConstants.FILE_SERVER_URL+uploadedImagePath, response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("downloadFile")
	public void downloadFile(HttpServletRequest request, HttpServletResponse response) {
		// 根据id获取附件信息
		
		// 获取路径
		
		// 根据路径连接ftp进行下载
		String downloadFile = "/uploadImage/cfcb5410-6441-4bc2-9f08-5df2e2d73172.jpg";
		String fileName = "我的测试.jpg";
		FtpUtil.downloadFile(request, response, downloadFile, fileName);
	}
	
	@RequestMapping(value="/deleteProduct.jhtml", method=RequestMethod.POST)
	public void deleteProduct(int id, HttpServletResponse response) {
		productService.deleteProduct(id);
		outJson("{\"success\":true}", response);
	}
	
	@RequestMapping(value="/toUpateProduct")
	public ModelAndView toUpateProduct(int id) {
		Product product = productService.findProductById(id);
		ModelAndView productView = new ModelAndView("product/updateProduct");
		productView.addObject("product", product);
		return productView;
	}
	
	@RequestMapping(value="/updateProduct", method=RequestMethod.POST)
	public String updateProduct(Product product) {
		productService.updateProduct(product);
		return "redirect:/product/findProductList.jhtml";
	}
	
//	@RequestMapping(value="/product/findProductInfoList.jhtml", method=RequestMethod.GET)
//	public ModelAndView findProductInfoList() {
//		List<Product> productList = new ArrayList<Product>();
//		Product p1 = new Product();
//		p1.setProductName("小米");
//		p1.setPrice(500);
//		Product p2 = new Product();
//		p2.setProductName("华为");
//		p2.setPrice(700);
//		productList.add(p1);
//		productList.add(p2);
//		ModelAndView modelAndView = new ModelAndView("product/productList");
//		modelAndView.addObject("productList", productList);
//		return modelAndView;
//	}
}
