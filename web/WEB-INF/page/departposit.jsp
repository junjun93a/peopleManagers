<%@ page import="model.Position" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Department" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/19
  Time: 14:45
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
        .position {
            float: left;
            margin-left: 20px;
        }
        .department{
            overflow:hidden;
        }
    </style>



</head>
<body>
<%
    List<Position> positions =( List<Position>) session.getAttribute("positions");
    List<Department> departments =(List<Department>) session.getAttribute("departments");
%>
<a href="toadmin">返回</a>
<br>
<input type="button" value="新增部门" id="adddepart">
<script src="jq/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $("#adddepart").click(function () {
            $('#addde').append("<form method=\"post\" action=\"adddepartment\">\n" +
                "    部门名称：<input name=\"T_NAME\"  type=\"text\"><br>\n" +
                "    <input type=\"submit\" value=\"新增\">\n" +
                "</form>")
            $("#adddepart").attr("disabled","disabled")
        })
    })
</script>

<div id="addde"></div>

<input type="button" value="新增职位" id="showaddpoform">
<script>
    $(function () {
        $("#showaddpoform").click(function () {
            $("#addpoform").attr("style","display:")
        })
    })
</script>
<form method="post" action="addposition" style="display: none" id="addpoform">
    <select name="did">
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
    职位名称：<input type="text" name="T_NAME">
    <input type="submit" value="新增职位">
</form>


<br>
<hr>

<%

    if(departments!=null&&departments.size()!=0){
        int i=0;
        %>
<ul>
<%
        for (Department department : departments) {
            i++;
            %>
            <li class="department">
                <p>部门：<%=department.getT_NAME()%></p>
                <p>成立时间：<%=department.getT_TIMES()%></p>
                <a href="deletedepartment?did=<%=department.getT_ID()%>">删除部门</a>
                <input type="button" value="修改部门" id="updatedepartment<%=i%>">
                <div id="updepart<%=i%>"></div>
                <script>
                    $(function () {
                        var a=<%=i%>
                        var uppid='updatedepartment'+a
                        var tid='updepart'+a
                        $("#"+uppid).click(function () {
                            $('#'+tid).append("<form method=\"post\" action=\"updatedepartment\">\n" +
                                "    部门名称：<input name=\"T_NAME\" type=\"text\"><br>\n" +
                                "    <input type=\"hidden\" value=\"<%=department.getT_ID()%>\" name=\"did\">\n" +
                                "    <input type=\"submit\" value=\"修改\">\n" +
                                "</form>")
                            $("#"+uppid).attr("disabled","disabled")
                        })
                    })
                </script>
                <span>
                    <h4>职位:</h4>
                     <%
                if(positions!=null&&positions.size()!=0){
                    int j=0;
%>
                   <ul>
                    <%
                        for (Position position : positions) {
                            j++;
                            if(position.getT_IDDEPARTMENT()==department.getT_ID()){

                            %>
    <li class="position">
        <span><%=position.getT_NAME()%></span>
        <a href="deleteposition?pid=<%=position.getT_ID()%>">删除职位</a>
        <input type="button" value="修改职位" id="updateposition<%=j%>">
        <div id="upposit<%=j%>"></div>
        <script>
            $(function () {
                var a=<%=j%>
                var uppid='updateposition'+a
                var tid='upposit'+a
                $("#"+uppid).click(function () {
                    $('#'+tid).append("<form action=\"updateposition\" method=\"post\">\n" +
                        "    职位名称：<input name=\"T_NAME\" type=\"text\"><br>\n" +
                        "    <input type=\"hidden\" value=\"<%=position.getT_ID()%>\" name=\"pid\">\n" +
                        "    <input type=\"hidden\" value=\"<%=department.getT_ID()%>\" name=\"did\">\n" +
                        "    <input type=\"submit\" value=\"修改\">\n" +
                        "</form>")
                    $("#"+uppid).attr("disabled","disabled")
                })
            })
        </script>

        <a href="toshowstaff?pid=<%=position.getT_ID()%>">查询对应员工</a>
    </li>
    <%
            }
        }
        %>
                   </ul>
                        <%

    }else {
        }
    %>
                </span>


            </li>
<%
        }
        %>
</ul>
<%
    }
    else {
        %>

<h3>暂无部门</h3>
<%
    }
%>

</body>
</html>