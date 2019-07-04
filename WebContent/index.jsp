<%@page import="org.apache.jasper.tagplugins.jstl.core.Out"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%
	String basePath = request.getScheme()+":"+request.getServletContext().getContextPath();
%>  
<!DOCTYPE html>
<html lang="en">
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="layui-v2.5.4/layui/css/layui.css" media="all">
    <title>主页</title>
   
</head>
<style>
h1{text-align: center}    
.box{width: 80%;margin: 0 auto;background: salmon}    
.myul{list-style: none;line-height: 30px;}
.myul>li{font-size: 18px;padding-left: 15px}
#test1{text-align: center}
button a{color: white}
button:hover a{color: white}
</style>
<body>

    <div class="box">
            <h1>欢迎来到留言板主页</h1>
            <span>欢迎您！${username}</span><br>
            <button type="button" class="layui-btn">个人中心</button>
            <button type="button" class="layui-btn"><a href="addMessage.jsp">我要留言</a></button>
             <button type="button" class="layui-btn" onclick="quit()">退出</button>
            <ul class="myul">
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
                <li>留言留言</li>
            </ul>

            <div id="test1"></div>
    </div>


</body>
</html>
<script src="./layui-v2.5.4/layui/layui.js"></script>
<script>
layui.use('laypage', function(){
  var laypage = layui.laypage;
  
  //执行一个laypage实例
  laypage.render({
    elem: 'test1' //注意，这里的 test1 是 ID，不用加 # 号
    ,count: 50 //数据总数，从服务端得到
  });
});
</script>

<script>
function quit(){
	alert("即将退出……")
	window.location.href="/JdbcRegAndLogin/login.jsp";

	<%
	session.invalidate();
	%>
	
	
}
</script>

