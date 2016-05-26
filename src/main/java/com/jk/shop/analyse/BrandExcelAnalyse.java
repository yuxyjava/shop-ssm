/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:BrandExcelAnalyse.java 
 * 包名:com.jk.shop.analyse 
 * 创建日期:2016年4月18日上午10:36:21 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.analyse;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jk.shop.model.brand.Brand;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：BrandExcelAnalyse    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月18日 上午10:36:21    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月18日 上午10:36:21    
 * 修改备注：       
 * @version </pre>    
 */
public class BrandExcelAnalyse {

	public static List<Brand> analyseExcel(String excelPath) {
		List<Brand> brandList = new ArrayList<Brand>();
		try {
			InputStream is = new FileInputStream(excelPath);
			XSSFWorkbook workBook = new XSSFWorkbook(is);
			XSSFSheet sheet = workBook.getSheetAt(0);
			int lastRowNum = sheet.getLastRowNum();
			for (int i = 0; i <= lastRowNum; i++) {
				Brand brand = new Brand();
				XSSFRow row = sheet.getRow(i);
				String brandName = row.getCell(0).getStringCellValue();
				brand.setBrandName(brandName);
				brandList.add(brand);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return brandList;
	}
}
