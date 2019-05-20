package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Recruit {
    private Integer T_ID;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date T_DATE;
    private Integer T_DEPARTMENT;
    private Integer T_POSITION;
    private Double T_MONEY;
    private String T_EDUCATION;
    private Integer T_AGE;
    private Integer T_LAUNCH;//0未发，1已发
    private String T_DETAIL;
    private String T_CITY;

    public Recruit() {
    }

    public Recruit(Date t_DATE, Integer t_DEPARTMENT, Integer t_POSITION, Double t_MONEY, String t_EDUCATION, Integer t_AGE, Integer t_LAUNCH, String t_DETAIL, String t_CITY) {
        T_DATE = t_DATE;
        T_DEPARTMENT = t_DEPARTMENT;
        T_POSITION = t_POSITION;
        T_MONEY = t_MONEY;
        T_EDUCATION = t_EDUCATION;
        T_AGE = t_AGE;
        T_LAUNCH = t_LAUNCH;
        T_DETAIL = t_DETAIL;
        T_CITY = t_CITY;
    }

    public String getT_CITY() {
        return T_CITY;
    }

    public void setT_CITY(String t_CITY) {
        T_CITY = t_CITY;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public String getT_DATES() {
        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日");
        String format1 = format.format(T_DATE);
        return format1;
    }

    public Date getT_DATE() {
        return T_DATE;
    }

    public void setT_DATE(Date t_DATE) {
        T_DATE = t_DATE;
    }

    public Integer getT_DEPARTMENT() {
        return T_DEPARTMENT;
    }

    public void setT_DEPARTMENT(Integer t_DEPARTMENT) {
        T_DEPARTMENT = t_DEPARTMENT;
    }

    public Integer getT_POSITION() {
        return T_POSITION;
    }

    public void setT_POSITION(Integer t_POSITION) {
        T_POSITION = t_POSITION;
    }

    public Double getT_MONEY() {
        return T_MONEY;
    }

    public void setT_MONEY(Double t_MONEY) {
        T_MONEY = t_MONEY;
    }

    public String getT_EDUCATION() {
        return T_EDUCATION;
    }

    public void setT_EDUCATION(String t_EDUCATION) {
        T_EDUCATION = t_EDUCATION;
    }

    public Integer getT_AGE() {
        return T_AGE;
    }

    public void setT_AGE(Integer t_AGE) {
        T_AGE = t_AGE;
    }

    public Integer getT_LAUNCH() {
        return T_LAUNCH;
    }

    public void setT_LAUNCH(Integer t_LAUNCH) {
        T_LAUNCH = t_LAUNCH;
    }

    public String getT_DETAIL() {
        return T_DETAIL;
    }

    public void setT_DETAIL(String t_DETAIL) {
        T_DETAIL = t_DETAIL;
    }

    @Override
    public String toString() {
        return "Recruit{" +
                "T_ID=" + T_ID +
                ", T_DATE=" + T_DATE +
                ", T_DEPARTMENT=" + T_DEPARTMENT +
                ", T_POSITION=" + T_POSITION +
                ", T_MONEY=" + T_MONEY +
                ", T_EDUCATION='" + T_EDUCATION + '\'' +
                ", T_AGE=" + T_AGE +
                ", T_LAUNCH=" + T_LAUNCH +
                ", T_DETAIL='" + T_DETAIL + '\'' +
                ", T_CITY='" + T_CITY + '\'' +
                '}';
    }
}
