package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Department {
    private Integer T_ID;
    private  String T_NAME;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date T_TIME;

    public Department(String t_NAME, Date t_TIME) {
        T_NAME = t_NAME;
        T_TIME = t_TIME;
    }


    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public String getT_NAME() {
        return T_NAME;
    }

    public void setT_NAME(String t_NAME) {
        T_NAME = t_NAME;
    }

    public Date getT_TIME() {
        return T_TIME;
    }

    public String getT_TIMES() {

        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日");
        String format1 = format.format( T_TIME);
        return format1;

    }

    public void setT_TIME(Date t_TIME) {
        T_TIME = t_TIME;
    }

    @Override
    public String toString() {
        return "Department{" +
                "T_ID=" + T_ID +
                ", T_NAME='" + T_NAME + '\'' +
                ", T_TIME=" + T_TIME +
                '}';
    }
}
