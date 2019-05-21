<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.StaffDao" %>
<%@ page import="dao.DepartmentDao" %>
<%@ page import="dao.PositionDao" %>
<%@ page import="model.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Position" %><%--
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

<a href="/toatrainingview">返回</a>
<br>
<hr>

<%--<%--%>
    <%--ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");--%>
    <%--StaffDao staffDao= (StaffDao) context.getBean("staffDao");--%>
    <%--DepartmentDao departmentDao=(DepartmentDao) context.getBean("departmentDao");--%>
    <%--PositionDao positionDao=(PositionDao)context.getBean("positionDao");--%>


    <%--List<Department> departments = departmentDao.selectAllDepartment();--%>
    <%--if(departments!=null||departments.size()==0){--%>
        <%--for (Department department : departments) {--%>
            <%--//显示+超链接，加人要判断唯一--%>
            <%--List<Position> positions = positionDao.selectPositionbydid(department.getT_ID());--%>
            <%--if(positions!=null||positions.size()==0){--%>
                <%--for (Position position : positions) {--%>

                <%--}--%>
                <%--//显示+超链接，加人要判断唯一--%>
            <%--}else {--%>
                <%--//无职位--%>
            <%--}--%>
        <%--}--%>
    <%--}else {--%>
        <%--//无部门--%>
    <%--}--%>
<%--%>--%>

<%
    List<Department> departments =(List<Department>)session.getAttribute("chdepartment");
%>
<script src="jq/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $("#updateDep").change(function () {
            $.post("selectpositbydid",{"did":$(this).val()},function (obj) {
                $("#updatePosit option").remove();
                for(var i in obj){
                    $("#updatePosit").append("<option value='"+obj[i]['T_ID']+"'>"+obj[i]['T_NAME']+"</option>")
                }
            })
        })
    })
</script>

<div>
    <form action="addstaff" method="post">
        部门：<select id="addDep" name="T_DEPARTMENT">
        <option hidden>请选择﹀</option>
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

        职位：<select id="addPosit" name="T_POSITION"></select>
        员工： <select id="addstaff" name="T_STAFF"></select><br>
    </form>
</div>



<%
    String tid=request.getParameter("tid");
%>
<div>放已选人</div>

</body>
</html>