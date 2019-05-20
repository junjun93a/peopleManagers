package dao;

import model.Recruit;

import java.util.List;

public interface RecruitDao {
    Integer insertRecruit(Recruit recruit);
    Integer updateRecruit(Recruit recruit);
    Integer updateRecruitDate(Recruit recruit);
    Integer deleteRecruit(Integer id);
    List<Recruit> selectAllLaunchRecruit();
    List<Recruit> selectAllhRecruit();
    Recruit selectRecruitById(Integer id);



}
