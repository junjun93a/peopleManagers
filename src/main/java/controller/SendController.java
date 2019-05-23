package controller;

import model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class SendController {

    @Resource
    private SendService sendService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private RecruitService recruitService;
    @Resource
    private StaffService staffService;
    @Resource
    private VisitorService visitorService;
    @Resource
    private PositionService positionService;
    @RequestMapping("tosend")
    public String tosend(Integer rid,HttpSession session, HttpServletRequest req, HttpServletResponse resp)throws Exception{
        Visitor visitor =(Visitor) session.getAttribute("visitor");
        if(visitor==null){
            return "loginview";
        }else {
            List<Resume> resumes = resumeService.selectResumebyvid(visitor.getT_ID());
            session.setAttribute("sendrid", rid);
            session.setAttribute("resumes", resumes);
            return "choiceresume";
        }
    }




    @RequestMapping("addsend")
    public void addsend(Integer resumeid,HttpSession session, HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Integer recuriteid =(Integer) session.getAttribute("sendrid");
        Recruit recruit = recruitService.selectRecruitById(recuriteid);
        Resume resume = resumeService.selectResumebyid(resumeid);
        Position position = positionService.selectPositionbyid(recruit.getT_POSITION());
        String recruitde="职位："+position.getT_NAME()+"、日期："+recruit.getT_DATES()+"、薪资："+recruit.getT_MONEY()+"、工作经验："+recruit.getT_AGE()+"、工作地点"+recruit.getT_CITY();
        String resumede=resume.toString();
        Visitor visitor =(Visitor) session.getAttribute("visitor");
        Send send=new Send(recuriteid,visitor.getT_ID(),resumeid,0,recruitde,resumede);
        if(sendService.insertSend(send)){
            resp.getWriter().write("<script>alert(\"投递成功\");window.location.href='tovrecruit';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"投递失败\");window.location.href='tovrecruit';</script>");
        }
    }
    @RequestMapping("tosendview")
    public void sendview( HttpSession session,HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Visitor visitor =(Visitor) session.getAttribute("visitor");
        String tree="0";
        String tree1=req.getParameter("tree");
        List<Send> sends = sendService.selectSendbyvisitor(visitor.getT_ID());
        if(tree1!=null){
            tree=tree1;
        }
        if(tree.equals("1")){
            sends = sendService.selectSendbystaffvisitor(2,visitor.getT_ID());
        }else if(tree.equals("2")){
            sends = sendService.selectSendbystaffvisitor(3,visitor.getT_ID());
        }else if(tree.equals("3")){
            sends = sendService.selectSendbystaffvisitor(4,visitor.getT_ID());
        }else if(tree.equals("4")) {
            sends = sendService.selectSendbystaffvisitor(5, visitor.getT_ID());
        }else if (tree.equals("5")){
            sends = sendService.selectSendbystaffvisitor(6, visitor.getT_ID());
        }
        session.setAttribute("sends",sends);
        req.getRequestDispatcher("/WEB-INF/page/sendview.jsp").forward(req,resp);
    }


    @RequestMapping("toasendview")
    public void toasendview( HttpSession session,HttpServletRequest req, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        String tree="0";
        String tree1=req.getParameter("tree");
        List<Send> sends = sendService.selectSend();
        List staffs=new ArrayList<Integer>();
        staffs.add(3);
        staffs.add(4);
        if(tree1!=null){
            tree=tree1;
        }
        if(tree.equals("1")){
            sends = sendService.selectSendbystaff(0);
        }else if(tree.equals("2")){
            sends = sendService.selectSendbystaff(1);
        }else if(tree.equals("3")){
            sends = sendService.selectSendbystaff(6);
        }else if(tree.equals("4")) {
            sends = sendService.selectSendbystaffs(staffs);
        }
        session.setAttribute("asends",sends);
        req.getRequestDispatcher("/WEB-INF/page/asendview.jsp").forward(req,resp);
    }


    @RequestMapping("deletesend")
    public void deletesend(Integer id, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        if(sendService.deleteSend(id)){
            resp.getWriter().write("<script>alert(\"撤销成功\");window.location.href='tosendview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"撤销失败\");window.location.href='tosendview';</script>");
        }
    }

    @RequestMapping("toyes")
    public void yesmianshi(Integer id, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Send send = sendService.selectSendbyid(id);
        send.setT_STATE(6);
        if(sendService.updateSend(send)){
            resp.getWriter().write("<script>alert(\"申请参加面试成功\");window.location.href='tosendview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"申请参加面试失败\");window.location.href='tosendview';</script>");
        }
    }

    @RequestMapping("tono")
    public void nomianshi(Integer id, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Send send = sendService.selectSendbyid(id);
        send.setT_STATE(5);
        if(sendService.updateSend(send)){
            resp.getWriter().write("<script>alert(\"放弃参加面试成功\");window.location.href='tosendview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"放弃参加面试失败\");window.location.href='tosendview';</script>");
        }
    }



    @RequestMapping("toreadresume")
    public String toreadresume(Integer seid, HttpServletResponse resp,HttpSession session)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Send send = sendService.selectSendbyid(seid);
        Integer reid=send.getT_IDRESUME();
        Resume resume = resumeService.selectResumebyid(reid);
        System.out.println(seid);
       session.setAttribute("sendresume",resume);
        if(sendService.updateSendbyseid(seid,1)){
            return "sendresume";
        }else {
           return "forward:toasendview";
        }
    }

    @RequestMapping("tointerview")
    public void interview(String time, Integer reid,HttpServletResponse resp, HttpSession session)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        Date date1 = date.parse(time);
        Send send = sendService.selectSendbyid(reid);
        send.setT_STATE(2);
        send.setT_TIME(date1);
        if(sendService.updateSendTime(send)){
            resp.getWriter().write("<script>alert(\"发送成功\");window.location.href='toasendview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"发送失败\");window.location.href='toasendview';</script>");
        }
    }


    @RequestMapping("tonostaff")
    public void tonostaff(Integer sid,  HttpServletResponse resp, HttpSession session)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Send send = sendService.selectSendbyid(sid);
        send.setT_STATE(4);
        if(sendService.updateSend(send)){
            resp.getWriter().write("<script>alert(\"成功\");window.location.href='toasendview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"失败\");window.location.href='toasendview';</script>");
        }
    }
    @RequestMapping("toyesstaff")
    public void toyesstaff(Integer sid,HttpServletResponse resp, HttpSession session)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Send send = sendService.selectSendbyid(sid);
        Resume resume = resumeService.selectResumebyid(send.getT_IDRESUME());
        Visitor visitor = visitorService.selectvisitorbyid(resume.getT_IDVISITOR());
        if(visitor.getT_IDSTAFF()!=null){
            Staff staff = staffService.selectStaffbyid(visitor.getT_IDSTAFF());
            staff.setT_WORKINGSTATE(0);
        }else {

        }
        Recruit recruit = recruitService.selectRecruitById(send.getT_IDRECRUIT());
        String account=visitor.getT_ACCOUNT()+resume.getT_PHONE()%100;
        String pass=visitor.getT_PASS();
        String name=resume.getT_NAME();
        String sex=resume.getT_SEX();
        Date birthday=resume.getT_BIRTHDAY();
        Long phone=resume.getT_PHONE();
        String email=resume.getT_EMAIL();
        Integer age=resume.getT_AGE();
        String address=resume.getT_ADDRESS();
        Integer workingstate=0;
        Integer position=recruit.getT_POSITION();
        Date entrytime=new Date();
        Staff staff=new Staff(account,pass,name,sex,birthday,phone,email,age,address,workingstate,position,entrytime);
        if(staffService.insertStaff(staff,sid)){
            Staff staff1 = staffService.selectStaffbyaccountandpass(staff);
            visitor.setT_IDSTAFF(staff1.getT_ID());
            visitorService.updatevisitor(visitor);
            resp.getWriter().write("<script>alert(\"录取成功\");window.location.href='toasendview';</script>");

        }else {
            resp.getWriter().write("<script>alert(\"录取失败\");window.location.href='toasendview';</script>");
        }
    }

}
