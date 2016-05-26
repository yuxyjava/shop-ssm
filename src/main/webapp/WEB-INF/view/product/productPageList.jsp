<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<c:if test="${!empty productList }">
<table align="center" border="1" cellpadding="0" cellspacing="0" width="800px">
<tr>
<td>选择</td>
<td>产品名</td>
<td>产品品牌</td>
<td>产品主图</td>
<td>入库时间</td>
<td>产品价格</td>
<td>操作</td>
</tr>
<c:forEach items="${productList }" var="product">
<tr>
<td><input type="checkbox" name="ids" value="${product.id }"/></td>
<td>${product.productName }</td>
<td>${product.brand.brandName }</td>
<td><img src="<%=request.getContextPath() %>${product.productMainImageUrl }" width="50px" height="50px"/></td>
<td>${product.enterDate }</td>
<td>${product.price }</td>
<td>
<a href="javascript:;" onclick="deleteProduct('${product.id}')">删除</a>
<a href="<%=request.getContextPath()%>/product/toUpateProduct.jhtml?id=${product.id}">修改</a>
</td>
</tr>
</c:forEach>
</table>
<center>
<jsp:include page="/common/ajaxpage.jsp"></jsp:include>
</center>
</c:if>
<c:if test="${empty productList }">
<center>
<font color="red" size="20px">没有符合条件的记录！！！</font>
</center>
</c:if>
