<%@ page import="model.Send" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Resume" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 14:40
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
        ul{
            list-style-type: none;
        }
        li{
            border:1px solid #A8CAEE;
        }
    </style>
</head>
<body>
<%
    Resume resume1 = (Resume)session.getAttribute("sendresume");

%>
<ul>
    <li>
        <div>
            <p>
            <h4>基础信息:</h4><br>
            <span>姓名：<%=resume1.getT_NAME()%></span>  <span>性别：<%=resume1.getT_SEX()%></span><br>
            <span>生日：<%=resume1.getT_BIRTHDAYS()%></span>  <span>电话号码：<%=resume1.getT_PHONE()%></span><br>
            <span>邮箱：<%=resume1.getT_EMAIL()%></span><br>
            <span>地址：<%=resume1.getT_ADDRESS()%></span>
            </p>
            <p>
            <h4>求职信息</h4><br>
            <span>期望职位：<%=resume1.getT_HOPEPOSITION()%></span>  <span>期望薪资：<%=resume1.getT_HOPEMONEY()%></span><br>
            <span>工龄：<%=resume1.getT_AGE()%></span> <span>学位：<%=resume1.getT_EDUCATION()%></span><br>
            <span>工作经历：<%=resume1.getT_WORKEXPERIENCE()%></span>  <span>语言技能：<%=resume1.getT_LANGUAGE()%></span><br>

            </p>
            <span>附加信息：<%=resume1.getT_ADDINFORMATION()%></span>
        </div>
    </li>
</ul>

<br>
<hr>
<a href="/toasendview">返回</a>

</body>
</html>