<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/user/login.jhtml" method="post">
用户名:<input type="text" name="userName"/>
密   码:<input type="password" name="userPassword"/>
验证码:<input type="text" name="validateCode"/><img src="/imageCode"/>
<input type="submit" value="登录"/>
<input type="reset" value="重置"/>
</form>
<script>
var errorFlag = '<%=request.getParameter("error")%>';
if (errorFlag == '1') {
	alert("验证码错误");
} else if (errorFlag == '2') {
	alert("用户名错误");
} else if (errorFlag == '3') {
	alert("密码错误");
}
</script>
</body>
</html>