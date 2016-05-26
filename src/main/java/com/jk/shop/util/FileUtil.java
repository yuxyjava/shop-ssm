/** 
 * <pre>项目名称:struts2_demo 
 * 文件名称:FileUtil.java 
 * 包名:com.jk.util 
 * 创建日期:2015-6-6下午3:40:01 
 * Copyright (c) 2015, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/** 
 * <pre>项目名称：struts2_demo    
 * 类名称：FileUtil    
 * 类描述：    
 * 创建人：于笑�?yuxy123@gmail.com    
 * 创建时间�?015-6-6 下午3:40:01    
 * 修改人：于笑�?yuxy123@gmail.com     
 * 修改时间�?015-6-6 下午3:40:01    
 * 修改备注�?      
 * @version </pre>    
 */
public class FileUtil {
	
	public static void deleteFile(String filePath) {
		File file = new File(filePath);
		if (file.exists()) {
			file.delete();
		}
	}
	
	
	/**
	 * <pre>uploadFile(上传文件)   
	 * 创建人：于笑�?yuxy123@gmail.com    
	 * 创建时间�?015-6-6 下午5:50:53    
	 * 修改人：于笑�?yuxy123@gmail.com     
	 * 修改时间�?015-6-6 下午5:50:53    
	 * 修改备注�?
	 * @param file 上传时读取的文件
	 * @param fileName 上传的文件名
	 * @param folderPath 上传后文件存储的路径
	 * @return</pre>
	 */
	public static String uploadFile(File file, String fileName, String folderPath) {
		// 上传物理文件到服务器硬盘
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		String uploadFileName = null;
		try {
			// 构建读文件的流即输入�?
			fis = new FileInputStream(file);
			// 构建输入缓冲区，提高读取文件的�?�?
			bis = new BufferedInputStream(fis);
			// 自动建立文件�?
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			// 为了保证上传文件的唯�??，可以�?过uuid来解�?
			// 为了避免中文乱码问题则新生成的文件名�?uuid+原来文件名的后缀�?
			uploadFileName = UUID.randomUUID().toString()+getSuffix(fileName);
			// 构建写文件的流即输出�?
			fos = new FileOutputStream(new File(folderPath+"/"+uploadFileName));
			// 构建输出缓冲区，提高写文件的性能
			bos = new BufferedOutputStream(fos);
			// 通过输入流读取数据并将数据�?过输出流写到硬盘文件�?
			byte[] buffer = new byte[4096];// 构建4k的缓冲区
			int s = 0;
			while ((s=bis.read(buffer)) != -1) {
				bos.write(buffer, 0, s);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
					bos = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (bis != null) {
				try {
					bis.close();
					bis = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fis != null) {
				try {
					fis.close();
					fis = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return uploadFileName;
	}
	
	public static String uploadFile(InputStream is, String fileName, String folderPath) {
		// 上传物理文件到服务器硬盘
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		String uploadFileName = null;
		try {
			// 构建输入缓冲区，提高读取文件的�?�?
			bis = new BufferedInputStream(is);
			// 自动建立文件�?
			File folder = new File(folderPath);
			if (!folder.exists()) {
				folder.mkdirs();
			}
			// 为了保证上传文件的唯�??，可以�?过uuid来解�?
			// 为了避免中文乱码问题则新生成的文件名�?uuid+原来文件名的后缀�?
			uploadFileName = UUID.randomUUID().toString()+getSuffix(fileName);
			// 构建写文件的流即输出�?
			fos = new FileOutputStream(new File(folderPath+"/"+uploadFileName));
			// 构建输出缓冲区，提高写文件的性能
			bos = new BufferedOutputStream(fos);
			// 通过输入流读取数据并将数据�?过输出流写到硬盘文件�?
			byte[] buffer = new byte[4096];// 构建4k的缓冲区
			int s = 0;
			while ((s=bis.read(buffer)) != -1) {
				bos.write(buffer, 0, s);
				bos.flush();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
					bos = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (fos != null) {
				try {
					fos.close();
					fos = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (bis != null) {
				try {
					bis.close();
					bis = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if (is != null) {
				try {
					is.close();
					is = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		return uploadFileName;
	}
	
	/**
	 * <pre>downloadFile(文件下载)   
	 * 创建人：于笑�?yuxy123@gmail.com    
	 * 创建时间�?015-6-6 下午5:51:52    
	 * 修改人：于笑�?yuxy123@gmail.com     
	 * 修改时间�?015-6-6 下午5:51:52    
	 * 修改备注�?
	 * @param request	       根据浏览器的不同处理中文乱码问题
	 * @param response     获取输出�?
	 * @param downloadFile 下载文件的路�?
	 * @param fileName     下载时弹出对话框上的文件�?/pre>
	 */
	public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFile, String fileName) {
		
		BufferedInputStream bis = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
			File file=new File(downloadFile); //文件的声�?
	        is = new FileInputStream(file);  //文件流的声明
	        os = response.getOutputStream(); //重点突出(特别注意),通过response获取的输出流，作为服务端�?��户端浏览器输出内容的�?��通道
	        // 为了提高效率使用缓冲区流
	        bis = new BufferedInputStream(is);
	        bos = new BufferedOutputStream(os);
	        // 处理下载文件名的乱码问题(根据浏览器的不同进行处理)
	        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
	        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
	        } else {
	        	// 对文件名进行编码处理中文问题
	  	        fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
	  	        fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
	        }
	        response.reset(); // 重点突出
	        response.setCharacterEncoding("UTF-8"); // 重点突出
	        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
	        // inline在浏览器中直接显示，不提示用户下�?
	        // attachment弹出对话框，提示用户进行下载保存本地
	        // 默认为inline方式
	        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
	      //  response.setHeader("Content-Disposition", "attachment; filename="+fileName); // 重点突出
	        int bytesRead = 0;
	        byte[] buffer = new byte[1024];
	        while ((bytesRead = bis.read(buffer)) != -1){ //重点
	            bos.write(buffer, 0, bytesRead);// 将文件发送到客户�?
	        }
	        
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		} finally {
			// 特别重要
	        // 1. 进行关闭是为了释放资�?
	        // 2. 进行关闭会自动执行flush方法清空缓冲区内�?
			try {
				if (null != bis) {
					bis.close();
					bis = null;
				}
				if (null != bos) {
					bos.close();
					bos = null;
				}
				if (null != is) {
					is.close();
					is = null;
				}
				if (null != os) {
					os.close();
					os = null;
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
	
	private static String getSuffix(String fileName) {
		int index = fileName.lastIndexOf(".");
		String suffix = fileName.substring(index);
		return suffix;
	}
	
	public static void downloadXMLFile(HttpServletRequest request, HttpServletResponse response, Document document, String fileName) {
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
	        os = response.getOutputStream(); //重点突出(特别注意),通过response获取的输出流，作为服务端往客户端浏览器输出内容的一个通道
	        bos = new BufferedOutputStream(os);
	        // 处理下载文件名的乱码问题(根据浏览器的不同进行处理)
	        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
	        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
	        } else { 
	        	// 对文件名进行编码处理中文问题
	  	        fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
	  	        fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
	        }
	        response.reset(); // 重点突出
	        response.setCharacterEncoding("UTF-8"); // 重点突出
	        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
	        // inline在浏览器中直接显示，不提示用户下载
	        // attachment弹出对话框，提示用户进行下载保存本地
	        // 默认为inline方式
	        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
	      //  response.setHeader("Content-Disposition", "attachment; filename="+fileName); // 重点突出
	         //实例化输出格式对象
			  OutputFormat format = OutputFormat.createPrettyPrint();
			  //设置输出编码
			  format.setEncoding("UTF-8");
			  //创建需要写入的File对象
			  //生成XMLWriter对象，构造函数中的参数为需要输出的文件流和格式
			  XMLWriter writer = new XMLWriter(bos, format);
			  //开始写入，write方法中包含上面创建的Document对象
			  writer.write(document);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		} finally {
			// 特别重要
	        // 1. 进行关闭是为了释放资源
	        // 2. 进行关闭会自动执行flush方法清空缓冲区内容
			try {
				if (null != bos) {
					bos.close();
					bos = null;
				}
				if (null != os) {
					os.close();
					os = null;
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}

	public static void downloadXLSFile(HttpServletRequest request, HttpServletResponse response, HSSFWorkbook workbook, String fileName) {
		OutputStream os = null;
		BufferedOutputStream bos = null;
		try {
	        os = response.getOutputStream(); //重点突出(特别注意),通过response获取的输出流，作为服务端往客户端浏览器输出内容的一个通道
	        bos = new BufferedOutputStream(os);
	        // 处理下载文件名的乱码问题(根据浏览器的不同进行处理)
	        if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
	        	fileName = new String(fileName.getBytes("GB2312"),"ISO-8859-1");
	        } else { 
	        	// 对文件名进行编码处理中文问题
	  	        fileName = java.net.URLEncoder.encode(fileName, "UTF-8");// 处理中文文件名的问题
	  	        fileName = new String(fileName.getBytes("UTF-8"), "GBK");// 处理中文文件名的问题
	        }
	        response.reset(); // 重点突出
	        response.setCharacterEncoding("UTF-8"); // 重点突出
	        response.setContentType("application/x-msdownload");// 不同类型的文件对应不同的MIME类型 // 重点突出
	        // inline在浏览器中直接显示，不提示用户下载
	        // attachment弹出对话框，提示用户进行下载保存本地
	        // 默认为inline方式
	        response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
	      //  response.setHeader("Content-Disposition", "attachment; filename="+fileName); // 重点突出
	        workbook.write(bos);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		} finally {
			// 特别重要
	        // 1. 进行关闭是为了释放资源
	        // 2. 进行关闭会自动执行flush方法清空缓冲区内容
			try {
				if (null != bos) {
					bos.close();
					bos = null;
				}
				if (null != os) {
					os.close();
					os = null;
				}
			} catch (Exception ex) {
				throw new RuntimeException(ex.getMessage());
			}
		}
	}
}
