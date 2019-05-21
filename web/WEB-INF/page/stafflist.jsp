<%@ page import="model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 19:10
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
</head>
<body>
<%
    List<Department> departments =(List<Department>) session.getAttribute("alldepartment");
%>

    部门：<select id="updateDep" name="T_DEPARTMENT">
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
    职位：<select id="posit" name="T_POSITION"></select><br>
    <input type="button" value="查询" id="selectb"><br>
<script>
    $(function () {
        $("#selectb").click(function () {
            $.post("selectstaffbypid",{"pid":$("#posit").val()},function (obj) {
                $("#showstaff span").remove();
                for(var i in obj){
                    $("#showstaff").append("<span>姓名："+obj[i]['T_NAME']+"性别："+obj[i]['T_SEX']+"生日："+obj[i]['T_BIRTHDAY']+"电话："+obj[i]['T_PHONE']+"邮箱："+obj[i]['T_EMAIL']+"</span>")
                }
            })
        })
    })
</script>
<div id="showstaff"></div>

</body>
</html>