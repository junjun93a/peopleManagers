package service.impl;

import dao.TrainDetailDao;
import model.Staff;
import model.TrainDetail;
import model.Training;
import org.springframework.stereotype.Service;
import service.TrainDetailService;
import service.TrainingService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainDetailServiceImpl implements TrainDetailService {

    @Resource
    private TrainDetailDao trainDetailDao;


    @Override
    public boolean insertTraindetail(TrainDetail traindetail) {
        if (traindetail==null){
            return false;
        }
        Integer i = trainDetailDao.insertTraindetail(traindetail);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean insertTraindetailbypositions(List<Staff> staffs,Integer tid) {
        if(staffs!=null&&staffs.size()!=0){
            return false;
        }
        Integer i =0;
        for (Staff staff : staffs) {
            TrainDetail trainDetail = trainDetailDao.selectTraindetailBytidandsid(tid, staff.getT_ID());
            if(trainDetail==null){
                i = trainDetailDao.insertTraindetail(new TrainDetail(staff.getT_ID(),tid));
            }

        }
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateTraindetail(TrainDetail traindetail) {
        if (traindetail==null){
            return false;
        }
        Integer i = trainDetailDao.updateTraindetail(traindetail);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteTraindetail(Integer id) {
        if (id==null||id==0){
            return false;
        }
        Integer i = trainDetailDao.deleteTraindetail(id);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteTraindetailbystaff(Integer sid) {
        if (sid==null||sid==0){
            return false;
        }
        Integer i = trainDetailDao.deleteTraindetailbystaff(sid);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public TrainDetail selectTraindetailById(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return trainDetailDao.selectTraindetailById(id);
    }

    @Override
    public TrainDetail selectTraindetailBytidandsid(Integer tid, Integer sid) {
        if (tid==null||tid==0||sid==null||sid==0){
            return null;
        }
        return trainDetailDao.selectTraindetailBytidandsid(tid,sid);
    }

    @Override
    public List<TrainDetail> selectTraindetailbystaff(Integer sid) {
        if (sid==null||sid==0){
            return null;
        }
        return trainDetailDao.selectTraindetailbystaff(sid);
    }

    @Override
    public List<TrainDetail> selectTraindetailbyTraining(Integer tid) {
        if (tid==null||tid==0){
            return null;
        }
        return trainDetailDao.selectTraindetailbystaff(tid);
    }
}
