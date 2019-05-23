package dao;

import model.Attendance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AttendanceDao {
    Integer insertAttendance(Attendance attendance);
    Integer updateAttendance(Attendance attendance);
    Integer deleteAttendance(Integer id);
    List<Attendance> selectAllAttendance();
    List<Attendance> selectAllAttendancebystaffid(Integer sid);
    Attendance selectAttendancebydateandsid(String date,Integer sid);
    List<Attendance> selectAttendancebymonthandsid(@Param("month")String month, @Param("sid")Integer sid);
    List<Attendance> selectAttendancebymonthandmanysid(@Param("month")String month, @Param("sid")List<Integer> sids);

    Attendance selectAttendancebyid(Integer id);


}
