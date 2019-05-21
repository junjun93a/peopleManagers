<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 19:04
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
<a href="tostafflist">查看通讯录</a>
<a href="logout">退出</a>
</body>
</html>