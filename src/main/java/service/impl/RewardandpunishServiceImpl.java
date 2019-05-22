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

        return false;
    }

    @Override
    public boolean updateRewardandpunish(Rewardandpunish resume) {
        return false;
    }

    @Override
    public boolean deleteRewardandpunish(Integer T_ID) {
        return false;
    }

    @Override
    public List<Rewardandpunish> selectRewardandpunishbysid(Integer sid) {
        return null;
    }

    @Override
    public Rewardandpunish selectRewardandpunishbyid(Integer id) {
        return null;
    }

    @Override
    public List<Rewardandpunish> selectRewardandpunishbysidanddate(Integer sid, String date) {
        return null;
    }
}
