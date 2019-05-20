package controller;

import model.Department;
import model.Position;
import model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import service.DepartmentService;
import service.PositionService;
import service.StaffService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class DepartAndPositController {

    @Resource
    private DepartmentService departmentService;

    @Resource
    private PositionService positionService;
    @Resource
    private StaffService staffService;

    @RequestMapping("todepartposit")
    public String todepartposit( HttpServletRequest request, HttpSession session, HttpServletResponse resp) {
        resp.setContentType("text/html;charset=UTF-8");
        List<Department> departments = departmentService.selectAllDepartment();
        session.setAttribute("departments",departments);
        List<Position> positions = positionService.selectAllPosition();
        session.setAttribute("positions",positions);
        return "departposit";
    }

    @RequestMapping("selectpositbydid")
    @ResponseBody
    public List<Position> selectpositbydid(Integer did){
        return  positionService.selectPositionbydid(did);
    }


    @RequestMapping("adddepartment")
    public void adddepartment(String T_NAME, HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Department department1 = departmentService.selectDepartmentbyname(T_NAME);
        if(department1!=null){
            resp.getWriter().write("<script>alert(\"部门已存在\");window.location.href='todepartposit';</script>");
        }else {
            Date date=new Date();
            Department department = new Department(T_NAME, date);
            if(departmentService.insertDepartment(department)){
                resp.getWriter().write("<script>alert(\"新增成功\");window.location.href='todepartposit';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"新增失败\");window.location.href='todepartposit';</script>");
            }
        }
    }



    @RequestMapping("updatedepartment")
    public void updatedepartment(String T_NAME, Integer did,HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Department department1 = departmentService.selectDepartmentbyname(T_NAME);
        if(department1!=null){
            resp.getWriter().write("<script>alert(\"部门已存在\");window.location.href='todepartposit';</script>");
        }else {
            Department department = departmentService.selectDepartmentbyid(did);
            department.setT_NAME(T_NAME);
            if(departmentService.updateDepartment(department)){
                resp.getWriter().write("<script>alert(\"修改成功\");window.location.href='todepartposit';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"修改失败\");window.location.href='todepartposit';</script>");
            }
        }
    }


    @RequestMapping("addposition")
    public void addposition(String T_NAME,Integer did, HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Position position = positionService.selectPositionbynameanddid(did, T_NAME);
        if(position!=null){
            resp.getWriter().write("<script>alert(\"该部门此职位已存在\");window.location.href='todepartposit';</script>");
        }else {
            if(positionService.insertPosition(new Position(T_NAME,did))){
                resp.getWriter().write("<script>alert(\"新增成功\");window.location.href='todepartposit';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"新增失败\");window.location.href='todepartposit';</script>");
            }
        }
    }



    @RequestMapping("updateposition")
    public void updateposition(String T_NAME,Integer pid,Integer did, HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Position position1 = positionService.selectPositionbynameanddid(did, T_NAME);
        if(position1!=null){
            resp.getWriter().write("<script>alert(\"该部门此职位已存在\");window.location.href='todepartposit';</script>");
        }else {
            Position position = positionService.selectPositionbyid(pid);
            position.setT_NAME(T_NAME);
            if(positionService.updatePosition(position)){
                resp.getWriter().write("<script>alert(\"修改成功\");window.location.href='todepartposit';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"修改失败\");window.location.href='todepartposit';</script>");
            }
        }
    }



    @RequestMapping("deletedepartment")
    public void deletedepartment(Integer did, HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        List<Staff> staff = staffService.selectStaffbydepartmentid(did);
        if(staff!=null||staff.size()!=0){
            resp.getWriter().write("<script>alert(\"在职员工存在，无法删除\");window.location.href='todepartposit';</script>");
        }else {
            if(departmentService.deleteDepartment(did)){
                resp.getWriter().write("<script>alert(\"删除成功\");window.location.href='todepartposit';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"删除失败\");window.location.href='todepartposit';</script>");
            }
        }
    }


    @RequestMapping("deleteposition")
    public void deleteposition(Integer pid, HttpServletResponse resp) throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        List<Staff> staff = staffService.selectStaffbyposition(pid);
        if(staff!=null||staff.size()!=0){
            resp.getWriter().write("<script>alert(\"在职员工存在，无法删除\");window.location.href='todepartposit';</script>");
        }else {
            if(positionService.deletePosition(pid)){
                resp.getWriter().write("<script>alert(\"删除成功\");window.location.href='todepartposit';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"删除失败\");window.location.href='todepartposit';</script>");
            }
        }
    }

}
