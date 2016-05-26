<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form  method="post" id="updateProductForm">
<input type="text" value="${product.id }" name="id"/>
				<table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
					<tr>
						<td>商品名:</td>
						<td><input type="text" name="productName" class="easyui-textbox" value="${product. productName}"/></td>
					</tr>
					<tr>
						<td>商品价格:</td>
						<td><input type="text" name="price" class="easyui-numberspinner" data-options="min:0" value="${product.price }"/></td>
					</tr>
					<tr>
						<td>商品品牌:</td>
						<td>
						<select name="brand.id" class="easyui-combobox">
						<option value="-1">===请选择===</option>
						<c:forEach items="${brandList }" var="brand">
						<option value="${brand.id }" ${brand.id==product.brand.id ? "selected":""}>${brand.brandName }</option>
						</c:forEach>
						</select>
						</td>
					</tr>
					<tr>
						<td>入库时间:</td>
						<td><input type="text" name="enterDate" onclick="WdatePicker()" class="Wdate" value="${product.enterDate }"/></td>
					</tr>
					<tr>
						<td>商品主图:</td>
						<td>
						<div id="updateProductMainImageQueue"></div>
						<input type="file" id="updateProductMainImage"/>
						<div id="updateUploadProductMainImage">
							<img src="<%=request.getContextPath() %>${product.productMainImageUrl }" width="50px" height="50px"/>
						</div>
						<input type="text" id="updateProductMainImageUrl" name="productMainImageUrl" value="${product.productMainImageUrl }"/>
						</td>
					</tr>
					<tr>
						<td >商品子图:</td>
						<td>
						<div id="updateproductImageQueue"></div>
						<input type="file" id="updateproductImage"/>
						<div id="updateuploadProductImage" style="width:98%;height:200px;padding:5px;">
							<c:forEach items="${productImageList }" var="productImage">
								<div style="width:80px;height:80px;background:gray;float:left;margin:5px;"><div><img src="<%=request.getContextPath() %>${productImage.path}" width="80px" height="60px"/></div><div width="80px" height="20px" style="text-align:center;"><a href="javascript:;" onclick="removeImage(this,'${productImage.id}', '${productImage.path}')">删除</a></div></div>
							</c:forEach>
						</div>
						<input type="text" id="updateproductImageUrls" name="productImageUrls"/>
						<input type="text" id="updatedeletedProductImages" name="deletedProductImages"/>
						</td>
					</tr>
					<tr>
						<td>商品描述:</td>
						<td><textarea id="updateproductDesc" name="productDesc" style="width:100%;height:260px;visibility:hidden;">${product.productDesc }</textarea></td>
					</tr>
				</table>
			</form>



<script>
$(document).ready(function()
        {
            $("#updateProductMainImage").uploadify({
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
	                'queueID': 'updateProductMainImageQueue',
	                //给上传按钮设置文字
	                'buttonText': '上传商品主图',
	                //上传后队列是否消失
	                'removeCompleted': true,
	                'removeTimeout' : 1,
	                'fileObjName' : 'productImage',
	                'onUploadSuccess' : function(file, data, response) {//当上传完成后的回调函数，ajax方式哦~~ 
						$("#updateProductMainImageUrl").val(data);
						$("#updateUploadProductMainImage").html('<img src="'+data+'" width="50px" height="50px"/>');
                  } 
            });
        }); 
        
$(document).ready(function()
        {
            $("#updateproductImage").uploadify({
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
	                'queueID': 'updateproductImageQueue',
	                //给上传按钮设置文字
	                'buttonText': '上传商品子图',
	                //上传后队列是否消失
	                'removeCompleted': true,
	                'removeTimeout' : 1,
	                'fileObjName' : 'productImage',
	                'onUploadSuccess' : function(file, data, response) {//当上传完成后的回调函数，ajax方式哦~~ 
	                	var res = $("#updateproductImageUrls").val()+","+data;
						$("#updateproductImageUrls").val(res);
						$("#updateuploadProductImage").append('<div style="width:80px;height:80px;background:gray;float:left;margin:5px;"><div><img src="'+data+'" width="80px" height="60px"/></div><div width="80px" height="20px" style="text-align:center;"><a href="javascript:;" onclick="deleteImage(this,\''+data+'\')">删除</a></div></div>');
                  } 
            });
        }); 
        
        function deleteImage(obj, path) {
        	$(obj).parent().parent().remove();
        	$("#updateproductImageUrls").val($("#updateproductImageUrls").val().replace(","+path,''));
        }
        
        function removeImage(obj, id, path) {
        	$(obj).parent().parent().remove();
        	var res = $("#updatedeletedProductImages").val()+";"+id+","+path;
        	$("#updatedeletedProductImages").val(res);
        }
</script>