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
        if(staffService.updateStaff(staff)){
            resp.getWriter().write("<script>alert(\"转正成功\");window.location.href='toshowstaff';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"转正失败\");window.location.href='toshowstaff';</script>");
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


//打卡前先搜当天记录，没有就0，有就1
    @RequestMapping("tocard")
    public String tocard(HttpSession session)throws Exception {
        Staff staff = (Staff)session.getAttribute("staff");
        Date now=new Date();
        DateFormat date1=new SimpleDateFormat("yyyy-MM-dd");
        String T_DATE=date1.format(now);
        Attendance attendance = attendanceService.selectAttendancebydateandsid(T_DATE, staff.getT_ID());
        if(attendance==null){
            session.setAttribute("isconfirm",0);
        }else {
            session.setAttribute("isconfirm",1);
        }
        return "cardview";

    }



    @RequestMapping("confirmAttendance")
    @ResponseBody
    public String selectpositbydid(String time,HttpSession session,HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff = (Staff)session.getAttribute("staff");
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timec = date.parse(time);//打卡时间
        DateFormat date1=new SimpleDateFormat("yyyy-MM-dd");

        String T_DATE=date1.format(timec);
        String start=T_DATE+" 09:00:00";
        String end=T_DATE+" 18:00:00";
        Date stime = date.parse(start);//当日上班时间
        Date etime = date.parse(end);//当日下班时间
        Attendance attendance1 = attendanceService.selectAttendancebydateandsid(T_DATE, staff.getT_ID());
        if(attendance1==null){
            long late = (timec.getTime() - stime.getTime()) / (3600000 * 2);//比较上班打卡时间
            Integer error=0;
            if(late<=0){
                 error=0;
            }else if(late>0&&late<=2){
                error=1;
            }else if(late>2){
                error=3;
            }
            Attendance attendance = new Attendance(T_DATE,time,staff.getT_ID(),error);
           if(attendanceService.insertAttendance(attendance)){
               return time;

           }else {
               return null;
           }
        }else {
            long late=(etime.getTime()-timec.getTime()) / (3600000 * 2);//比较下班打卡时间
            long before = (timec.getTime() - stime.getTime()) / (3600000 * 2);//比较上班打卡时间
            Integer error=attendance1.getT_ERROR();
            if(error==0){
                if(late<=0){
                    error=0;
                }else if(late>0&&late<=2){
                    error=1;
                }else if(late>2){
                    error=3;
                }
            }else if(error==1){
                if(late+before>2){  //迟到早退合计超过2小时
                    error=3;
                }
            }


            attendance1.setT_ENDTIME(time);
            attendance1.setT_ERROR(error);
           if(attendanceService.updateAttendance(attendance1)) {
               return time;
           }else {
               return null;
           }
        }
    }
}
