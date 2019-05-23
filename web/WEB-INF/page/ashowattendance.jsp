<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="model.Attendance" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Department" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.StaffDao" %>
<%@ page import="model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/23
  Time: 17:00
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
    <script src="jq/jquery-3.1.0.js"></script>
    <script>
        $(function () {
            $("#addDep").change(function () {
                $.post("selectpositbydidt",{"did":$(this).val()},function (obj) {
                    $("#addPosit .post").remove();
                    $("#addstaff .staff").remove();
                    for(var i in obj){
                        $("#addPosit").append("<option class='post' value='"+obj[i]['t_ID']+"'>"+obj[i]['t_NAME']+"</option>")
                    }
                })
            })
            $("#addPosit").change(function () {
                $.post("selectstaffbypidt",{"pid":$(this).val()},function (obj) {
                    $("#addstaff option").remove();
                    for(var i in obj){
                        $("#addstaff").append("<option class='staff' value='"+obj[i]['t_ID']+"'>"+obj[i]['t_NAME']+"</option>")
                    }
                })
            })

        })
    </script>

</head>
<body>
<%List<Department> departments =(List<Department>)session.getAttribute("chdepartment");%>
<a href="toadmin">返回</a>
<br>
<hr>
<div>
    <form action="aselectattendance" method="post">
        部门：<select id="addDep" name="T_DEPARTMENT">
        <option value="-1">全选﹀</option>
        <%
            if(departments!=null&&departments.size()!=0){
                for (Department department : departments) {
        %>
        <option value="<%=department.getT_ID()%>"><%=department.getT_NAME()%></option>
        <%
                }
            }
        %>
    </select>
        职位：<select id="addPosit" name="T_POSITION">
        <option value="-1">全选﹀</option>
    </select>
        员工： <select id="addstaff" name="T_STAFF">
        <option value="-1">全选﹀</option>
    </select><br>
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
            ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
            StaffDao staffDao= (StaffDao) context.getBean("staffDao");
    %>
    <table>
        <tr>
            <th>员工</th>
            <th>上班时间</th>
            <th>下班时间</th>
        </tr>
        <%
            for (Attendance attendance : staffattendance) {
                Staff staff = staffDao.selectStaffbyid(attendance.getT_IDSTAFF());
        %>
        <tr>
            <td><%=staff.getT_NAME()%></td>
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