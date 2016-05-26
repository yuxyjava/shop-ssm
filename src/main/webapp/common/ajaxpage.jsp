<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/common/common.jsp"%>
<c:if test="${page.pageIndex == 1 }">
 <img src="../images/1.gif" width="4" height="5" align="absmiddle"><font color="red">首页</font>
<img src="../images/2.gif" width="3" height="5" align="absmiddle"> 上一页
</c:if>

<c:if test="${page.pageIndex != 1}">
<a href="javascript:;" onclick="turnPage(1)">
首页
</a>
<a href="javascript:;" onclick="turnPage(${page.pageIndex - 1})">上一页</a>
</c:if>



<c:if test="${page.totalCount > 0 && page.pageIndex != page.pageCount }">
<img src="../images/2-2.gif" width="3" height="5" align="absmiddle"><a href="javascript:;" onclick="turnPage(${page.pageIndex + 1 })">下一页</a>
<img src="../images/3.gif" width="4" height="5" align="absmiddle"><a href="javascript:;" onclick="turnPage(${page.pageCount})">尾页</a>
</c:if>

<c:if test="${page.totalCount == 0 || page.pageIndex == page.pageCount }">
下一页
<font color='red'>尾页</font>
</c:if>
当前为${page.pageIndex}/${page.pageCount}
共${page.totalCount}条数据
每页显示
<select onchange="changePageSize(this.value);">
<option value="5" ${page.pageSize == 5 ? "selected":"" }>5</option>
<option value="10" ${page.pageSize == 10 ? "selected":"" } >10</option>
<option value="20" ${page.pageSize == 20 ? "selected":"" }>20</option>
<option value="30" ${page.pageSize == 30 ? "selected":"" }>30</option>
<option value="50" ${page.pageSize == 50 ? "selected":"" }>50</option>
</select>
条
跳转到<input type="text" id="pageIndexText" value="${page.pageIndex }" style="width:30px"/>页<input type="button" value="GO" onclick="turnPage(document.getElementById('pageIndexText').value)"/>