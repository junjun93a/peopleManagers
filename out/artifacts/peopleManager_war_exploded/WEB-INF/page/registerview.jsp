<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/14
  Time: 20:50
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
<form action="registerS" method="post">
    账 户 名:<input type="text" name="T_ACCOUNT" id="username"  required placeholder="请输入注册账号"/>
    <span id="span_name"></span><br/>

    密　　码:<input type="password" name="T_PASS" id="password" disabled required placeholder="请输入设置密码"/>
    <span id="span_password"></span><br/>
    密码确认:<input type="password" id="password2" disabled>
    <span id="s-password2"></span><br>

    性　别: <input id=sex1 type="radio" name="T_SEX" value="男" checked>男
    <input id=sex2 type="radio" name="T_SEX" value="女">女<br/>
    真实姓名：<input type="text" name="T_NAME" id="realname" required placeholder="请输入真实姓名">
    <span id="span_realname"></span><br/>
    <input id="butt" type="submit" value="注册完成"/><br>
    <a href="toindex">返回</a>
</form>

<script src="jq/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $("#username").keyup(function () {
            var a=$("#username").val();
            var reg=/^[a-zA-Z_].{4,9}$/;
            if(reg.test(a)){
                $.post("registerS",{T_ACCOUNT:$("#username").val(),method:"checkname"},function (obj) {
                    if(obj==1){
                        $("#span_name").html("账户名已存在");
                        $("#span_name").css({"color":"red","face":"仿宋","font-size":"10px"});
                        $("#butt").attr("disabled",true);
                    }else if(obj==0){
                        $("#span_name").html("OK√");
                        $("#span_name").css({"color":"green","face":"仿宋","font-size":"16px"});
                        $("#butt").attr("disabled",false);
                        $("#password").removeAttr("disabled");
                        $("#password2").removeAttr("disabled");
                    }else if (obj==-1){
                        $("#butt").attr("disabled",true);
                    }
                })
            }else{
                $("#span_name").html("字母或者下划线开头，长度为5-10");
                $("#span_name").css({"color":"red","face":"仿宋","font-size":"10px"});
                $("#butt").attr("disabled",true);
            }

        })
        $("#password").keyup(function () {
            var password=$("#password").val();
            var reg=/^\d*$/;
            if(!reg.test(password)&& password.length>=6){
                $("#span_password").html("OK√");
                $("#span_password").css({"color":"green","face":"仿宋","font-size":"16px"});
                $("#butt").attr("disabled",false);

            }else {
                $("#span_password").html("不能为纯数字，长度不能低于6位");
                $("#span_password").css({"color":"red","face":"仿宋","font-size":"10px"});
                $("#butt").attr("disabled",true);
            }

        })
        $("#password2").keyup(function () {
            var password2=$("#password2").val();
            var password=$("#password").val();
            if(password!=password2){
                $("#s-password2").html("两次密码不一致")
                $("#s-password2").css({"color":"red","face":"仿宋","font-size":"10px"})
                $("#butt").attr("disabled",true);
            }else{
                $("#s-password2").html("OK√")
                $("#s-password2").css({"color":"green","face":"仿宋","font-size":"16px"})
                $("#butt").attr("disabled",false);
            }
        })
        $("#realname").keyup(function () {
            var realname=$("#realname").val();
            var reg=/^[\xa0-\xff]{2,4}$/;
            if(!reg.test(realname)){
                $("#span_realname").html("OK√");
                $("#span_realname").css({"color":"green","face":"仿宋","font-size":"16px"})
                $("#butt").attr("disabled",false);
            }else {
                $("#span_realname").html("姓名格式错误");
                $("#span_realname").css({"color":"red","face":"仿宋","font-size":"10px"})
                $("#butt").attr("disabled",true);
            }
        })
    })

</script>

</body>
</html>