/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:FtpUtil.java 
 * 包名:com.jk.shop.ftp 
 * 创建日期:2016年4月20日上午8:26:19 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/** 
 * <pre>项目名称：shop-ssi-maven    
 * 类名称：FtpUtil    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月20日 上午8:26:19    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月20日 上午8:26:19    
 * 修改备注：       
 * @version </pre>    
 */
public class FtpUtil {
	
public static boolean downloadFile(HttpServletRequest request, HttpServletResponse response, String downloadFile, String fileName) {
		BufferedInputStream bis = null;
		InputStream is = null;
		OutputStream os = null;
		BufferedOutputStream bos = null;
		boolean downloadSuccess = false;
	    String url = SystemConstants.FTP_IP_ADDR;
	    int port = SystemConstants.FTP_PORT;
	    String username = SystemConstants.FTP_USER_NAME;
	    String password = SystemConstants.FTP_USER_PASSWORD;
	    FTPClient ftp = new FTPClient(); 
		try {
			 int reply; 
		     ftp.connect(url, port);//连接FTP服务器 
		     ftp.login(username, password);//登录 
	         ftp.setFileType(FTPClient.BINARY_FILE_TYPE);    
	         reply = ftp.getReplyCode(); 
	         if (!FTPReply.isPositiveCompletion(reply)) { 
	            ftp.disconnect(); 
	            return downloadSuccess; 
	         } 
	         File filePath = new File(downloadFile);
	         String path = filePath.getParent();
	         // 创建或跳转到指定的多级目录
		        if (path != null && !"".equals(path.trim())) {
	                String[] pathes = path.split("/");
	                for (String onepath : pathes) {
	                    if (onepath == null || "".equals(onepath.trim())) {
	                        continue;
	                    }
	                    onepath=new String(onepath.getBytes("utf-8"),"iso-8859-1");                    
	                    if (!ftp.changeWorkingDirectory(onepath)) {
	                    	ftp.makeDirectory(onepath);
	                    	ftp.changeWorkingDirectory(onepath);
	                    }
	                }
	            }
		        ftp.setBufferSize(1024 * 8); 
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
	        ftp.retrieveFile(filePath.getName(), bos);
	        downloadSuccess = true;
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
		return downloadSuccess;
	}
	
	public static String uploadFile(String path, String filename, InputStream input) { 
	    String uploadedFilePath = "";
	    String url = SystemConstants.FTP_IP_ADDR;
	    int port = SystemConstants.FTP_PORT;
	    String username = SystemConstants.FTP_USER_NAME;
	    String password = SystemConstants.FTP_USER_PASSWORD;
	    FTPClient ftp = new FTPClient(); 
	    try { 
	        int reply; 
	        ftp.connect(url, port);//连接FTP服务器 
	        //如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器 
	        ftp.login(username, password);//登录 
	        ftp.setFileType(FTPClient.BINARY_FILE_TYPE);    
	        reply = ftp.getReplyCode(); 
	        if (!FTPReply.isPositiveCompletion(reply)) { 
	            ftp.disconnect(); 
	            return uploadedFilePath; 
	        } 
	        //ftp.changeWorkingDirectory(path); 
	        // 创建或跳转到指定的多级目录
	        if (path != null && !"".equals(path.trim())) {
                String[] pathes = path.split("/");
                for (String onepath : pathes) {
                    if (onepath == null || "".equals(onepath.trim())) {
                        continue;
                    }
                    onepath=new String(onepath.getBytes("utf-8"),"iso-8859-1");                    
                    if (!ftp.changeWorkingDirectory(onepath)) {
                    	ftp.makeDirectory(onepath);
                    	ftp.changeWorkingDirectory(onepath);
                    }
                }
            }
	        ftp.setBufferSize(1024 * 8); 
	        filename = UUID.randomUUID().toString()+getSuffix(filename);
	        ftp.storeFile(new String(filename.getBytes("utf-8"),"iso-8859-1"), input);          
	        uploadedFilePath = path + filename;
	    } catch (IOException e) { 
	        e.printStackTrace(); 
	    } finally { 
	    	if (null != input) {
	    		try {
					input.close();
					input = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	    	}
	        if (null != ftp && ftp.isConnected()) { 
	            try { 
	            	ftp.logout(); 
	                ftp.disconnect(); 
	                ftp = null;
	            } catch (IOException e) { 
	            	e.printStackTrace();
	            } 
	        } 
	    } 
	    return uploadedFilePath; 
	}
	
	
	
	private static String getSuffix(String fileName) {
		int index = fileName.lastIndexOf(".");
		String suffix = fileName.substring(index);
		return suffix;
	}
	
	
	
}
