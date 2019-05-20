package dao;

import model.Send;

import java.util.List;

public interface SendDao {
    Integer insertSend(Send send);
    Integer updateSend(Send send);
    Integer updateSendTime(Send send);
    Integer deleteSend(Integer T_ID);
    List<Send> selectSendbyrid(Integer T_IDRECRUIT);//按招聘查
    Send selectSendbyid(Integer id);//按id查
    List<Send> selectSendbystaff(Integer staff);//按状态查
    List<Send> selectSendbystaffs(List<Integer> staff);
    List<Send> selectSendbyvisitor(Integer vid);
    List<Send> selectSendbystaffvisitor(Integer staff, Integer vid);//按状态和游客查
}
