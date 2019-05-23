package controller;

import model.Attendance;
import model.Department;
import model.Rewardandpunish;
import model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.AttendanceService;
import service.DepartmentService;
import service.RewardandpunishService;
import service.StaffService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class AttendanceController {


    @Resource
    private AttendanceService attendanceService;

    @Resource
    private RewardandpunishService rewardandpunishService;

    @Resource
    private DepartmentService departmentService;

    @Resource
    private StaffService staffService;

    //打卡前先搜当天记录，没有就0，有就1
    @RequestMapping("tocard")
    public String tocard(HttpSession session)throws Exception {
        Staff staff = (Staff)session.getAttribute("staff");
        Date now=new Date();
        DateFormat date1=new SimpleDateFormat("yyyy-MM-dd");
        String T_DATE=date1.format(now);
        Attendance attendance = attendanceService.selectAttendancebydateandsid(T_DATE, staff.getT_ID());
        if(attendance==null){
            session.setAttribute("isconfirm",0);//没打卡记录
        }else if(attendance.getT_ENDTIME()==null){
            session.setAttribute("isconfirm",1);//没打下班卡
        }else if(attendance.getT_ENDTIME()!=null){
            session.setAttribute("isconfirm",2);//已打下班卡
            session.setAttribute("showattendance",attendance);
        }
        return "cardview";

    }



    @RequestMapping("checkAttendance")
    @ResponseBody
    public Integer checkAttendance( String but,HttpSession session,HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Integer i=-1;
        if(but.equals("上班打卡")){
           i= 1;
        }else if(but.equals("下班打卡")){
            i=2;
        }
        return i;
    }

    @RequestMapping("confirmAttendance")
    @ResponseBody
    public String selectpositbydid(String time, HttpSession session, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff = (Staff)session.getAttribute("staff");
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timec = date.parse(time);//打卡完整时间
        DateFormat date1=new SimpleDateFormat("yyyy-MM-dd");//打卡日期
        int day = timec.getDay();//双休日算加班
        String T_DATE=date1.format(timec);
        String start=T_DATE+" 09:00:00";
        String end=T_DATE+" 18:00:00";
        Date stime = date.parse(start);//当日上班时间
        Date etime = date.parse(end);//当日下班时间
        Attendance attendance1 = attendanceService.selectAttendancebydateandsid(T_DATE, staff.getT_ID());
        if(attendance1==null){
            Integer error=0;
            if(day==0|day==1){
                error=4;//加班

            }else {
                long before = (timec.getTime() - stime.getTime()) / (3600000);//比较上班打卡时间
                if(before<=0){
                    error=0;
                }else if(before>0&&before<=2){
                    error=1;//迟到
                    rewardandpunishService.insertRewardandpunish(new Rewardandpunish(T_DATE,"迟到", (double) (before*-50),staff.getT_ID()));//生成迟到奖惩
                }else if(before>2){
                    error=3;//早上旷工
                    rewardandpunishService.insertRewardandpunish(new Rewardandpunish(T_DATE,"旷工", (double)(-300),staff.getT_ID()));

                }
            }

            Attendance attendance = new Attendance(T_DATE,time,staff.getT_ID(),error);
            if(attendanceService.insertAttendance(attendance)){
                return time;
            }else {
                return null;
            }
        }else {
            long late=(etime.getTime()-timec.getTime()) / (3600000);//比较下班打卡时间
            //long before = (timec.getTime() - stime.getTime()) / (3600000);//比较上班打卡时间
            Integer error=attendance1.getT_ERROR();
            if(error==0){
                if(late<=0){
                    error=0;//一天正常

                }else if(late>0&&late<=2){
                    error=2;
                    rewardandpunishService.insertRewardandpunish(new Rewardandpunish(T_DATE,"早退", (double) (late*-50),staff.getT_ID()));//生成迟到奖惩
                }else if(late>2){
                    error=3;
                    rewardandpunishService.insertRewardandpunish(new Rewardandpunish(T_DATE,"旷工", (double)(-300),staff.getT_ID()));
                }
            }else if(error==1){//早上迟到
                if(late>2){  //晚上旷工
                    error=3;
                    Rewardandpunish rap = rewardandpunishService.selectRewardandpunishbysidanddateandresaon(staff.getT_ID(), T_DATE, "迟到");
                    rap.setT_REASON("旷工");
                    rap.setT_MONEY((double) -300);
                    rewardandpunishService.updateRewardandpunish(rap);
                }else if(late<=0){
                    //早上迟到，晚上准点。不做操作
                }else if(late>0&&late<=2){
                    //迟到早退
                    error=5;
                    rewardandpunishService.insertRewardandpunish(new Rewardandpunish(T_DATE,"早退", (double) (late*-50),staff.getT_ID()));//生成迟到奖惩

                }


            }else if(error==4){
                long addtime = (etime.getTime() - stime.getTime()) / 3600000;
                rewardandpunishService.insertRewardandpunish(new Rewardandpunish(T_DATE,"加班", (double) (addtime*50),staff.getT_ID()));//加班费
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



    @RequestMapping("toshowattendance")
    public String toshowattendance(HttpServletRequest request, HttpSession session, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        return "showattendance";
    }




    @RequestMapping("selectattendance")
    public String selectattendance(String yeart,Integer montht,HttpServletRequest request, HttpSession session, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        String m=null;
         if(montht>9){
              m= String.valueOf(montht);
         }else {
             m="0"+montht;
         }
        String time=yeart+"-"+m;
        Staff staff =(Staff)session.getAttribute("staff");
        List<Attendance> attendances = attendanceService.selectAttendancebymonthandsid(time, staff.getT_ID());
        request.setAttribute("staffattendance",attendances);

        return "showattendance";
    }

    @RequestMapping("toashowattendance")
    public String toashowattendance(HttpServletRequest request, HttpSession session, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        List<Department> departments = departmentService.selectAllDepartment();
        session.setAttribute("chdepartment",departments);
        return "ashowattendance";
    }


    @RequestMapping("aselectattendance")
    public String aselectattendance(Integer T_DEPARTMENT,Integer T_POSITION,Integer T_STAFF,String yeart,Integer montht,HttpServletRequest req,HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        String m=null;
        if(montht>9){
            m= String.valueOf(montht);
        }else {
            m="0"+montht;
        }
        String time=yeart+"-"+m;
        if(T_STAFF!=null){
            List<Attendance> attendances = attendanceService.selectAttendancebymonthandsid(time, T_STAFF);
            req.setAttribute("staffattendance",attendances);
            return "forward:toashowattendance";
        }else if (T_POSITION!=null&&T_STAFF==null){
            List<Staff> staffs = staffService.selectStaffbyposition(T_POSITION);

        }else if(T_DEPARTMENT!=null&&T_POSITION==null){

        }else if (T_DEPARTMENT==null){

        }
    }
}
