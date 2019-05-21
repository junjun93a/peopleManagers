package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Training {
    private Integer T_ID;
    private String T_TITLE;
    private String T_DETAIL;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date T_STARTTIME;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date T_ENDTIME;
    private String T_ADDRESS;
    private Integer T_LAUNCH;


    public Training() {
    }

    public Training(String t_TITLE, String t_DETAIL, Date t_STARTTIME, Date t_ENDTIME, String t_ADDRESS, Integer t_LAUNCH) {
        T_TITLE = t_TITLE;
        T_DETAIL = t_DETAIL;
        T_STARTTIME = t_STARTTIME;
        T_ENDTIME = t_ENDTIME;
        T_ADDRESS = t_ADDRESS;
        T_LAUNCH = t_LAUNCH;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public String getT_TITLE() {
        return T_TITLE;
    }

    public void setT_TITLE(String t_TITLE) {
        T_TITLE = t_TITLE;
    }

    public String getT_DETAIL() {
        return T_DETAIL;
    }

    public void setT_DETAIL(String t_DETAIL) {
        T_DETAIL = t_DETAIL;
    }

    public Date getT_STARTTIME() {
        return T_STARTTIME;
    }
    public String getT_STARTTIMES() {
        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String format1 = format.format( T_STARTTIME);
        return format1;
    }
    public void setT_STARTTIME(Date t_STARTTIME) {
        T_STARTTIME = t_STARTTIME;
    }

    public Date getT_ENDTIME() {
        return T_ENDTIME;
    }
    public String getT_ENDTIMES() {
        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String format1 = format.format( T_ENDTIME);
        return format1;
    }

    public void setT_ENDTIME(Date t_ENDTIME) {
        T_ENDTIME = t_ENDTIME;
    }

    public String getT_ADDRESS() {
        return T_ADDRESS;
    }

    public void setT_ADDRESS(String t_ADDRESS) {
        T_ADDRESS = t_ADDRESS;
    }

    public Integer getT_LAUNCH() {
        return T_LAUNCH;
    }

    public void setT_LAUNCH(Integer t_LAUNCH) {
        T_LAUNCH = t_LAUNCH;
    }

    @Override
    public String toString() {
        return "Training{" +
                "T_ID=" + T_ID +
                ", T_TITLE='" + T_TITLE + '\'' +
                ", T_DETAIL='" + T_DETAIL + '\'' +
                ", T_STARTTIME=" + T_STARTTIME +
                ", T_ENDTIME=" + T_ENDTIME +
                ", T_ADDRESS='" + T_ADDRESS + '\'' +
                ", T_LAUNCH=" + T_LAUNCH +
                '}';
    }
}
