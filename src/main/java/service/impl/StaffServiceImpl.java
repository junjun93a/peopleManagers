package service.impl;

import dao.StaffDao;
import model.Staff;
import org.springframework.stereotype.Service;
import service.StaffService;

import javax.annotation.Resource;
import java.util.List;
@Service
public class StaffServiceImpl implements StaffService {

    @Resource
    private StaffDao staffDao;

    @Override
    public boolean insertStaff(Staff staff) {

        if (staff==null){
            return false;
        }
        Integer i = staffDao.insertStaff(staff);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateStaff(Staff staff) {
        if (staff==null){
            return false;
        }
        Integer i = staffDao.updateStaff(staff);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteStaff(Integer T_ID) {
        if (T_ID == null || T_ID == 0) {
            return false;
        }
        Integer i = staffDao.deleteStaff(T_ID);

        if (i != 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Staff selectStaffbyid(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return staffDao.selectStaffbyid(id);
    }

    @Override
    public Staff selectStaffbyaccountandpass(Staff staff) {
        if (staff==null){
            return null;
        }
        return staffDao.selectStaffbyaccountandpass(staff);
    }

    @Override
    public List<Staff> selectStaffbyposition(Integer pid) {
        if (pid==null||pid==0){
            return null;
        }
        return staffDao.selectStaffbyposition(pid);
    }

    @Override
    public List<Staff> selectStaffbydepartmentid(Integer did) {
        if (did==null||did==0){
            return null;
        }
        return staffDao.selectStaffbydepartmentid(did);
    }
}
