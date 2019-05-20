package service.impl;

import dao.RecruitDao;
import model.Recruit;
import org.springframework.stereotype.Service;
import service.RecruitService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class RecruitServiceImpl implements RecruitService {
    @Resource
    private RecruitDao recruitDao;

    public boolean insertRecruit(Recruit recruit) {
        if(recruit==null){
            return false;
        }
        Integer i = recruitDao.insertRecruit(recruit);

        if(i!=0){
            return true;
        }else {
            return false;
        }

    }

    public boolean updateRecruit(Recruit recruit) {

        if(recruit==null){
            return false;
        }
        Integer i = recruitDao.updateRecruit(recruit);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateRecruitDate(Recruit recruit) {
        if(recruit==null){
            return false;
        }
        Integer i = recruitDao.updateRecruitDate(recruit);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    public boolean deleteRecruit(Integer id) {
        if (id==null||id==0){
            return false;
        }
        Integer i = recruitDao.deleteRecruit(id);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    public List<Recruit> selectAllLaunchRecruit() {
        return recruitDao.selectAllLaunchRecruit();
    }

    @Override
    public Recruit selectRecruitById(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return recruitDao.selectRecruitById(id);
    }

    @Override
    public List<Recruit> selectAllhRecruit() {
        return recruitDao.selectAllhRecruit();
    }

    @Override
    public boolean changelaunch(Integer rid) {
        Recruit recruit = recruitDao.selectRecruitById(rid);
        Date date=new Date();
        recruit.setT_DATE(date);
        if(0==recruit.getT_LAUNCH()){
            recruit.setT_LAUNCH(1);
        }else {
            recruit.setT_LAUNCH(0);
        }
        Integer i = recruitDao.updateRecruitDate(recruit);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }
}
