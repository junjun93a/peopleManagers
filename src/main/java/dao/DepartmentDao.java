package dao;

import model.Department;

import java.util.List;

public interface DepartmentDao {

    Integer insertDepartment(Department department);
    Integer updateDepartment(Department department);
    Integer deleteDepartment(Integer T_ID);
    Department selectDepartmentbyid(Integer id);
    Department selectDepartmentbyname(String name);
    List<Department> selectAllDepartment();
}
