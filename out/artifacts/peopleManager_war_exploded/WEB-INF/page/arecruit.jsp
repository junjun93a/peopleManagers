<%@ page import="model.Recruit" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/17
  Time: 15:28
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

<a href="toaddrecruit">新增招聘信息</a>
<a href="toadmin">管理员中心</a>
<br>
<hr>
<%
    List<Recruit> recruitlist =(List<Recruit>) session.getAttribute("arecruitlist");
    if(recruitlist!=null&&recruitlist.size()!=0){
        int i=0;
%>
<ul>
    <%
        for (Recruit recruit : recruitlist) {
            i++;
    %>
    <li>
        <div>
            <h3><a href=""><%=recruit.getT_POSITION()%></a> </h3>
            <p><span><%=recruit.getT_MONEY()%>元</span>
                <span><%=recruit.getT_CITY()%></span>
                <span><%=recruit.getT_EDUCATION()%></span>
                <span><%=recruit.getT_AGE()%>年以上</span>
            </p>
            <%
                if(recruit.getT_LAUNCH()==0){
                    %>
            <p>
                未发布
            </p>
            <%
                }else {

                    %>
            <p>
                发布日期：<%=recruit.getT_DATES()%>
            </p>
            <%
                }
            %>

        </div>
        <div>
            <h4>详情：</h4>
            <%=recruit.getT_DETAIL()%>
        </div>
    </li>
    <li>
        <%
            if(recruit.getT_LAUNCH()==0){
                %>
        <form action="changelaunch" method="post">
            <input type="hidden" name="rid" value="<%=recruit.getT_ID()%>">
            <input type="submit" value="发布">
        </form>
        <a href="toupdaterecruit?rid=<%=recruit.getT_ID()%>">修改招聘</a>
        <a href="deleterecruit?rid=<%=recruit.getT_ID()%>">删除招聘</a>


        <%
            }else if (recruit.getT_LAUNCH()==1){
                %>
        <form action="changelaunch" method="post">
            <input type="hidden" name="rid" value="<%=recruit.getT_ID()%>">
            <input type="submit" value="撤回发布">
        </form>
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
<h3>暂无招聘信息！</h3>
<%
    }

%>



<%
    int tp = (int) session.getAttribute("atp");
    for (int i = 1; i <= tp; i++) {
%>
<a href="tovrecruit?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>


</body>
</html>