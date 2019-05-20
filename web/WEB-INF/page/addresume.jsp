<%@ page import="model.Visitor" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/16
  Time: 11:37
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
    Visitor visitor =(Visitor) session.getAttribute("visitor");
%>
<form action="addoneresume" method="post">
        <input type="hidden" name="T_IDVISITOR" value="<%=visitor.getT_ID()%>">
        生日：<input type="date" name="T_BIRTHDAY">
        电话号码：<input type="text" name="T_PHONE" placeholder="请输入电话号码"><br>
        邮箱：<input type="text" name="T_EMAIL" placeholder="请输入邮箱地址"><br>
        地址：<input type="text" name="T_ADDRESS" placeholder="请输入地址"><br>
        期望职位：<input type="text" name="T_HOPEPOSITION" placeholder="请输入期望职位">
        期望薪资：<input type="text" name="T_HOPEMONEY" placeholder="请输入期望薪资"><br>
        工龄：<input type="text" name="T_AGE" placeholder="请输入工龄">
        学位：<input type="text" name="T_EDUCATION" placeholder="请输入学位"><br>
        语言技能：<input type="text" name="T_LANGUAGE" placeholder="请输入掌握语言技能">
        工作经历：<input type="text" name="T_WORKEXPERIENCE" placeholder="请输入工作经历"><br>
        附加信息:<input type="text" name="T_ADDINFORMATION" placeholder="请输入附加信息">
        <input type="hidden" name="T_SEX" value="<%=visitor.getT_SEX()%>">
        <input type="hidden" name="T_NAME" value="<%=visitor.getT_NAME()%>">
        <input type="submit" value="添加简历"><br>
    </form>

</body>
</html>