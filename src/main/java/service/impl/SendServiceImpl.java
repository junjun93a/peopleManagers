package service.impl;

import dao.SendDao;
import model.Send;
import org.springframework.stereotype.Service;
import service.SendService;

import javax.annotation.Resource;
import java.util.List;
@Service("sendServiceImpl")
public class SendServiceImpl implements SendService {

    @Resource
    private SendDao sendDao;


    @Override
    public boolean insertSend(Send send) {
        if (send==null){
            return false;
        }
        Integer i = sendDao.insertSend(send);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateSend(Send send) {
        if (send==null){
            return false;
        }
        Integer i = sendDao.updateSend(send);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateSendTime(Send send) {
        if (send==null){
            return false;
        }
        Integer i = sendDao.updateSendTime(send);
        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteSend(Integer T_ID) {
        if (T_ID==null||T_ID==0){
            return false;
        }
        Integer i = sendDao.deleteSend(T_ID);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Send> selectSendbyrid(Integer T_IDRECRUIT) {
        if (T_IDRECRUIT==null||T_IDRECRUIT==0){
            return null;
        }
        return sendDao.selectSendbyrid(T_IDRECRUIT);
    }

    @Override
    public Send selectSendbyid(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return sendDao.selectSendbyid(id);
    }

    @Override
    public List<Send> selectSendbystaff(Integer staff) {
        if (staff==null||staff==0){
            return null;
        }
        return sendDao.selectSendbystaff(staff);
    }

    @Override
    public List<Send> selectSend() {
        return sendDao.selectSendbystaff(null);
    }

    @Override
    public List<Send> selectSendbystaffs(List<Integer> staff) {
        if (staff==null||staff.size()==0){
            return null;
        }
        return sendDao.selectSendbystaffs(staff);
    }

    @Override
    public List<Send> selectSendbyvisitor(Integer vid) {
        if (vid==null||vid==0){
            return null;
        }
        return sendDao.selectSendbyvisitor(vid);
    }

    @Override
    public List<Send> selectSendbystaffvisitor(Integer staff, Integer vid) {
        if (vid==null||vid==0||staff==null){
            return null;
        }
        return sendDao.selectSendbystaffvisitor(staff,vid);
    }

}
