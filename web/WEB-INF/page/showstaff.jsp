<%@ page import="model.Staff" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/19
  Time: 23:33
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
<a href="/todepartposit">返回</a>
<%
    List<Staff> pstaff = ( List<Staff>)session.getAttribute("pstaff");
    if(pstaff!=null||pstaff.size()!=0){
        %>
<ul>

<%
        for (Staff staff : pstaff) {
            %>
    <li><%=staff.toString()%></li>
    <%
            if(staff.getT_WORKINGSTATE()==0){
                %>
    <span>工作状态：试用期</span>
    <%
            }else if (staff.getT_WORKINGSTATE()==1){
%>
    <span>工作状态：在职</span>
    <%
            }else if(staff.getT_WORKINGSTATE()==2){
%>
    <span>工作状态：离职</span><span>离职原因：<%=staff.getT_REASON()%></span>
    <%
            }
        }
        %>
</ul>
<%
    }else {
        %>
<h3>无员工记录</h3>
<%
    }
%>


</body>
</html>