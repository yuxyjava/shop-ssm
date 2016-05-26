<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<title>产品列表页</title>
</head>
<body>
<form>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
<tr>
<td>产品名:</td>
<td><input type="text" id="productName"/></td>
</tr>
<tr>
<td>产品价格:</td>
<td><input type="text" id="minPrice"/>--<input type="text" id="maxPrice"/></td>
</tr>
<tr>
<td><input type="button" value="查询" onclick="search(1);"/></td>
<td><input type="reset" value="重置"/></td>
</tr>
</table>
<div style="width:800px;background:red;margin:0 auto;text-align:right;">
<input type="button" value="增加" onclick="javascript:window.location.href='<%=request.getContextPath()%>/product/toAddProduct.jhtml'"/>
<input type="button" value="批量删除" onclick="deleteBatchProduct();"/>
</div>
</form>
<div id="productListDiv">
<jsp:include page="/WEB-INF/view/product/productPageList.jsp"></jsp:include>
</div>
<script type="text/javascript">
function search(pageIndex) {
	var v_productName = $("#productName").val();
	var v_minPrice = $("#minPrice").val().length == 0 ? 0:$("#minPrice").val();
	var v_maxPrice = $("#maxPrice").val().length == 0 ? 0:$("#maxPrice").val();
	$.post("<%=request.getContextPath()%>/product/findProductList.jhtml",
			{"flag":1,
			 "pageIndex":pageIndex,
			 "productName":v_productName,
			 "minPrice":v_minPrice,
			 "maxPrice":v_maxPrice},function(data) {
				$("#productListDiv").html(data);
			})
}

function deleteProduct(productId) {
	if (confirm("确定要删除吗?")) {
		$.post("<%=request.getContextPath()%>/product/deleteProduct.jhtml",{"id":productId},function(data) {
			if (data.success) {
				search(1);
			}
		},"json");
	}
}

function deleteBatchProduct() {
	var v_ids = "";
	$("input[name='ids']:checked").each(function() {
		v_ids += "," + $(this).val();
	})
	if (v_ids.length > 0) {
		if (confirm("确定要删除吗?")) {
			v_ids = v_ids.substring(1);
			$.ajax({
				   type: "post",
				   url: "<%=request.getContextPath()%>/product/deleteBatchProduct.jhtml",
				   data: {"ids":v_ids},
				   success: function(data){
				    if (data.success) {
				    	search(1);
				    }
				   },
				  error:function(XMLHttpRequest, textStatus, errorThrown) {
				        alert("状态码:"+XMLHttpRequest.status+"\r\n错误信息:"+XMLHttpRequest.statusText);
				     },
				  dataType:"json"
				});
		}
	} else {
		alert("请选择要删除的记录!!!");
	}
	
}

function turnPage(pageIndex) {
	search(pageIndex);
}
</script>
</body>
</html>