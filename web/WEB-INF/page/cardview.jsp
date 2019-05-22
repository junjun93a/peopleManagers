<%--
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

            $("#sub").mousedown(function () {
                $.post("confirmAttendance",{"time":$("#sysTime").text()},function (obj) {

                })
            })
        })


    </script>

</head>
<body>
<a href="tostaffview">返回</a>
<br>
<hr>
<h1>上下班打卡</h1>

<div>
    <span id="sysTime"></span>
    <input type="button" id="sub" name="打卡">
</div>

<div id="starttime">
    上班时间
</div>

<div id="endtime">
    下班时间
</div>
<div id="error">
    迟到旷工
</div>

</body>
</html>