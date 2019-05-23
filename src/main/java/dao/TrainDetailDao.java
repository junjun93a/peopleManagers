package dao;

import model.TrainDetail;

import java.util.List;

public interface TrainDetailDao {
    Integer insertTraindetail(TrainDetail traindetail);
    Integer updateTraindetail(TrainDetail traindetail);
    Integer deleteTraindetail(Integer id);
    Integer deleteTraindetailbystaff(Integer sid);
    TrainDetail selectTraindetailById(Integer id);
    TrainDetail selectTraindetailBytidandsid(Integer tid,Integer sid);
    List<TrainDetail> selectTraindetailbystaff(Integer sid);
    List<TrainDetail> selectTraindetailbyTraining(Integer tid);
}
