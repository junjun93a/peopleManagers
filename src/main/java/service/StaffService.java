package service;

import model.Staff;

import java.util.List;

public interface StaffService {
    boolean insertStaff(Staff staff,Integer sid);
    boolean updateStaff(Staff staff);
    boolean deleteStaff(Integer T_ID);
    Staff selectStaffbyid(Integer id);
    Staff selectStaffbyaccountandpass(Staff staff);
    List<Staff> selectStaffbyallposition(Integer pid);
    List<Staff> selectStaffbyposition(Integer pid);
    List<Staff> selectStaffbydepartmentid(Integer did);
    List<Staff> selectAllStaff();
}
