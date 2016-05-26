/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:ProductXMLUtil.java 
 * 包名:com.jk.shop 
 * 创建日期:2016年4月19日下午4:57:33 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：ProductXMLUtil    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月19日 下午4:57:33    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月19日 下午4:57:33    
 * 修改备注：       
 * @version </pre>    
 */
public class ProductXMLUtil extends DefaultHandler{
	
		private Product product;
		
		private String preTag;
		
		private int count;

	    @Override  
	    public void startDocument() throws SAXException {  
	    	
	    }  
	  
	    @Override  
	    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {  
	    	 if("product".equals(qName)){  
	             product = new Product();  
	             product.setId(Integer.parseInt(attributes.getValue(0)));  
	         }  
	         preTag = qName;//将正在解析的节点名称赋给preTag  
	    }  
	  
	    @Override  
	    public void endElement(String uri, String localName, String qName)  
	            throws SAXException {  
	       if ("product".equals(qName)) {
	    	   System.out.println("product结束:"+product.getId()+":"+product.getName()+":"+product.getPrice());
	    	   count++;
	       }
	       preTag = null;
	    }  
	      
	    @Override  
	    public void characters(char[] ch, int start, int length) throws SAXException {  
	    	if(preTag!=null){  
	            String content = new String(ch,start,length);  
	            if ("name".equals(preTag)){  
	               product.setName(content);
	            } else if("price".equals(preTag)){  
	               product.setPrice(Integer.parseInt(content)); 
	            } else if ("productexplain".equals(preTag)) {
	            	product.setProductExplain(content);
	            } else if ("productremark".equals(preTag)) {
	            	product.setProductRemark(content);
	            }
	        }  
	    }  
	    
	    @Override  
	    public void endDocument() throws SAXException { 
	    	System.out.println(count);
	    } 
	    
	    
}
