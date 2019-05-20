<%@ page import="model.Send" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 10:04
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
        .menu{
            margin-left: 20px;
        }
    </style>
</head>
<body>
<span class="menu"><a href="toasendview?tree=0">查看所有投递</a></span>
<span class="menu"><a href="toasendview?tree=1">查看未读投递</a></span>
<span class="menu"><a href="toasendview?tree=2">查看已读投递</a></span>
<span class="menu"><a href="toasendview?tree=3">查看已通知面试投递</a></span>
<span class="menu"><a href="toasendview?tree=4">查看已面试投递</a></span>
<%
    List<Send> sends = (List<Send>)session.getAttribute("asends");
    if(sends!=null&&sends.size()!=0){
%>
<ul>
    <%
        for (Send send : sends) {
    %>
    <li>
        <p>招聘信息：
            <span>
                <%=send.getT_RECRUITDE()%>
            </span>
        </p>
        <p>简历信息：
            <span>
                <%=send.getT_RESUMEDE()%>
            </span>
        </p>

        <%
            if(send.getT_STATE()==0){
        %>
        <p>状态：未读</p>
        <a href="toreadresume">查看简历详情</a>
        <%
        }else if(send.getT_STATE()==1){

        %>
        <p>状态：已读</p>



        <%
        }else if(send.getT_STATE()==3||send.getT_STATE()==4){
        %>
        <p>招聘状态：已面试</p>
        <%
        }else if(send.getT_STATE()==5){
        %>

        <p>招聘状态：取消面试</p>
        <%
            }
        %>
    </li>

    <%
        }
    %>
</ul>
<%

}else {
%>
<h3>暂无信息，去<a href="tovrecruit">投递</a> </h3>
<%
    }
%>
<br>
<hr>
<a href="tovisitorview">返回</a>
</body>
</html>