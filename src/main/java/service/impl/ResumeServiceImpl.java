package service.impl;

import dao.ResumeDao;
import model.Resume;
import org.springframework.stereotype.Service;
import service.ResumeService;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ResumeServiceImpl implements ResumeService {

    @Resource
    private ResumeDao resumeDao;
    @Override
    public boolean insertResume(Resume resume) {
        if (resume==null){
            return false;
        }
        Integer i = resumeDao.insertResume(resume);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateResume(Resume resume) {
        if (resume==null){
            return false;
        }
        Integer i = resumeDao.updateResume(resume);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteResume(Integer T_ID) {
        if (T_ID==null||T_ID==0){
            return false;
        }

        Integer i = resumeDao.deleteResume(T_ID);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Resume> selectResumebyvid(Integer vid) {
        if (vid==null||vid==0){
            return null;
        }
        return resumeDao.selectResumebyvid(vid);
    }

    @Override
    public Resume selectResumebyid(Integer id) {

        if (id==null||id==0){
            return null;
        }
        return resumeDao.selectResumebyid(id);
    }
}
