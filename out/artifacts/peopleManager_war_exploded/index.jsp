<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/8
  Time: 16:52
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

        #div1 a{
            float: left;
            margin-left: 10px;
            background: #FF6600;
            font-weight: bold;
            font-style: italic;
        }
        #div1{
            background-color: #FF6600;
            float: left;
            width: 1800px;
            height: 25px;
        }
        #div0{
            background-color: #FF6600;
        }

    </style>
</head>
<body>
<div id="div0">
<div id="div1">
    <a href="tologinview">登陆</a>
    <a href="toregisterv">游客注册</a>
    <a href="tovrecruit">查看招聘岗位</a>
</div>

<div class="index-main" id="J-index-main" style="position:relative;height:auto;width: auto;top:25px;">
    <img class="index-image" src="https://docs.alibabagroup.com/assets2/images/cn/home/home_banner_1.png" style="vertical-align: middle; width: 1880px; height: 900px;" alt="">
    <div style="position: absolute;top:0;left:0;width: 100%;height: 100%;"></div>
    <div class="index-mid-box" style="height:100%;">
        <form class="J-search-form">
            <div class="float-mid" style="top: 50%;margin-left: 650px;margin-top: -600px;">
                <p style="font-size: 54px;color: black;line-height: 56px;" class="en-world">If not now, when?</p>
                <p style="font-size: 54px;color: black;line-height: 56px;" class="en-world">If not me, who?</p>
                <p style="font-size: 34px;color: black;margin-bottom:38px;line-height: 48px;">此时此刻，非我莫属！</p>
            </div>
        </form>
    </div>
</div>

</div>

</body>
</html>