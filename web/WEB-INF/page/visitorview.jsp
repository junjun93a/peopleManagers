<%@ page import="model.Visitor" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/15
  Time: 23:09
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
    <style>
        a{
            float: left;
            margin-left: 10px;
            background: #FAFFBD;
            font-weight: bold;
            font-style: italic;
        }
    </style>
</head>
<body>
<%
    Visitor visitor =(Visitor) session.getAttribute("visitor");

%>
<h3>欢迎您，<%=visitor.getT_NAME()%></h3>
<a href="logout">退出</a>
<a href="toresumeview">我的简历</a>
<a href="tosendview">我的面试通知</a>
<a href="tovrecruit">查看招聘信息</a>
</body>
</html>