package dao;

import model.Rewardandpunish;

import java.util.List;

public interface RewardandpunishDao {
    Integer insertRewardandpunish  (Rewardandpunish rewardandpunish);
    Integer updateRewardandpunish(Rewardandpunish rewardandpunish);
    Integer deleteRewardandpunish(Integer T_ID);
    List<Rewardandpunish> selectRewardandpunishbysid(Integer sid);//按员工查
    Rewardandpunish selectRewardandpunishbyid(Integer id);//按id查
    Rewardandpunish selectRewardandpunishbysidanddateandresaon(Integer sid,String date,String reason);//查考勤
    List<Rewardandpunish> selectRewardandpunishbysidanddate(Integer sid,String date);

}
