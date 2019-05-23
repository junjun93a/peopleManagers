package service;

import model.Staff;
import model.TrainDetail;

import java.util.List;

public interface TrainDetailService {
    boolean insertTraindetail(TrainDetail traindetail);
    boolean insertTraindetailbypositions(List<Staff> staffs,Integer tid);
    boolean updateTraindetail(TrainDetail traindetail);
    boolean deleteTraindetail(Integer id);
    boolean deleteTraindetailbystaff(Integer sid);
    TrainDetail selectTraindetailById(Integer id);
    TrainDetail selectTraindetailBytidandsid(Integer tid,Integer sid);
    List<TrainDetail> selectTraindetailbystaff(Integer sid);
    List<TrainDetail> selectTraindetailbyTraining(Integer tid);
}
