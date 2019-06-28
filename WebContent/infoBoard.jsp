<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>提示页面</title>
</head>
<body>
	<%
	String info = (String)request.getAttribute("info");
	
	
	%>
	提示信息： <%=info %>   

</body>
</html>