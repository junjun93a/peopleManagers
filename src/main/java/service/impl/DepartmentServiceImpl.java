package service.impl;

import dao.DepartmentDao;
import dao.PositionDao;
import model.Department;
import org.springframework.stereotype.Service;
import service.DepartmentService;
import service.PositionService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Resource
    private DepartmentDao departmentDao;

    @Resource
    private PositionDao positionDao;

    @Override
    public boolean insertDepartment(Department department) {
        if (department==null){
            return false;
        }
        Integer i = departmentDao.insertDepartment(department);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateDepartment(Department department) {
        if (department==null){
            return false;
        }
        Integer i = departmentDao.updateDepartment(department);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteDepartment(Integer T_ID) {
        if (T_ID==null||T_ID==0){
            return false;
        }
        Integer i = departmentDao.deleteDepartment(T_ID);
        Integer j=positionDao.deletePositionbydid(T_ID);
        if(i!=0&&j!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Department selectDepartmentbyid(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return departmentDao.selectDepartmentbyid(id);
    }

    @Override
    public Department selectDepartmentbyname(String name) {
        if (name==null){
            return null;
        }
        return departmentDao.selectDepartmentbyname(name);
    }

    @Override
    public List<Department> selectAllDepartment() {
        return departmentDao.selectAllDepartment();
    }
}
