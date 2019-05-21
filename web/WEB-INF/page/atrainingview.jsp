<%@ page import="model.Training" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/21
  Time: 11:33
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

<a href="toadmin">返回</a>
<input type="button" value="新增培训" id="addtrain">

<script src="jq/jquery-3.1.0.js"></script>
<script>
    $(function () {
        $('#addtrain').click(function () {
            $("#addtrainform").append("<form action=\"addatrain\" method=\"post\">\n" +
                "    培训标题：<input type=\"text\" name=\"T_TITLE\"><br>\n" +
                "    开始时间：<input type=\"date\" name=\"T_STARTTIME\"><br>\n" +
                "    结束时间：<input type=\"date\" name=\"T_ENDTIME\"><br>\n" +
                "    培训地点：<input type=\"text\" name=\"T_ADDRESS\"><br>\n" +
                "    培训内容：<input type=\"text\" name=\"T_DETAIL\"><br>\n" +
                "    <input type=\"submit\" value=\"新增\">\n" +
                "</form>")
            $("##addtrain").attr("disabled","disabled")
        })
    })
</script>
<div id="addtrainform"></div>
<br>
<hr>
<%
        List<Training> trainings =(List<Training>) session.getAttribute("atrainings");
        if(trainings!=null&&trainings.size()!=0){
                int i=0;
            %>
<ul>
<%
            for (Training training : trainings) {
                i++;
                Date t_endtime = training.getT_ENDTIME();
                Date t_starttime = training.getT_STARTTIME();
                Date now=new Date();
                Integer indatei = null;
                String indate = null;
                if(t_endtime.getTime()>=now.getTime()&&t_starttime.getTime()<=now.getTime()&&training.getT_LAUNCH()==0){
                    indate="需修正开始时间";
                } else if(t_endtime.getTime()>=now.getTime()&&t_starttime.getTime()<=now.getTime()){
                    indatei=1;indate="正在培训中";
                }else if(t_starttime.getTime()>=now.getTime()){
                    indatei=0; indate="培训未开始";
                }else if(t_endtime.getTime()<=now.getTime()){
                    indatei=2; indate="培训已失效";
                }


                %>
    <li><%=training.toString()%></li>
    <span>培训状态：<%=indate%></span>
    <%
    if(training.getT_LAUNCH()==0&&indatei==0){
        %>
    <span>未发布：<a href="trainlaunch?tid=<%=training.getT_ID()%>">发布</a></span>
    <span><a href="tochoicepeople?tid=<%=training.getT_ID()%>">管理培训人员</a></span>
    <a href="deletetrain?tid=<%=training.getT_ID()%>">删除</a>
    <span><input type="button" value="修改" id="updatetrain<%=i%>"></span>
    <div id="uptrain<%=i%>"></div>
    <script>
        $(function () {
            var a=<%=i%>
            var uppid='updatetrain'+a
            var tid='uptrain'+a
            $("#"+uppid).click(function () {
                $('#'+tid).append("<form action=\"updatetrain\" method=\"post\">\n" +
                    "        <input type=\"hidden\" value=\"<%=training.getT_ID()%>\" name=\"T_ID\">\n" +
                    "        培训标题：<input type=\"text\" name=\"T_TITLE\" value=\"<%=training.getT_TITLE()%>\"><br>\n" +
                    "        培训内容：<input type=\"text\" name=\"T_DETAIL\" value=\"<%=training.getT_DETAIL()%>\"><br>\n" +
                    "        开始时间：<input type=\"date\" name=\"T_STARTTIME\" value=\"<%=training.getT_STARTTIME()%>\"><br>\n" +
                    "        结束时间：<input type=\"date\" name=\"T_ENDTIME\" value=\"<%=training.getT_ENDTIME()%>\"><br>\n" +
                    "        培训地点：<input type=\"text\" name=\"T_ADDRESS\" value=\"<%=training.getT_ADDRESS()%>\"><br>\n" +
                    "        <input type=\"submit\" value=\"修改\">\n" +
                    "    </form>")
                $("#"+uppid).attr("disabled","disabled")
            })
        })
    </script>

    <%
    }else if(indatei==2){
        %>
    <a href="deletetrain?tid=<%=training.getT_ID()%>">删除</a>
    <%
    }
            }
            %>
</ul>
    <%
        }else {
            %>
<h3>无培训信息</h3>
<%
        }

        %>


<%
    int tp = (int) session.getAttribute("attp");
    for (int i = 1; i <= tp; i++) {
%>
<a href="toatrainingview?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
</body>
</html>