package controller;

import model.Recruit;
import model.Resume;
import model.Send;
import model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.RecruitService;
import service.ResumeService;
import service.SendService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class SendController {

    @Resource
    private SendService sendService;
    @Resource
    private ResumeService resumeService;
    @Resource
    private RecruitService recruitService;

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
        String recruitde="职位："+recruit.getT_POSITION()+"、日期："+recruit.getT_DATES()+"、薪资："+recruit.getT_MONEY()+"、工作经验："+recruit.getT_AGE()+"、工作地点"+recruit.getT_CITY();
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
            sends = sendService.selectSendbystaff(2);
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
        send.setT_STATE(3);
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
}
