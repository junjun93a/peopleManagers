package dao;

import model.TrainDetail;

import java.util.List;

public interface TrainDetailDao {
    Integer insertTraindetail(TrainDetail traindetail);
    Integer updateTraindetail(TrainDetail traindetail);
    Integer deleteTraindetail(Integer id);
    TrainDetail selectTraindetailById(Integer id);
    List<TrainDetail> selectTraindetailbystaff(Integer sid);
    List<TrainDetail> selectTraindetailbyTraining(Integer tid);
}
