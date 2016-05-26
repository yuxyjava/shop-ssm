<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改产品</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/product/updateProduct.jhtml" method="post">
<input type="text" name="id" value="${product.id }"/>
<table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
<tr>
<td>商品名:</td>
<td><input type="text" name="productName" value="${product.productName }"/></td>
</tr>
<tr>
<td>商品价格:</td>
<td><input type="text" name="price" value="${product.price }"/></td>
</tr>
<tr>
<td>入库时间:</td>
<td><input type="text"/></td>
</tr>
<tr>
<td><input type="submit" value="更新商品"/></td>
<td><input type="reset" value="重置"/></td>
</tr>
</table>
</form>
</body>
</html>