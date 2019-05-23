package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Attendance {
    private Integer T_ID;
    private String T_DATE;
    private String T_STARTTIME;
    private String T_ENDTIME;
    private Integer T_IDSTAFF;
    private Integer T_ERROR;//0无问题，1迟到或早退，3旷工，4加班
    public Attendance() {
    }

    public Attendance(String t_DATE, String t_STARTTIME, Integer t_IDSTAFF) {
        T_DATE = t_DATE;
        T_STARTTIME = t_STARTTIME;
        T_IDSTAFF = t_IDSTAFF;
    }

    public Attendance(String t_DATE, String t_STARTTIME, Integer t_IDSTAFF, Integer t_ERROR) {
        T_DATE = t_DATE;
        T_STARTTIME = t_STARTTIME;
        T_IDSTAFF = t_IDSTAFF;
        T_ERROR = t_ERROR;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public String getT_DATE() {
        return T_DATE;
    }

    public void setT_DATE(String t_DATE) {
        T_DATE = t_DATE;
    }

    public String getT_STARTTIME() {
        return T_STARTTIME;
    }

    public void setT_STARTTIME(String t_STARTTIME) {
        T_STARTTIME = t_STARTTIME;
    }

    public String getT_ENDTIME() {
        return T_ENDTIME;
    }

    public void setT_ENDTIME(String t_ENDTIME) {
        T_ENDTIME = t_ENDTIME;
    }

    public Integer getT_IDSTAFF() {
        return T_IDSTAFF;
    }

    public void setT_IDSTAFF(Integer t_IDSTAFF) {
        T_IDSTAFF = t_IDSTAFF;
    }

    public Integer getT_ERROR() {
        return T_ERROR;
    }

    public void setT_ERROR(Integer t_ERROR) {
        T_ERROR = t_ERROR;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "T_ID=" + T_ID +
                ", T_DATE='" + T_DATE + '\'' +
                ", T_STARTTIME='" + T_STARTTIME + '\'' +
                ", T_ENDTIME='" + T_ENDTIME + '\'' +
                ", T_IDSTAFF=" + T_IDSTAFF +
                ", T_ERROR=" + T_ERROR +
                '}';
    }
}
