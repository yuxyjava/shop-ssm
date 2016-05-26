/** 
 * <pre>项目名称:shop-ssi-maven 

 * 文件名称:BrandController.java 
 * 包名:com.jk.shop.controller.brand 
 * 创建日期:2016年4月18日上午10:15:20 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.controller.brand;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.jk.shop.analyse.BrandExcelAnalyse;
import com.jk.shop.controller.BaseController;
import com.jk.shop.model.brand.Brand;
import com.jk.shop.service.brand.BrandService;
import com.jk.shop.util.FileUtil;

import net.sf.json.JSONArray;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：BrandController    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月18日 上午10:15:20    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月18日 上午10:15:20    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
@RequestMapping("/brand")
public class BrandController extends BaseController{
	
	@Resource(name="brandService")
	private BrandService brandService;
	
	@RequestMapping(value="findBrandList")
	public String findBrandList(ModelMap brandMap) {
		List<Brand> brandList = brandService.findBrandList();
		brandMap.put("brandList", brandList);
		return "/brand/brandList";
	}
	
	@RequestMapping(value="findAjaxBrandList")
	public void findAjaxBrandList(HttpServletRequest request, HttpServletResponse response) {
		List<Brand> brandList = brandService.findBrandList();
		String brandListJson = JSONArray.fromObject(brandList).toString();
		String callback = request.getParameter("callback");
		outJson(callback+"("+brandListJson+")", response);
	}
	
	@RequestMapping(value="findHttpCleintBrandList")
	public void findHttpCleintBrandList(HttpServletRequest request, HttpServletResponse response) {
		List<Brand> brandList = brandService.findBrandList();
		String brandListJson = JSONArray.fromObject(brandList).toString();
		outJson(brandListJson, response);
	}
	
	
	@RequestMapping("importBrand")
	public void importBrand(@RequestParam MultipartFile brandFile, HttpServletRequest request, HttpServletResponse response) {
		// 上传文件到服务器
		try {
			InputStream is = brandFile.getInputStream();
			String fileName = brandFile.getOriginalFilename();
			String folderPath = getRealPath("/uploadFile", request);
			String uploadedFileName = FileUtil.uploadFile(is, fileName, folderPath);
			// 解析excel文件
			List<Brand> brandList = BrandExcelAnalyse.analyseExcel(getRealPath("/uploadFile/"+uploadedFileName, request));
			// 插入数据库
			brandService.addBrandList(brandList);
			// 响应信息
			outJson("{\"success\":true}", response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
