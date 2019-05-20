<%@ page import="model.Resume" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.DateFormat" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/16
  Time: 0:31
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
    </style>
</head>
<body>
<a href="tovisitorview">返回</a>
<a href="toaddresume">添加简历</a>
<br/>
<hr>
<%
    List<Resume> resume = (List<Resume>)session.getAttribute("resume");
    if(resume!=null&&resume.size()!=0){
        %>
<ul>
    <%
        int i=0;
        for (Resume resume1 : resume) {
            Date t_birthday = resume1.getT_BIRTHDAY();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String format = dateFormat.format(t_birthday);
            i++;
            %>


    <li>
        <div>
            <p>
                <h4>基础信息:</h4><br>
                <span>姓名：<%=resume1.getT_NAME()%></span>  <span>性别：<%=resume1.getT_SEX()%></span><br>
                <span>生日：<%=resume1.getT_BIRTHDAYS()%></span>  <span>电话号码：<%=resume1.getT_PHONE()%></span><br>
                <span>邮箱：<%=resume1.getT_EMAIL()%></span><br>
                <span>地址：<%=resume1.getT_ADDRESS()%></span>
            </p>
            <p>
                <h4>求职信息</h4><br>
            <span>期望职位：<%=resume1.getT_HOPEPOSITION()%></span>  <span>期望薪资：<%=resume1.getT_HOPEMONEY()%></span><br>
            <span>工龄：<%=resume1.getT_AGE()%></span> <span>学位：<%=resume1.getT_EDUCATION()%></span><br>
            <span>工作经历：<%=resume1.getT_WORKEXPERIENCE()%></span>  <span>语言技能：<%=resume1.getT_LANGUAGE()%></span><br>

            </p>
            <h4>附加信息：<%=resume1.getT_ADDINFORMATION()%></h4>
        </div>
    </li>
    <li>
        <input type="button" value="修改" id="updata<%=i%>">
        <a href="deleteresume?id=<%=resume1.getT_ID()%>">删除</a>
        <script src="jq/jquery-3.1.0.js"></script>
        <script>
            $(function () {
                var a=<%=i%>
                var pppid='updata'+a
                $("#"+pppid).click(function () {
                    $('#upresume').append("<form action=\"updateresume\" method=\"post\">\n" +
                        "    <input type=\"hidden\" name=\"T_ID\" value=\"<%=resume1.getT_ID()%>\">\n" +
                        "    <input type=\"hidden\" name=\"T_IDVISITOR\" value=\"<%=resume1.getT_IDVISITOR()%>\">\n" +
                        "    生日：<input type=\"date\" name=\"T_BIRTHDAY\" value=\"<%=format%>\">\n" +
                        "    电话号码：<input type=\"text\" name=\"T_PHONE\" value=\"<%=resume1.getT_PHONE()%>\"><br>\n" +
                        "    邮箱：<input type=\"text\" name=\"T_EMAIL\" value=\"<%=resume1.getT_EMAIL()%>\"><br>\n" +
                        "    地址：<input type=\"text\" name=\"T_ADDRESS\" value=\"<%=resume1.getT_ADDRESS()%>\"><br>\n" +
                        "    期望职位：<input type=\"text\" name=\"T_HOPEPOSITION\" value=\"<%=resume1.getT_HOPEPOSITION()%>\">\n" +
                        "    期望薪资：<input type=\"text\" name=\"T_HOPEMONEY\" value=\"<%=resume1.getT_HOPEMONEY()%>\"><br>\n" +
                        "    工龄：<input type=\"text\" name=\"T_AGE\" value=\"<%=resume1.getT_AGE()%>\">\n" +
                        "    学位：<input type=\"text\" name=\"T_EDUCATION\" value=\"<%=resume1.getT_EDUCATION()%>\"><br>\n" +
                        "    语言技能：<input type=\"text\" name=\"T_LANGUAGE\" value=\"<%=resume1.getT_LANGUAGE()%>\">\n" +
                        "    工作经历：<input type=\"text\" name=\"T_WORKEXPERIENCE\" value=\"<%=resume1.getT_WORKEXPERIENCE()%>\"><br>\n" +
                        "    附加信息:<input type=\"text\" name=\"T_ADDINFORMATION\" value=\"<%=resume1.getT_ADDINFORMATION()%>\">\n" +
                        "    <input type=\"hidden\" name=\"T_SEX\" value=\"<%=resume1.getT_SEX()%>\">\n" +
                        "    <input type=\"hidden\" name=\"T_NAME\" value=\"<%=resume1.getT_NAME()%>\">\n" +
                        "    <input type=\"submit\" value=\"提交修改\">\n" +
                        "</form>")
                    $("#"+pppid).attr("disabled","disabled")
                })
            })
        </script>
    </li>

    <%
        }
    %>
</ul>
<div id="upresume">
</div>
<%
    }else {
        %>
<h3>暂无简历，请<a href="toaddresume">添加</a> </h3>
<%
    }
%>


</body>
</html>