<%@ page import="model.Department" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/17
  Time: 16:02
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
                        $("#updatePosit").append("<option value='"+obj[i]['t_ID']+"'>"+obj[i]['t_NAME']+"</option>")
                    }
                })
            })
        })
    </script>

</head>
<body>
<a href="toarecruit">返回</a>
<%
    List<Department> departments =(List<Department>) session.getAttribute("rdepartments");
%>
<form action="addonerecruit" method="post">

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
    职位：<select id="updatePosit" name="T_POSITION"></select><br>
    薪资：<input type="text" name="T_MONEY" placeholder="请输入金额"><br>
    学历：<input type="text" name="T_EDUCATION" placeholder="请输入学历"><br>
    工龄：<input type="text" name="T_AGE" placeholder="请输入工龄"><br>
    附加信息：<input type="text" name="T_DETAIL" placeholder="请输入附加信息"><br>
    工作地点：<input type="text" name="T_CITY" placeholder="请输入工作地点"><br>
    <input type="submit" value="添加"><br>
</form>



</body>
</html>