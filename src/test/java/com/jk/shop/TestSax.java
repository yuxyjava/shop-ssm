/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:TestSax.java 
 * 包名:com.jk.shop 
 * 创建日期:2016年4月19日下午4:57:00 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */
package com.jk.shop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * <pre>
 * 项目名称：shop-ssi-maven    
 * 类名称：TestSax    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月19日 下午4:57:00    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月19日 下午4:57:00    
 * 修改备注：       
 * &#64;version
 * </pre>
 */
public class TestSax {

	@Test
	public void testXML() throws ParserConfigurationException, SAXException, FileNotFoundException, IOException {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser parser = factory.newSAXParser();
		ProductXMLUtil handler = new ProductXMLUtil();
		parser.parse(new FileInputStream("d:/product.xml"), handler);
	}
}
