package service;

import model.Department;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DepartmentService {
    boolean insertDepartment(Department department);
    boolean updateDepartment(Department department);
    boolean deleteDepartment(Integer T_ID);
    Department selectDepartmentbyid(Integer id);
    Department selectDepartmentbyname(String name);
    List<Department> selectAllDepartment();

}
