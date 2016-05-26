<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=request.getContextPath() %>/js/uploadify/uploadify.css" rel="stylesheet" ></link>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
<title>品牌列表</title>
</head>
<body>
<table>
<tr>
<td>品牌id</td>
<td>品牌名</td>
</tr>
<c:forEach items="${brandList}" var="brand">
<tr>
<td>${brand.id }</td>
<td>${brand.brandName }</td>
</tr>
</c:forEach>
</table>
<div id="brandQueue"></div>
<input type="file" id="brandExcel"/>
<script type="text/javascript">
$(document).ready(function()
        {
            $("#brandExcel").uploadify({
            		//前台请求后台的url 不可忽略的参数
	    	      	'uploader':'<%=request.getContextPath()%>/brand/importBrand.jhtml',
	    	      	//插件自带  不可忽略的参数
	    	      	'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
	    	        //撤销按钮的图片路径
	                'cancelImg': '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
	                //如果为true 为自动上传  在文件后 为false 那么它就要我们自己手动点上传按钮
	                'auto': true,
	                //可以同时选择多个文件 默认为true  不可忽略
	                'multi': false, 
	                //给div的进度条加背景 不可忽略
	                'queueID': 'brandQueue',
	                //给上传按钮设置文字
	                'buttonText': '导入品牌',
	                //上传后队列是否消失
	                'removeCompleted': true,
	                'removeTimeout' : 1,
	                'fileObjName' : 'brandFile',
	                'onUploadSuccess' : function(file, data, response) {//当上传完成后的回调函数，ajax方式哦~~ 
	                 var result = eval("("+data+")");
	                 if (result.success) {
	                	 alert("刷新页面");
	                 }
                  } 
            });
        }); 
</script>
</body>
</html>