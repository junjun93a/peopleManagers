package service.impl;

import dao.PositionDao;
import model.Position;
import org.springframework.stereotype.Service;
import service.PositionService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {


    @Resource
    private PositionDao positionDao;

    @Override
    public boolean insertPosition(Position position) {
        if (position==null){
            return false;
        }
        Integer i = positionDao.insertPosition(position);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updatePosition(Position position) {
        if (position==null){
            return false;
        }
        Integer i = positionDao.updatePosition(position);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deletePosition(Integer T_ID) {
        if (T_ID==null||T_ID==0){
            return false;
        }
        Integer i = positionDao.deletePosition(T_ID);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deletePositionbydid(Integer did) {
        if (did==null||did==0){
            return false;
        }
        Integer i = positionDao.deletePositionbydid(did);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Position selectPositionbyid(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return positionDao.selectPositionbyid(id);
    }

    @Override
    public List<Position> selectAllPosition() {
        return positionDao.selectAllPosition();
    }

    @Override
    public List<Position> selectPositionbydid(Integer did) {
        if (did==null||did==0){
            return null;
        }
        return positionDao.selectPositionbydid(did);
    }

    @Override
    public Position selectPositionbynameanddid(Integer did, String name) {
        if (did==null||did==0||name==null){
            return null;
        }
        return positionDao.selectPositionbynameanddid(did,name);
    }
}
