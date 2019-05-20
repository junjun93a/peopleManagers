package dao;

import model.Staff;

import java.util.List;

public interface StaffDao {

    Integer insertStaff(Staff staff);
    Integer updateStaff(Staff staff);
    Integer deleteStaff(Integer T_ID);
    Staff selectStaffbyid(Integer id);
    Staff selectStaffbyaccountandpass(Staff staff);
    List<Staff> selectStaffbyposition(Integer pid);
    List<Staff> selectStaffbydepartmentid(Integer did);
}
