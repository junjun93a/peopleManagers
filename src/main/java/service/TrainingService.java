package service;

import model.Training;

import java.util.List;

public interface TrainingService {
    boolean insertTraining(Training training);
    boolean updateTraining(Training training);
    boolean deleteTraining(Integer id);
    List<Training> selectAllLaunchTraining();
    List<Training> selectAllTraining();
    Training selectTrainingById(Integer id);
}
