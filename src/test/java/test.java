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
}
