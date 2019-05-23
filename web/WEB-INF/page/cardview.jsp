<%@ page import="model.Attendance" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/22
  Time: 16:27
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

        function getTime(){
            var date = new Date();
            var y = date.getFullYear();
            var m = date.getMonth()+1;
            var d = date.getDate();
            var h = date.getHours();
            var i = date.getMinutes();
            var s = date.getSeconds();
            $("#sysTime").html(y+"-"+(m>9?m:("0"+m))+"-"+d+" "+(h>9?h:("0"+h))+":"+(i>9?i:("0"+i))+":"+(s>9?s:("0"+s)));
        }

        window.onload=function(){
            window.setInterval("getTime()",1000);
        }

        $(function () {
            $("#sub").click(function () {
                $("#confirmtime").html("");
                $.post("confirmAttendance",{"time":$("#sysTime").text()},function (obj) {
                    if(obj!=null){
                        $("#confirmtime").append("<p>"+"打卡时间："+obj+"</p>")

                    }
                })
                $.post("checkAttendance",{"but":$("#sub").val()},function (obj) {
                    if(1==obj){
                        $("#sub").attr("value","下班打卡")
                    }else if(2==obj){
                        $("#sub").attr("disabled","disabled")
                    }
                })
            })
        })


    </script>

</head>
<body>
<a href="tostaffview">返回</a>
<br>
<hr>
<div>
<h1>上下班打卡</h1>

<div>
    <span id="sysTime"></span>

</div>
<div>
    <%
        Integer isconfirm = (Integer) session.getAttribute("isconfirm");
        if(0==isconfirm){
            %>
    <input type="button" id="sub" value="上班打卡">
    <%
        }else if(1==isconfirm){
            %>
    <input type="button" id="sub" value="下班打卡">
    <%
        }else if(2==isconfirm){
            Attendance showattendance =(Attendance) session.getAttribute("showattendance");
    %>
    <p>已打卡：</p>
    <p>上班打卡时间：<%=showattendance.getT_STARTTIME()%></p>
    <p>下班打卡时间：<%=showattendance.getT_ENDTIME()%></p>
    <%
        }
    %>

</div>

<div id="confirmtime">

</div>


</div>
</body>
</html>