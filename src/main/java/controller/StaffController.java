package controller;

import model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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



    @RequestMapping("toshowstaff")
    public String toshowstaff(Integer pid,HttpServletRequest request, HttpSession session, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        List<Staff> staff = staffService.selectStaffbyposition(pid);
        session.setAttribute("pstaff",staff);
        return "showstaff";

    }
}
