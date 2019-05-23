<%@ page import="model.Training" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/21
  Time: 10:55
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
<a href="tostaffview">返回</a>
<br>
<hr>
<%
    List<Training> trainings =( List<Training>) session.getAttribute("strainings");
    if(trainings!=null&&trainings.size()!=0){
        %>
<ul>
<%
        for (Training training : trainings) {
            Date t_endtime = training.getT_ENDTIME();
            Date t_starttime = training.getT_STARTTIME();
            Date now=new Date();
            String indate = null;
            if(t_endtime.getTime()>=now.getTime()&&t_starttime.getTime()<=now.getTime()){
                indate="正在培训中";
            }else if(t_starttime.getTime()>=now.getTime()){
                indate="培训未开始";
            }else if(t_endtime.getTime()<=now.getTime()){
                indate="培训已结束";
            }
%>
            <li><%=training.toString()%></li>
            <li>培训状态：<%=indate%></li>
<%
        }
        %>
</ul>
<%
    }else{

        %>
<h3>无培训信息</h3>
<%
    }
%>
<%
    int tp = (int) session.getAttribute("sttp");
    for (int i = 1; i <= tp; i++) {
%>
<a href="totrainingview?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>

</body>
</html>