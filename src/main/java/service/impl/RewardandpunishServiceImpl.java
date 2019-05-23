package service.impl;

import dao.RewardandpunishDao;
import model.Rewardandpunish;
import org.springframework.stereotype.Service;
import service.RewardandpunishService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RewardandpunishServiceImpl implements RewardandpunishService {

    @Resource
    private RewardandpunishDao rewardandpunishDao;


    @Override
    public boolean insertRewardandpunish(Rewardandpunish rewardandpunish) {
        if (rewardandpunish==null){
            return false;
        }
        Integer i = rewardandpunishDao.insertRewardandpunish(rewardandpunish);

        if(i!=0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public boolean updateRewardandpunish(Rewardandpunish rewardandpunish) {
        if (rewardandpunish==null){
            return false;
        }
        Integer i = rewardandpunishDao.updateRewardandpunish(rewardandpunish);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteRewardandpunish(Integer T_ID) {
        if (T_ID==null||T_ID==0){
            return false;
        }
        Integer i = rewardandpunishDao.deleteRewardandpunish(T_ID);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Rewardandpunish> selectRewardandpunishbysid(Integer sid) {
        if (sid==null||sid==0){
            return null;
        }
        return rewardandpunishDao.selectRewardandpunishbysid(sid);
    }

    @Override
    public Rewardandpunish selectRewardandpunishbyid(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return rewardandpunishDao.selectRewardandpunishbyid(id);
    }

    @Override
    public List<Rewardandpunish> selectRewardandpunishbysidanddate(Integer sid, String date) {

        if (sid==null||sid==0||date!=null){
            return null;
        }
        return rewardandpunishDao.selectRewardandpunishbysidanddate(sid,date);
    }
}
