package service;

import model.Attendance;

import java.util.List;

public interface AttendanceService {
    boolean insertAttendance(Attendance attendance);
    boolean updateAttendance(Attendance attendance);
    boolean deleteAttendance(Integer id);
    List<Attendance> selectAllAttendance();
    List<Attendance> selectAllAttendancebystaffid(Integer sid);
    Attendance selectAttendancebydateandsid(String date,Integer sid);
    Attendance selectAttendancebyid(Integer id);
    List<Attendance> selectAttendancebymonthandsid(String month,Integer sid);
}
