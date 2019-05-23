import dao.AttendanceDao;
import dao.StaffDao;
import model.Attendance;
import model.Staff;
import model.Visitor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.VisitorService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class test {

    public static void main(String[] args) {
        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
        Date currentTime = new Date();
        String format1 = format.format(currentTime);
        System.out.println(format1);
    }

    @Test
    public void test1(){
        ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        StaffDao staffDao= (StaffDao) context.getBean("staffDao");
        List<Staff> staff = staffDao.selectStaffbydepartmentid(1);
        System.out.println(staff);
    }
    @Test
    public void test2(){
       int i= 11111%100;
        System.out.println(i);
    }
    @Test
    public void test3(){
        ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        VisitorService visitorService= (VisitorService) context.getBean("vs");
        Visitor visitor = visitorService.selectvisitorbyid(2);

        System.out.println(visitor);
    }

    @Test
    public void test4(){
        ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        AttendanceDao attendanceDao= (AttendanceDao) context.getBean("attendanceDao");


        System.out.println();
    }

    @Test
    public void test5()throws Exception{
       String time="2019-5-22 19:30:00";
        DateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timec = date.parse(time);

        DateFormat date1=new SimpleDateFormat("yyyy-MM-dd");
        String format = date1.format(timec);
        String starttime=format+" 09:00:00";
        String endtime=format+" 18:00:00";
        Date s = date.parse(starttime);

        System.out.println(s);
    }

    @Test
    public void test6()throws Exception {
        String time = "2019-5-26 19:30:00";
        DateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date timec = date.parse(time);

        int day = timec.getDay();

        Calendar cal = Calendar.getInstance();
        cal.setTime(timec);
        int w = cal.get(Calendar.DAY_OF_WEEK);
        System.out.println(day);

    }
    @Test
    public void test7()throws Exception {
        Date date=new Date();
        DateFormat format = new SimpleDateFormat("yyyy");
        String format1 = format.format(date);
        Integer year= Integer.valueOf(format1);

        for (int i=2000;i<=year;i++){
            System.out.println(i);
        }
    }

    @Test
    public void test8()throws Exception {
        String yeart="2019";
        Integer montht=4;
        String m=null;
        if(montht>9){
            m= String.valueOf(montht);
        }else {
            m="0"+montht;
        }
        String time=yeart+"-"+m;
        System.out.println(time);
        ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        AttendanceDao attendanceDao= (AttendanceDao) context.getBean("attendanceDao");
        List<Attendance> attendance = attendanceDao.selectAttendancebymonthandsid(time, 3);
        System.out.println(attendance);

    }

    @Test
    public void test9()throws Exception {
        String yeart="2019";
        Integer montht=5;
        String m=null;
        if(montht>9){
            m= String.valueOf(montht);
        }else {
            m="0"+montht;
        }
        String time=yeart+"-"+m;
        System.out.println(time);
        ApplicationContext context= new ClassPathXmlApplicationContext("bean.xml");
        AttendanceDao attendanceDao= (AttendanceDao) context.getBean("attendanceDao");
        List<Integer> sid=new ArrayList<>();
        sid.add(2);
        sid.add(3);
        sid.add(1);

        List<Attendance> attendance = attendanceDao.selectAttendancebymonthandmanysid(time, sid);
        System.out.println(attendance.size());

    }


}
