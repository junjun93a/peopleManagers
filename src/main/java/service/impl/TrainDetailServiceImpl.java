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
        return null;
    }

    @Override
    public boolean updateTraindetail(TrainDetail traindetail) {
        return null;
    }

    @Override
    public boolean deleteTraindetail(Integer id) {
        return null;
    }

    @Override
    public TrainDetail selectTraindetailById(Integer id) {
        return null;
    }

    @Override
    public List<TrainDetail> selectTraindetailbystaff(Integer sid) {
        return null;
    }

    @Override
    public List<TrainDetail> selectTraindetailbyTraining(Integer tid) {
        return null;
    }
}
