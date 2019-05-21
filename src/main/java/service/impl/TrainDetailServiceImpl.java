package service.impl;

import dao.TrainDetailDao;
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
    public TrainDetail selectTraindetailById(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return trainDetailDao.selectTraindetailById(id);
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
