<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加产品</title>
<link href="<%=request.getContextPath() %>/js/uploadify/uploadify.css" rel="stylesheet" ></link>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/uploadify/jquery.uploadify.min.js"></script>
</head>
<body>
<form action="<%=request.getContextPath()%>/product/addProduct.jhtml" method="post">
<table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
<tr>
<td>商品名:</td>
<td><input type="text" name="productName"/></td>
</tr>
<tr>
<td>商品价格:</td>
<td><input type="text" name="price"/></td>
</tr>
<tr>
<td>商品品牌:</td>
<td>
<select name="brand.id">
<option value="-1">===请选择===</option>
<c:forEach items="${brandList }" var="brand">
<option value="${brand.id }">${brand.brandName }</option>
</c:forEach>
</select>
</td>
</tr>
<tr>
<td>入库时间:</td>
<td><input type="text" name="enterDate"/></td>
</tr>
<tr>
<td>商品主图:</td>
<td>
<div id="productMainImageQueue"></div>
<input type="file" id="productMainImage"/>
<div id="uploadProductMainImage"></div>
<input type="text" id="productMainImageUrl" name="productMainImageUrl"/>
</td>
</tr>
<tr>
<td >商品子图:</td>
<td>
<div id="productImageQueue"></div>
<input type="file" id="productImage"/>
<div id="uploadProductImage" style="width:98%;height:200px;padding:5px;">

</div>
<input type="text" id="productImageUrls" name="productImageUrls"/>
</td>
</tr>
<tr>
<td><input type="submit" value="增加商品"/></td>
<td><input type="reset" value="重置"/></td>
</tr>
</table>
</form>
<script type="text/javascript">
$(document).ready(function()
        {
            $("#productMainImage").uploadify({
            		//前台请求后台的url 不可忽略的参数
	    	      	'uploader':'<%=request.getContextPath()%>/product/uploadProductImage.jhtml',
	    	      	//插件自带  不可忽略的参数
	    	      	'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
	    	        //撤销按钮的图片路径
	                'cancelImg': '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
	                //如果为true 为自动上传  在文件后 为false 那么它就要我们自己手动点上传按钮
	                'auto': true,
	                //可以同时选择多个文件 默认为true  不可忽略
	                'multi': false, 
	                //给div的进度条加背景 不可忽略
	                'queueID': 'productMainImageQueue',
	                //给上传按钮设置文字
	                'buttonText': '上传商品主图',
	                //上传后队列是否消失
	                'removeCompleted': true,
	                'removeTimeout' : 1,
	                'fileObjName' : 'productImage',
	                'onUploadSuccess' : function(file, data, response) {//当上传完成后的回调函数，ajax方式哦~~ 
						$("#productMainImageUrl").val(data);
						$("#uploadProductMainImage").html('<img src="'+data+'" width="50px" height="50px"/>');
                  } 
            });
        }); 
        
$(document).ready(function()
        {
            $("#productImage").uploadify({
            		//前台请求后台的url 不可忽略的参数
	    	      	'uploader':'<%=request.getContextPath()%>/product/uploadProductImage.jhtml',
	    	      	//插件自带  不可忽略的参数
	    	      	'swf': '<%=request.getContextPath()%>/js/uploadify/uploadify.swf',
	    	        //撤销按钮的图片路径
	                'cancelImg': '<%=request.getContextPath() %>/js/uploadify/uploadify-cancel.png',
	                //如果为true 为自动上传  在文件后 为false 那么它就要我们自己手动点上传按钮
	                'auto': true,
	                //可以同时选择多个文件 默认为true  不可忽略
	                'multi': true, 
	                //给div的进度条加背景 不可忽略
	                'queueID': 'productImageQueue',
	                //给上传按钮设置文字
	                'buttonText': '上传商品子图',
	                //上传后队列是否消失
	                'removeCompleted': true,
	                'removeTimeout' : 1,
	                'fileObjName' : 'productImage',
	                'onUploadSuccess' : function(file, data, response) {//当上传完成后的回调函数，ajax方式哦~~ 
	                	var res = $("#productImageUrls").val()+","+data;
						$("#productImageUrls").val(res);
						$("#uploadProductImage").append('<div style="width:80px;height:80px;background:gray;float:left;margin:5px;"><div><img src="'+data+'" width="80px" height="60px"/></div><div width="80px" height="20px" style="text-align:center;"><a href="javascript:;" onclick="deleteImage(this)">删除</a></div></div>');
                  } 
            });
        }); 
        
        function deleteImage(obj) {
        	$(obj).parent().parent().remove();
        }
</script>
</body>
</html>