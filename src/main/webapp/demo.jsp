<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.3.js"></script>
<title>Insert title here</title>
</head>
<body>
<input type="button" value="显示数据" onclick="showData();"/>
<script type="text/javascript">
	function showData() {
		$.ajax({
			url:"<%=request.getContextPath()%>/brand/findAjaxBrandList.jhtml",
			type:"post",
			dataType:"json",
			success: function(data){
			    alert(data[0].brandName);
			 },
			error:function(XMLHttpRequest, textStatus, errorThrown) {
			        alert("状态码:"+XMLHttpRequest.status+"\r\n错误信息:"+XMLHttpRequest.statusText);
			  }
		})
	}
</script>
</body>
</html>