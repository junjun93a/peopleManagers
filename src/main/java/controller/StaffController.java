package controller;

import model.Department;
import model.Position;
import model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepartmentService;
import service.StaffService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class StaffController {
    @Resource
    private StaffService staffService;
    @Resource
    private DepartmentService departmentService;


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

        return  staffService.selectStaffbyposition(pid);
    }

}
