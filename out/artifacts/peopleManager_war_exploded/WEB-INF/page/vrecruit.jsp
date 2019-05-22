<%@ page import="service.RecruitService" %>
<%@ page import="service.impl.RecruitServiceImpl" %>
<%@ page import="model.Recruit" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="dao.PositionDao" %>
<%@ page import="dao.DepartmentDao" %>
<%@ page import="model.Position" %>
<%@ page import="model.Department" %><%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2019/5/14
  Time: 20:41
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
<%
    Integer logpeople = (Integer)session.getAttribute("logpeople");
    if(logpeople==null){
        %>
<a href="tologinview">登陆</a>
<a href="toregisterv">游客注册</a>
<%
    }else if(logpeople==1){
       %>
<a href="logout">退出</a>
<a href="tovisitorview">进入游客中心</a>
<%
    }
%>
<br>
<hr>
<%
    List<Recruit> recruitlist =(List<Recruit>) session.getAttribute("recruitlist");
    if(recruitlist!=null&&recruitlist.size()!=0){
        ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        PositionDao positionDao= (PositionDao) context.getBean("positionDao");
        DepartmentDao departmentDao= (DepartmentDao) context.getBean("departmentDao");
        %>
<ul>
    <%
        for (Recruit recruit : recruitlist) {
            Position position = positionDao.selectPositionbyid(recruit.getT_POSITION());
            Department department = departmentDao.selectDepartmentbyid(position.getT_IDDEPARTMENT());
            %>

    <li>
        <div>
            <h3>部门<%=department.getT_NAME()%> —— 职位<%=position.getT_NAME()%> </a> </h3>
            <p><span><%=recruit.getT_MONEY()%>元</span>
                <span><%=recruit.getT_CITY()%></span>
                <span><%=recruit.getT_EDUCATION()%></span>
                <span><%=recruit.getT_AGE()%>年以上</span>
            </p>
            <p>
                发布日期：<%=recruit.getT_DATES()%>
            </p>
        </div>
        <div>
            <h4>详情：</h4>
            <%=recruit.getT_DETAIL()%>
        </div>
    </li>
<li><a href="tosend?rid=<%=recruit.getT_ID()%>">投递简历</a></li>
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
    int tp = (int) session.getAttribute("tp");
    for (int i = 1; i <= tp; i++) {
%>
<a href="tovrecruit?currentPage=<%=i%>"><%=i%></a>
<%
    }
%>
</body>
</html>