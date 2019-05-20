package controller;

import model.Department;
import model.Position;
import model.Recruit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DepartmentService;
import service.PositionService;
import service.RecruitService;
import utils.CurrentPage;
import utils.GetTotalPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecruitController {

    @Resource
    private RecruitService recruitService;
    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;

    @RequestMapping("tovrecruit")
    public String tovsuccess(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletRequest request, HttpSession session, HttpServletResponse resp){
        resp.setContentType("text/html;charset=UTF-8");
        List<Recruit> recruits = recruitService.selectAllLaunchRecruit();
        int cp = 0;
        int pageSize=5;//每页尺寸
        if (currentPage!=null){
            cp = currentPage;
        }else {
            cp=1;
        }
        List<Recruit> currentrecruits=null;
        int totalPage=1;
        if(recruits!=null){
            int totalRows = recruits.size();
            totalPage = GetTotalPage.getTp(totalRows,pageSize);
            currentrecruits=new ArrayList<>(recruits);
            List<List<Recruit>> list = CurrentPage.split(Recruit.class, currentrecruits, pageSize);
            List<Recruit> recruitList = CurrentPage.getSplit(Recruit.class, list, cp);
            session.setAttribute("recruitlist",recruitList);
            session.setAttribute("tp",totalPage);

            return "vrecruit";
        }else {
            session.setAttribute("recruitlist",null);
            session.setAttribute("tp",totalPage);
            return "vrecruit";
        }
    }

    @RequestMapping("toarecruit")
    public String toarecruit(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletRequest request, HttpSession session, HttpServletResponse resp){
        resp.setContentType("text/html;charset=UTF-8");
        List<Recruit> recruits = recruitService.selectAllhRecruit();
        int cp = 0;
        int pageSize=5;//每页尺寸
        if (currentPage!=null){
            cp = currentPage;
        }else {
            cp=1;
        }
        List<Recruit> currentrecruits=null;
        int totalPage=1;
        if(recruits!=null){
            int totalRows = recruits.size();
            totalPage = GetTotalPage.getTp(totalRows,pageSize);
            currentrecruits=new ArrayList<>(recruits);
            List<List<Recruit>> list = CurrentPage.split(Recruit.class, currentrecruits, pageSize);
            List<Recruit> recruitList = CurrentPage.getSplit(Recruit.class, list, cp);
            session.setAttribute("arecruitlist",recruitList);
            session.setAttribute("atp",totalPage);

            return "arecruit";
        }else {
            session.setAttribute("arecruitlist",null);
            session.setAttribute("atp",totalPage);
            return "arecruit";
        }
    }


    @RequestMapping("toaddrecruit")
    public String toaddresume( HttpSession session, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        List<Department> departments = departmentService.selectAllDepartment();
        session.setAttribute("rdepartments",departments);
//        List<Position> positions = positionService.selectAllPosition();
//        session.setAttribute("rpositions",positions);
        return "addrecruit";
    }


    @RequestMapping("addonerecruit")
    public void addresume(Recruit recruit, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        recruit.setT_LAUNCH(0);
        if(recruitService.insertRecruit(recruit)){
            resp.getWriter().write("<script>alert(\"添加成功\");window.location.href='toarecruit';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"添加失败\");window.location.href='toarecruit';</script>");
        }
    }

    @RequestMapping("deleterecruit")
    public void deleterecruit(Integer rid, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
         if(recruitService.deleteRecruit(rid)){
             resp.getWriter().write("<script>alert(\"删除成功\");window.location.href='toarecruit';</script>");
         }else {
             resp.getWriter().write("<script>alert(\"删除失败\");window.location.href='toarecruit';</script>");
         }
    }



    @RequestMapping("toupdaterecruit")
    public String toupdaterecruit(Integer rid, HttpServletResponse resp,HttpSession session)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        Recruit recruit = recruitService.selectRecruitById(rid);
        session.setAttribute("uprecruit",recruit);
        List<Department> departments = departmentService.selectAllDepartment();
        session.setAttribute("uprdepartments",departments);
        return "updaterecruit";
    }
    @RequestMapping("updaterecruit")
    public void updaterecruit(Recruit recruit, HttpServletResponse resp,HttpSession session)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        if(recruitService.updateRecruit(recruit)){
            resp.getWriter().write("<script>alert(\"修改成功\");window.location.href='toarecruit';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"修改失败\");window.location.href='toarecruit';</script>");
        }
    }


    @RequestMapping("changelaunch")
    public void changelaunch(Integer rid, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
      if(recruitService.changelaunch(rid)){
          resp.getWriter().write("<script>alert(\"发布成功\");window.location.href='toarecruit';</script>");
      }else {
          resp.getWriter().write("<script>alert(\"发布失败\");window.location.href='toarecruit';</script>");
      }
    }
}
