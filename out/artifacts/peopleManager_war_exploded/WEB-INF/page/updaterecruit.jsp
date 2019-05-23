<%@ page import="model.Department" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Recruit" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 9:32
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
<%
    List<Department> departments =(List<Department>) session.getAttribute("uprdepartments");
    Recruit recruit =(Recruit) session.getAttribute("uprecruit");
%>
<form action="updaterecruit" method="post">
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
    <input type="hidden" name="T_ID" value="<%=recruit.getT_ID()%>">
    职位：<select id="updatePosit" name="T_POSITION"></select><br>
    薪资：<input type="text" name="T_MONEY" placeholder="请输入金额" value="<%=recruit.getT_MONEY()%>"><br>
    学历：<input type="text" name="T_EDUCATION" placeholder="请输入学历" value="<%=recruit.getT_EDUCATION()%>"><br>
    工龄：<input type="text" name="T_AGE" placeholder="请输入工龄" value="<%=recruit.getT_AGE()%>"><br>
    附加信息：<input type="text" name="T_DETAIL" placeholder="请输入附加信息" value="<%=recruit.getT_DETAIL()%>"><br>
    工作地点：<input type="text" name="T_CITY" placeholder="请输入工作地点" value="<%=recruit.getT_CITY()%>"><br>
    <input type="submit" value="修改"><br>
</form>


</body>
</html>