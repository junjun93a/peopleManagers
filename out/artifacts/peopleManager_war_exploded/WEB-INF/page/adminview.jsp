<%@ page import="model.Admin" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/17
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>Title</title>
</head>
<body>
<%
    Admin admin =(Admin) session.getAttribute("admin");

%>
<h3>欢迎您，<%=admin.getT_ACCOUNT()%></h3>
<a href="toasendview">查看投递信息</a>
<a href="todepartposit">部门职位管理</a>
<a href="toarecruit">管理招聘信息</a>
<a href="logout">退出</a>
</body>
</html>