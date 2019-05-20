package controller;

import model.Recruit;
import model.Resume;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.AdminService;
import service.RecruitService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Controller
public class AdminController {

    @Resource
    private AdminService adminService;


    @RequestMapping("toadmin")
    public String toadmin()throws Exception{
        return "adminview";
    }

}
