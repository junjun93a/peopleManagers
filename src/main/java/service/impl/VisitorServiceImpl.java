package service.impl;

import dao.VisitorDao;
import model.Visitor;
import org.springframework.stereotype.Service;
import service.VisitorService;

import javax.annotation.Resource;

@Service
public class VisitorServiceImpl implements VisitorService {
    @Resource
    private VisitorDao visitorDao;


    public boolean insertvisitor(Visitor visitor) {
        if (visitor==null){
            return false;
        }
        Integer i = visitorDao.insertvisitor(visitor);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updatevisitor(Visitor visitor) {
        if (visitor==null){
            return false;
        }
        Integer i = visitorDao.updatevisitor(visitor);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    public Visitor login(Visitor visitor) {
        if(visitor==null ){
            return null;
        }
        return visitorDao.selectvisitorbyaccountpass(visitor);
    }

    @Override
    public Visitor selectvisitorbyid(Integer id) {
        if(id==null ||id==0){
            return null;
        }
        return visitorDao.selectvisitorbyid(id);
    }

    public boolean selectvisitorbyaccount(Visitor visitor) {
        if(visitor==null ){
            return false;
        }
        Visitor v = visitorDao.selectvisitorbyaccount(visitor);
        if(v==null){
            return true;
        }else {
            return false;
        }
    }
}
