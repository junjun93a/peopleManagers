package service.impl;

import dao.AdminDao;
import model.Admin;
import org.springframework.stereotype.Service;
import service.AdminService;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminDao adminDao;
    @Override
    public Admin adminlogin(Admin admin) {
        if(admin==null){
            return null;
        }
        return adminDao.selectvisitorbyaccountpass(admin);
    }
}
