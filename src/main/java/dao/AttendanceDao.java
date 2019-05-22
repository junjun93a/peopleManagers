package dao;

import model.Attendance;

import java.util.List;

public interface AttendanceDao {
    Integer insertAttendance(Attendance attendance);
    Integer updateAttendance(Attendance attendance);
    Integer deleteAttendance(Integer id);
    List<Attendance> selectAllAttendance();
    List<Attendance> selectAllAttendancebystaffid(Integer sid);
    Attendance selectAttendancebydateandsid(String date,Integer sid);
    Attendance selectAttendancebyid(Integer id);


}
