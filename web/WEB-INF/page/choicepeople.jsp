<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.StaffDao" %>
<%@ page import="dao.DepartmentDao" %>
<%@ page import="dao.PositionDao" %>
<%@ page import="model.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Position" %>
<%@ page import="model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/21
  Time: 15:00
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

<a href="toatrainingview">返回</a>
<br>
<hr>

<%
    List<Department> departments =(List<Department>)session.getAttribute("chdepartment");
%>
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

<div>
    <form action="addstaff" method="post">
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
        <option hidden>请选择﹀</option>
    </select><br>
        <input type="submit" value="添加">
    </form>
</div>

<div>

<%
    List<Staff> tstaffs = (List<Staff>) session.getAttribute("tstaffs");
if(tstaffs!=null||tstaffs.size()!=0){
    %>

    <h3>已添加人：</h3>
<%
    for (Staff staff : tstaffs) {
        %>
    <p><%=staff.getT_NAME()%><a href="deletetstaff?sid=<%=staff.getT_ID()%>">删除</a></p>
    <%
    }
    %>

    <%
}else {
    %>
    <h2>暂无人员</h2>
    <%
}
%>
</div>

</body>
</html>