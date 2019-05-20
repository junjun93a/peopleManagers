<%@ page import="model.Resume" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/16
  Time: 20:31
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
<a href="tovrecruit">返回</a>
<br>
<hr>

<%
    List<Resume> resumes =( List<Resume>) session.getAttribute("resumes");
    if(resumes!=null&&resumes.size()!=0){
        %>

<form method="post" action="addsend">
<ul>
<%
        for (Resume resume : resumes) {
            %>
<li><span><input type="radio" name="resumeid"  value="<%=resume.getT_ID()%>"></span><span><%=resumes.toString()%></span></li>
<%
        }
        %>
</ul>
<input type="submit" value="投递" >
</form>
<%
    }else {
%>
<h3>暂无简历，请<a href="toaddresume">添加</a> </h3>
<%
    }
%>
<script src="jq/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $('input:radio:first').attr('checked', 'checked');
    })
</script>
</body>
</html>