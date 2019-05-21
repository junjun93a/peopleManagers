package controller;

import model.Admin;
import model.Staff;
import model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AdminService;
import service.StaffService;
import service.VisitorService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class VisitorController {

    @Resource
    private VisitorService visitorService;

    @Resource
    private AdminService adminService;

    @Resource
    private StaffService staffService;


    @RequestMapping("loginv")
    public String loginv(String T_ACCOUNT,String T_PASS, String log,HttpSession session, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        if(log.equals("visitor")){
            Visitor visitor=new Visitor(T_ACCOUNT,T_PASS);
            Visitor visitor1 = visitorService.login(visitor);
            if(visitor1!=null){
                session.setAttribute("visitor",visitor1);
                session.setAttribute("logpeople",1);
                return "forward:tovrecruit";
            }
            return "loginview";
        }else if(log.equals("staff")){
            Staff staff=new Staff(T_ACCOUNT,T_PASS);
            Staff staff1 = staffService.selectStaffbyaccountandpass(staff);
            if(staff1!=null){
                session.setAttribute("staff",staff1);
                return "forward：tostaffview";
            }
            return "loginview";
        }else if(log.equals("admin")){
            Admin admin=new Admin(T_ACCOUNT,T_PASS);
            Admin admin1 = adminService.adminlogin(admin);
            if(admin1!=null){
                session.setAttribute("admin",admin1);
                return "forward:toadmin";
            }
            return "loginview";
        }else {
            return "loginview";
        }
    }

    @RequestMapping("logout")
    public String logout(HttpSession session)throws Exception{
        session.invalidate();
        return "forward:toindex";
    }



    @RequestMapping("tologinview")
    public String tologinv()throws Exception{
        return "loginview";
    }

    @RequestMapping("registerS")
    public void RegisterServlet(String T_ACCOUNT,Visitor visitor,HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        System.out.println(T_ACCOUNT);
        System.out.println(visitor);
        if("checkname".equals(req.getParameter("method"))){
            if(T_ACCOUNT==null){
                resp.getWriter().write("-1");
            }
            else if(visitorService.selectvisitorbyaccount(visitor)){
                resp.getWriter().write("0");//有用户
            }else {
                resp.getWriter().write("1");
            }
        }else {
            if (visitorService.insertvisitor(visitor)) {
                resp.getWriter().write("<script>alert(\"注册成功\");window.location.href='tologinview';</script>");
            } else {
                resp.getWriter().write("<script>alert(\"注册失败\");window.location.href='toregisterv';</script>");
            }
        }
    }

    @RequestMapping("toindex")
    public String toindex()throws Exception{
        return "../../index";
    }

    @RequestMapping("toregisterv")
    public String toregisterv()throws Exception{
        return "registerview";
    }


    @RequestMapping("tovisitorview")
    public String tovisitorview()throws Exception{
        return "visitorview";
    }
}
