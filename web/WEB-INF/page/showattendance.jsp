<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Attendance" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/23
  Time: 15:13
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
<div>
    <form action="selectattendance" method="post">
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
        List<Attendance> staffattendance =(List<Attendance>) request.getAttribute("staffattendance");
        if (staffattendance!=null&&staffattendance.size()!=0){
            %>
    <table>
        <tr>
            <th>上班时间</th>
            <th>下班时间</th>
        </tr>
    <%
            for (Attendance attendance : staffattendance) {
                %>
   <tr>
       <td><%=attendance.getT_STARTTIME()%></td>
       <td><%=attendance.getT_ENDTIME()%></td>
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