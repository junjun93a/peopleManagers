<%@ page import="model.Rewardandpunish" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/23
  Time: 20:18
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
<a href="tostaffview">返回</a>
<br>
<hr>
<h1>员工奖惩查询</h1>
<div>
    <form action="srewardandpunish" method="post">
        查询时间：<select name="yeart" id="year">
        <%
            Date date=new Date();
            DateFormat format= new SimpleDateFormat("yyyy");
            String format1 = format.format( date);
            Integer year= Integer.valueOf(format1);
            for (int i=2010;i<=year;i++){
        %>
        <option value="<%=i%>" ><%=i%>年</option>
        <%
            }
        %>
    </select>
        <select name="montht" id="month">
            <%
                for (int i=1;i<=12;i++){
            %>
            <option value="<%=i%>" ><%=i%>月</option>
            <%
                }
            %>
        </select>
        <input type="submit" value="查询">
    </form>
</div>
<div>
    <%
        List<Rewardandpunish> staffattendance =(List<Rewardandpunish>) request.getAttribute("staffrap");
        if (staffattendance!=null&&staffattendance.size()!=0){
    %>
    <table>
        <tr>
            <th>时间</th>
            <th>原因</th>
            <th>金额</th>
        </tr>
        <%
            for (Rewardandpunish rewardandpunish : staffattendance) {
        %>
        <tr>
            <td><%=rewardandpunish.getT_TIME()%></td>
            <td><%=rewardandpunish.getT_REASON()%></td>
            <td><%=rewardandpunish.getT_MONEY()%></td>
        </tr>
        <%
            }

        %>
    </table>
    <%

    }else {
    %>
    <h2>无记录</h2>
    <%
        }
    %>
</div>

</body>
</html>