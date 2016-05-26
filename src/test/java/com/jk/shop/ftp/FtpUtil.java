/** 
 * <pre>项目名称:shop-ssi-maven 
 * 文件名称:FtpUtil.java 
 * 包名:com.jk.shop.ftp 
 * 创建日期:2016年4月20日上午8:26:19 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.ftp;

import java.io.IOException;
import java.io.InputStream;

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
	
	public static boolean uploadFile(String url,int port,String username, String password, String path, String filename, InputStream input) { 
	    boolean success = false; 
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
	            return success; 
	        } 
	        //ftp.changeWorkingDirectory(path); 
	        // 创建多级目录
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
	        ftp.setBufferSize(1024 * 4); 
	        //ftp.setControlEncoding("GBK"); 
	        ftp.storeFile(new String(filename.getBytes("utf-8"),"iso-8859-1"), input);          
	        success = true; 
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
	    return success; 
	}
	
	
	
}
