package service;

import model.TrainDetail;

import java.util.List;

public interface TrainDetailService {
    boolean insertTraindetail(TrainDetail traindetail);
    boolean updateTraindetail(TrainDetail traindetail);
    boolean deleteTraindetail(Integer id);
    TrainDetail selectTraindetailById(Integer id);
    List<TrainDetail> selectTraindetailbystaff(Integer sid);
    List<TrainDetail> selectTraindetailbyTraining(Integer tid);
}
