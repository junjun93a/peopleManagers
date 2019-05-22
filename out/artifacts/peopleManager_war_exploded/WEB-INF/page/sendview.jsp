<%@ page import="service.SendService" %>
<%@ page import="service.impl.SendServiceImpl" %>
<%@ page import="model.Visitor" %>
<%@ page import="model.Send" %>
<%@ page import="java.util.List" %>
<%@ page import="service.RecruitService" %>
<%@ page import="service.impl.RecruitServiceImpl" %>
<%@ page import="service.ResumeService" %>
<%@ page import="service.impl.ResumeServiceImpl" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.StaffDao" %>
<%@ page import="model.Staff" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/16
  Time: 22:38
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

<span class="menu"><a href="tosendview?tree=0">查看所有投递招聘</a></span>
<span class="menu"><a href="tosendview?tree=1">查看通知面试招聘</a></span>
<span class="menu"><a href="tosendview?tree=2">查看已录用面试</a></span>
<span class="menu"><a href="tosendview?tree=3">查看未录用面试</a></span>
<span class="menu"><a href="tosendview?tree=4">查看已取消面试</a></span>
<%
    List<Send> sends = (List<Send>)session.getAttribute("sends");
    if(sends!=null&&sends.size()!=0){
        %>
<ul>
<%
        for (Send send : sends) {
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
            if(send.getT_STATE()==0||send.getT_STATE()==1){
                %>
        <p>招聘状态：已投递</p>
        <a href="deletesend?id=<%=send.getT_ID()%>">撤消投递</a>
        <%
            }else if(send.getT_STATE()==2){

                %>
        <p>招聘状态：待面试</p>
        <h4>面试时间：<%=send.getT_TIMES()%></h4>
        <a href="toyes?id=<%=send.getT_ID()%>">参加面试</a>
        <a href="tono?id=<%=send.getT_ID()%>">放弃面试</a>
        <%
            }else if(send.getT_STATE()==3){
                ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
                StaffDao staffDao= (StaffDao) context.getBean("staffDao");
                Staff staff = staffDao.selectStaffbyid(send.getT_IDSTAFF());
        %>
        <p>招聘状态：录取</p>
        <span><%=staff.toStringap()%></span>
        <%
            }else if (send.getT_STATE()==4){
                %>
        <p>招聘状态：未录取</p>
        <%
            }else if(send.getT_STATE()==5){
        %>
        <p>招聘状态：取消面试</p>
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
<h3>暂无信息，去<a href="tovrecruit">投递</a> </h3>
<%
    }
%>
<br>
<hr>
<a href="tovisitorview">返回</a>

</body>
</html>