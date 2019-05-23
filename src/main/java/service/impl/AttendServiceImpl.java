package service.impl;

import dao.AttendanceDao;
import model.Attendance;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import service.AttendanceService;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AttendServiceImpl implements AttendanceService {

    @Resource
    private AttendanceDao attendanceDao;

    @Override
    public boolean insertAttendance(Attendance attendance) {
        if (attendance==null){
            return false;
        }
        Integer i = attendanceDao.insertAttendance(attendance);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateAttendance(Attendance attendance) {
        if (attendance==null){
            return false;
        }
        Integer i = attendanceDao.updateAttendance(attendance);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteAttendance(Integer id) {
        if (id==null||id==0){
            return false;
        }
        Integer i = attendanceDao.deleteAttendance(id);

        if(i!=0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public List<Attendance> selectAllAttendance() {
       return attendanceDao.selectAllAttendance();
    }

    @Override
    public List<Attendance> selectAllAttendancebystaffid(Integer sid) {
        if (sid==null||sid==0){
            return null;
        }
        return attendanceDao.selectAllAttendancebystaffid(sid);
    }

    @Override
    public Attendance selectAttendancebydateandsid(String date, Integer sid) {

        if (sid==null||sid==0||date==null){
            return null;
        }
        return attendanceDao.selectAttendancebydateandsid(date,sid);
    }

    @Override
    public Attendance selectAttendancebyid(Integer id) {
        if (id==null||id==0){
            return null;
        }
        return attendanceDao.selectAttendancebyid(id);
    }

    @Override
    public List<Attendance> selectAttendancebymonthandsid(String month, Integer sid) {
        if (sid==null||sid==0||month==null){
            return null;
        }
        return attendanceDao.selectAttendancebymonthandsid(month,sid);
    }

    @Override
    public List<Attendance> selectAttendancebymonthandmanysid(String month, List<Integer> sids) {
        if (month==null||sids.size()==0||sids==null){
            return null;
        }
        return attendanceDao.selectAttendancebymonthandmanysid(month,sids);
    }
}
