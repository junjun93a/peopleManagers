<%@ page import="model.Staff" %><%--
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
<%
    Staff staff =(Staff) session.getAttribute("staff");

%>
<h3>欢迎您，<%=staff.getT_NAME()%></h3>
<a href="tocard">考勤打卡</a>
<a href="toshowrap">查看个人奖惩信息</a>
<a href="toshowattendance">查看历史考勤信息</a>
<a href="tostafflist">查看通讯录</a>
<a href="">查看个人信息</a>
<a href="totrainingview">查看培训信息</a>
<a href="logout">退出</a>
<input type="button" value="离职" id="dimission">
<div id="reason">

</div>
<script src="jq/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $("#dimission").click(function () {
            $('#reason').append("  <form action=\"dimission\" method=\"post\">\n" +
                "        离职原因：<input type=\"text\" name=\"T_REASON\" placeholder=\"请输入原因\">\n" +
                "        <input type=\"submit\" value=\"提交离职\">\n" +
                "    </form>")
            $("#dimission").attr("disabled","disabled")
        })
    })
</script>
</body>
</html>