package controller;

import model.Attendance;
import model.Department;
import model.Position;
import model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AttendanceService;
import service.DepartmentService;
import service.StaffService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;
    @Resource
    private AttendanceService attendanceService;

    @RequestMapping("tostaffview")
    public String toshowstaff()throws Exception {
       return "staffview";

    }

    @RequestMapping("toshowstaff")
    public String toshowstaff(Integer pid,HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        List<Staff> staff = staffService.selectStaffbyallposition(pid);
        session.setAttribute("pstaff",staff);
        return "showstaff";

    }
    @RequestMapping("tostafflist")
    public String tostafflist( HttpSession session)throws Exception {
        List<Department> departments = departmentService.selectAllDepartment();
        session.setAttribute("alldepartment",departments);
        return "stafflist";

    }
    @RequestMapping("selectstaffbypid")
    @ResponseBody
    public List<Staff> selectpositbypid(Integer pid){


        System.out.println(pid);
        List<Staff> staff = staffService.selectStaffbyposition(pid);
        System.out.println(staff);
        return staff;
    }

    @RequestMapping("dimission")
    public void dimission(String T_REASON,HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff = (Staff)session.getAttribute("staff");

        Staff staff1 = staffService.selectStaffbyid(staff.getT_ID());
        staff1.setT_REASON(T_REASON);
        staff1.setT_WORKINGSTATE(2);
        if(staffService.updateStaff(staff1)){
            resp.getWriter().write("<script>alert(\"离职成功\");window.location.href='logout';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"离职失败\");window.location.href='tostaffview';</script>");
        }
    }



    @RequestMapping("tostaff1")
    public void tostaff1(Integer sid,HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff = staffService.selectStaffbyid(sid);
        staff.setT_WORKINGSTATE(1);
        Date t_entrytime = staff.getT_ENTRYTIME();
        Date date=new Date();
        long l = (date.getTime() - t_entrytime.getTime()) / (86400000 * 30);
        if(l>=30){
            if(staffService.updateStaff(staff)){
                resp.getWriter().write("<script>alert(\"转正成功\");window.location.href='toshowstaff';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"转正失败\");window.location.href='toshowstaff';</script>");
            }
        }else {
            resp.getWriter().write("<script>alert(\"转正失败，未满30天\");window.location.href='toshowstaff';</script>");
        }
    }



    @RequestMapping("dimissiona")
    public void dimissiona(Integer sid,String T_REASON,HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff1 = staffService.selectStaffbyid(sid);
        staff1.setT_REASON(T_REASON);
        staff1.setT_WORKINGSTATE(2);
        if(staffService.updateStaff(staff1)){
            resp.getWriter().write("<script>alert(\"辞退成功\");window.location.href='toshowstaff';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"辞退失败\");window.location.href='toshowstaff';</script>");
        }
    }

}
