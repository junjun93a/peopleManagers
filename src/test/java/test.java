import dao.AttendanceDao;
import dao.StaffDao;
import model.Staff;
import model.Visitor;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.VisitorService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

}
