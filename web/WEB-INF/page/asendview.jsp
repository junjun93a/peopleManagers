<%@ page import="model.Send" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/20
  Time: 10:04
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
        .menu{
            margin-left: 20px;
        }
    </style>
</head>
<body>
<span class="menu"><a href="toasendview?tree=0">查看所有投递</a></span>
<span class="menu"><a href="toasendview?tree=1">查看未读投递</a></span>
<span class="menu"><a href="toasendview?tree=2">查看已读投递</a></span>
<span class="menu"><a href="toasendview?tree=3">查看已通知面试投递</a></span>
<span class="menu"><a href="toasendview?tree=4">查看已面试投递</a></span>
<%
    List<Send> sends = (List<Send>)session.getAttribute("asends");
    if(sends!=null&&sends.size()!=0){
        int i=0;
%>
<ul>
    <%
        for (Send send : sends) {
            i++;
    %>
    <li>
        <p>招聘信息：
            <span>
                <%=send.getT_RECRUITDE()%>
            </span>
        </p>
        <p>简历信息：
            <span>
                <%=send.getT_RESUMEDE()%>
            </span>
        </p>

        <%
            if(send.getT_STATE()==0){
        %>
        <p>状态：未读</p>
        <a href="toreadresume?reid=<%=send.getT_IDRESUME()%>&seid=<%=send.getT_ID()%>">查看简历详情</a>
        <%
        }else if(send.getT_STATE()==1){

        %>
        <p>状态：已读</p>
        <input type="button" value="面试邀请" id="interview<%=i%>">
        <script src="jq/jquery-3.1.0.js"></script>
        <script>
            $(function () {
                var a=<%=i%>
                var pppid='interview'+a
                var upid='timeset'+a
                $("#"+pppid).click(function () {
                    $("#"+upid).append("<form method=\"post\" action=\"tointerview\">\n" +
                        "                面试时间：<input type=\"date\" name=\"time\">\n" +
                        "                <input type=\"hidden\" value=\"<%=send.getT_ID()%>\" name=\"reid\"> \n" +
                        "                <input type=\"submit\" value=\"发送\">\n" +
                        "            </form>")
                    $("#"+pppid).attr("disabled","disabled")
                })
            })
        </script>

        <span id="timeset<%=i%>">

        </span>
        <%
        }else if(send.getT_STATE()==2){
        %>
        <p>状态：已面试</p>
        <a href="toyesstaff">录用</a>
        <a href="tonostaff?sid=<%=send.getT_ID()%>">不录用</a>
        <%
        }else if(send.getT_STATE()==5){
        %>

        <p>状态：放弃面试</p>
        <%
            }else if(send.getT_STATE()==3){
                %>
        <p>状态：已录用</p>
        <%
            }else if(send.getT_STATE()==4){
                %>
        <p>状态：未录用</p>
        <%
            }
        %>
    </li>

    <%
        }
    %>
</ul>
<%

}else {
%>
<h3>暂无信息</h3>
<%
    }
%>
<br>
<hr>
<a href="/toadmin">返回</a>
</body>
</html>