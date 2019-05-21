package service.impl;

import dao.TrainingDao;
import model.Training;
import org.springframework.stereotype.Service;
import service.TrainingService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TrainingServiceImpl implements TrainingService {

    @Resource
    private TrainingDao trainingDao;
    @Override
    public boolean insertTraining(Training training) {
        if (training==null){
            return false;
        }
        Integer i = trainingDao.insertTraining(training);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateTraining(Training training) {
        if (training==null){
            return false;
        }
        Integer i = trainingDao.updateTraining(training);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteTraining(Integer id) {
        if (id==null||id==0){
            return false;
        }
        Integer i = trainingDao.deleteTraining(id);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Training> selectAllLaunchTraining() {
        return trainingDao.selectAllLaunchTraining();
    }

    @Override
    public List<Training> selectAllTraining() {
        return trainingDao.selectAllTraining();
    }

    @Override
    public Training selectTrainingById(Integer id) {
        return trainingDao.selectTrainingById(id);
    }
}
