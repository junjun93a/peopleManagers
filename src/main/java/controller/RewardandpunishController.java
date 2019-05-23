package controller;

import model.Attendance;
import model.Rewardandpunish;
import model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AttendanceService;
import service.RewardandpunishService;
import utils.Getworktimelist;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class RewardandpunishController {

    @Resource
    private RewardandpunishService rewardandpunishService;

    @Resource
    private AttendanceService attendanceService;

    @RequestMapping("toshowrap")
    public String toshowrap(HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff = (Staff)session.getAttribute("staff");
        Date now=new Date();
        DateFormat month=new SimpleDateFormat("yyyy-MM");
        DateFormat day=new SimpleDateFormat("yyyy-MM-dd");
        String mt = month.format(now);
        String dt=day.format(now);
        List<Attendance> attendances = attendanceService.selectAttendancebymonthandsid(mt, staff.getT_ID());//查本月所有打卡记录
        for (Attendance attendance : attendances) {
            if(attendance.getT_ENDTIME()==null&&!attendance.getT_DATE().equals(dt)){//不是今天的下班未打卡记旷工
                String t_date = attendance.getT_DATE();
                Integer t_idstaff = attendance.getT_IDSTAFF();
                rewardandpunishService.insertRewardandpunish(new Rewardandpunish(t_date,"旷工", (double) -300,t_idstaff));
            }
        }
        List<String> gettlist = Getworktimelist.gettlist();
        for (String s : gettlist) {
            boolean isok=false;
            for (Attendance attendance : attendances) {
                if(s.equals(attendance.getT_DATE())){
                    isok=true;
                    break;
                }
            }
            if(isok==false){
                rewardandpunishService.insertRewardandpunish(new Rewardandpunish(s,"旷工", (double) -300,staff.getT_ID()));//全天未打卡
            }
        }
        return "srandp";
    }


    @RequestMapping("srewardandpunish")
    public String srewardandpunish(String yeart,Integer montht,HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        String m = null;
        if (montht > 9) {
            m = String.valueOf(montht);
        } else {
            m = "0" + montht;
        }
        String time = yeart + "-" + m;
        Staff staff = (Staff) session.getAttribute("staff");
        List<Rewardandpunish> rewardandpunishes = rewardandpunishService.selectRewardandpunishbysidanddate(staff.getT_ID(), time);
        request.setAttribute("staffrap",rewardandpunishes);
        return "srandp";
    }
}
