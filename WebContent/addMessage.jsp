<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme()+":"+request.getServletContext().getContextPath();
%>      
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="./layui-v2.5.4/layui/css/layui.css" media="all">
    <title>添加留言</title>
</head>
<style>
    h1 {
        text-align: center
    }

    .box {
        width: 80%;
        margin: 0 auto;

    }

    .myul {
        list-style: none;
        line-height: 30px;
    }

    .myul>li {
        font-size: 18px;
        padding-left: 15px
    }

    #test1 {
        text-align: center
    }
button{margin-left: 20px}    
button a{color: white}
</style>

<body>
    <div class="box">
        <form action="<%=basePath%>/AddMessageServlet" method="POST">
        <h1>留言讯息</h1>

        <input type="text" name="title"   placeholder="请输入标题" 
            class="layui-input">

        <textarea name="message" placeholder="请输入内容" class="layui-textarea" style="margin-top: 20px"></textarea>

       <button type="button" class="layui-btn" style="margin-top: 20px;float: right;"><a href="index.jsp">返回</a></button>
        <button type="submit" class="layui-btn" style="margin-top: 20px;float: right;">提交留言</button>
         </form>
    </div>

messageStatue:${messageStatue}<br>
flag:${flag}
<%
    String mess=(String)session.getAttribute("messageStatue");
	String flag=(String)session.getAttribute("flag");
 
 if(mess!=null && flag == "0"){%>
 
    <script type="text/javascript">
        alert("<%=mess%>");
	</script>
 
 <% session.setAttribute("messageStatue", ""); %>
  <% session.setAttribute("flag", "1"); %>
<% }%>
</body>

</html>


 
