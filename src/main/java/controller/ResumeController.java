package controller;

import model.Resume;
import model.Visitor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.ResumeService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class ResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping("toresumeview")
    public String toresumeview(HttpSession session)throws Exception{
        Visitor visitor =(Visitor) session.getAttribute("visitor");
        List<Resume> resumes = resumeService.selectResumebyvid(visitor.getT_ID());
        session.setAttribute("resume",resumes);
        return "resumeview";
    }

    @RequestMapping("updateresume")
    public void updateresume(Resume resume,HttpServletRequest req, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        if(resumeService.updateResume(resume)){
            resp.getWriter().write("<script>alert(\"修改成功\");window.location.href='toresumeview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"修改失败\");window.location.href='toresumeview';</script>");
        }
    }



    @RequestMapping("toaddresume")
    public String toaddresume()throws Exception{
        return "addresume";
    }

    @RequestMapping("addoneresume")
    public void addresume(Resume resume, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        if(resumeService.insertResume(resume)){
            resp.getWriter().write("<script>alert(\"添加成功\");window.location.href='toresumeview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"添加失败\");window.location.href='toresumeview';</script>");
        }
    }

    @RequestMapping("deleteresume")
    public void deleteresume(Integer id, HttpServletResponse resp)throws Exception{
        resp.setContentType("text/html;charset=UTF-8");
        if(resumeService.deleteResume(id)){
            resp.getWriter().write("<script>alert(\"删除成功\");window.location.href='toresumeview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"删除失败\");window.location.href='toresumeview';</script>");
        }
    }
}
