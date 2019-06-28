<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme()+":"+request.getServletContext().getContextPath();
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body>
	<h2>登录页面！</h2>
		<form action="<%=basePath%>/LoginServlet" method="post">
			<table>
				<tr>
					<td>用户名：</td>
					<td><input name="username" type="text" size="20" /></td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input name="password" type="text" size="20" /></td>
				</tr>
			</table>
			<input type="submit" value="登录" />
		</form>
		<br> <a href="register.jsp">注册</a>
	
	
</body>
</html>