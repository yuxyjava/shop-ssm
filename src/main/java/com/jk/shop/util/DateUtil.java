/** 
 * <pre>项目名称:ssh-demo 
 * 文件名称:DateUtil.java 
 * 包名:com.jk.shop.util 
 * 创建日期:2016年4月8日下午3:54:22 
 * Copyright (c) 2016, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.shop.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/** 
 * <pre>项目名称：ssh-demo    
 * 类名称：DateUtil    
 * 类描述：    
 * 创建人：于笑扬 yuxy123@gmail.com    
 * 创建时间：2016年4月8日 下午3:54:22    
 * 修改人：于笑扬 yuxy123@gmail.com     
 * 修改时间：2016年4月8日 下午3:54:22    
 * 修改备注：       
 * @version </pre>    
 */
public class DateUtil {

	public static String formatDate(Date date) {
		if (null != date) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateStr = sdf.format(date);
			return dateStr;
		} else {
			return "";
		}
	}
}
