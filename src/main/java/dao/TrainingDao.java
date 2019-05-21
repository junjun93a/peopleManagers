package dao;

import model.Training;

import java.util.List;

public interface TrainingDao {
    Integer insertTraining(Training training);
    Integer updateTraining(Training training);
    Integer deleteTraining(Integer id);
    List<Training> selectAllLaunchTraining();
    List<Training> selectAllTraining();
    Training selectTrainingById(Integer id);

}
