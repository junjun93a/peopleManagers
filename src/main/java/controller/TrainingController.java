package controller;

import model.Department;
import model.Staff;
import model.TrainDetail;
import model.Training;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.DepartmentService;
import service.RecruitService;
import service.TrainDetailService;
import service.TrainingService;
import utils.CurrentPage;
import utils.GetTotalPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TrainingController {
    @Resource
    private TrainDetailService trainDetailService;
    @Resource
    private TrainingService trainingService;
    @Resource
    private DepartmentService departmentService;

    @RequestMapping("totrainingview")
    public String totrainingview(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Staff staff =(Staff)session.getAttribute("staff");
        List<TrainDetail> trainDetails = trainDetailService.selectTraindetailbystaff(staff.getT_ID());
        List<Training> trainings=new ArrayList<>();
        for (TrainDetail trainDetail : trainDetails) {
            Training training = trainingService.selectTrainingById(trainDetail.getT_IDTRAINING());
            trainings.add(training);
        }
        int cp = 0;
        int pageSize=5;//每页尺寸
        if (currentPage!=null){
            cp = currentPage;
        }else {
            cp=1;
        }
        List<Training> currenttrains=null;
        int totalPage=1;
        if(trainings!=null){
            int totalRows = trainings.size();
            totalPage = GetTotalPage.getTp(totalRows,pageSize);
            currenttrains=new ArrayList<>(trainings);
            List<List<Training>> list = CurrentPage.split(Training.class, currenttrains, pageSize);
            List<Training> trainingList = CurrentPage.getSplit(Training.class, list, cp);
            session.setAttribute("strainings",trainingList);
            session.setAttribute("sttp",totalPage);
            return "strainingview";
        }else {
            session.setAttribute("strainings",null);
            session.setAttribute("sttp",totalPage);
            return "strainingview";
        }
    }


    @RequestMapping("toatrainingview")
    public String toatrainingview(@RequestParam(name = "currentPage",required = false)Integer currentPage, HttpServletRequest request, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        List<Training> trainings = trainingService.selectAllTraining();
        int cp = 0;
        int pageSize=5;//每页尺寸
        if (currentPage!=null){
            cp = currentPage;
        }else {
            cp=1;
        }
        List<Training> currenttrains=null;
        int totalPage=1;
        if(trainings!=null){
            int totalRows = trainings.size();
            totalPage = GetTotalPage.getTp(totalRows,pageSize);
            currenttrains=new ArrayList<>(trainings);
            List<List<Training>> list = CurrentPage.split(Training.class, currenttrains, pageSize);
            List<Training> trainingList = CurrentPage.getSplit(Training.class, list, cp);
            session.setAttribute("atrainings",trainingList);
            session.setAttribute("attp",totalPage);
            return "atrainingview";
        }else {
            session.setAttribute("atrainings",null);
            session.setAttribute("attp",totalPage);
            return "atrainingview";
        }
    }



    @RequestMapping("addatrain")
    public void addatrain(Training training,  HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        training.setT_LAUNCH(0);
        if(trainingService.insertTraining(training)){
            resp.getWriter().write("<script>alert(\"添加成功\");window.location.href='toatrainingview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"添加失败\");window.location.href='toatrainingview';</script>");
        }
    }

    @RequestMapping("tochoicepeople")
    public void tochoicepeople(HttpServletRequest req,HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        List<Department> departments = departmentService.selectAllDepartment();
        session.setAttribute("chdepartment",departments);
        req.getRequestDispatcher("/WEB-INF/page/choicepeople.jsp").forward(req,resp);
    }



    @RequestMapping("trainlaunch")
    public void trainlaunch(Integer tid, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        Training training = trainingService.selectTrainingById(tid);
        training.setT_LAUNCH(1);
        List<TrainDetail> trainDetails = trainDetailService.selectTraindetailbyTraining(tid);
        if(trainDetails==null||trainDetails.size()==0){
            resp.getWriter().write("<script>alert(\"无参加培训人员，请添加\");window.location.href='toatrainingview';</script>");
        }else {
            if(trainingService.updateTraining(training)){
                resp.getWriter().write("<script>alert(\"发布成功\");window.location.href='toatrainingview';</script>");
            }else {
                resp.getWriter().write("<script>alert(\"发布失败\");window.location.href='toatrainingview';</script>");
            }
        }

    }


    @RequestMapping("deletetrain")
    public void deletetrain(Integer tid, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        if(trainingService.deleteTraining(tid)){
            resp.getWriter().write("<script>alert(\"删除成功\");window.location.href='toatrainingview';</script>");
        }else {
            resp.getWriter().write("<script>alert(\"删除失败\");window.location.href='toatrainingview';</script>");
        }
    }


    @RequestMapping("updatetrain")
    public void updatetrain(Training training, HttpSession session, HttpServletResponse resp)throws Exception {
        resp.setContentType("text/html;charset=UTF-8");
        if(trainingService.updateTraining(training)){
            resp.getWriter().write("<script>alert(\"修改成功\");window.location.href='toatrainingview';</script>");
        }else{
            resp.getWriter().write("<script>alert(\"修改失败\");window.location.href='toatrainingview';</script>");
        }
    }
}
