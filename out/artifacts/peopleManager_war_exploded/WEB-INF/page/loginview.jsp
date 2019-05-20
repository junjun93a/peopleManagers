<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/14
  Time: 20:43
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
<form id="form1" action="loginv" method="post" onsubmit="return checkAll()">
    <h3><b>密码登陆</b></h3>
    <div id="div1">账号：<input type="text" name="T_ACCOUNT" id="username" onblur="checkName()" required placeholder="请输入登陆账号">
        <span id="span_name"></span><br/></div>
    <div id="div2">密码：<input type="password" name="T_PASS" id="password" onblur="checkPassword()" required placeholder="请输入账号密码">
        <span id="span_password"></span><br/></div>
    类　别: <input  type="radio" name="log" value="visitor" checked>游客
    <input  type="radio" name="log" value="staff">员工
    <input  type="radio" name="log" value="admin">管理员
    <br/>
    <%--<div id="div3"><input type="checkbox" name="relog" value="on">记住密码</div>--%>
    <input id="input1" type="submit" value="登陆" onclick="return checkAll()"><br/>
    <a href="toindex">返回</a>
    <script>
        function checkName() {
            var username = document.getElementById("username");
            var span_name = document.getElementById("span_name");
            var value = username.value;
            var reg=/^[a-zA-Z_].{4,9}$/;

            if(!reg.test(value)){
                span_name.innerHTML="<font color='red' face='仿宋'>字母或者下划线开头，长度为5-10</font>";
                return false;
            }else{
                span_name.innerHTML="";
                return true;
            }
        }
        function checkPassword() {
            var password=document.getElementById("password");
            var spassword=document.getElementById("span_password");

            if((/^\d*$/.test(password.value)) || password.value.length<6 ){
                spassword.innerHTML="<font color='red' face='仿宋'>不能为纯数字，长度不能低于6位</font>";
                return false;
            }else {
                spassword.innerHTML="";
                return true;
            }
        }
        function checkAll() {
            return checkName()&&checkPassword();
        }
    </script>
</form>
</body>
</html>