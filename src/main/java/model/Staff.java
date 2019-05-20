package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Staff {
    private Integer T_ID;
    private String T_ACCOUNT;
    private String T_PASS;
    private String T_NAME;
    private String T_SEX;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date T_BIRTHDAY;
    private Long T_PHONE;
    private String T_EMAIL;
    private Integer T_AGE;
    private String T_ADDRESS;
    private String T_IMAGE;
    private Integer T_WORKINGSTATE;//0试用，1在职，2离职
    private String T_REASON;
    private Integer T_IDPOSITION;


    public Staff() {
    }

    public Staff(String t_ACCOUNT, String t_PASS, String t_NAME, String t_SEX, Date t_BIRTHDAY, Long t_PHONE, String t_EMAIL, Integer t_AGE, String t_ADDRESS, Integer t_WORKINGSTATE, String t_REASON, Integer t_IDPOSITION) {
        T_ACCOUNT = t_ACCOUNT;
        T_PASS = t_PASS;
        T_NAME = t_NAME;
        T_SEX = t_SEX;
        T_BIRTHDAY = t_BIRTHDAY;
        T_PHONE = t_PHONE;
        T_EMAIL = t_EMAIL;
        T_AGE = t_AGE;
        T_ADDRESS = t_ADDRESS;
        T_WORKINGSTATE = t_WORKINGSTATE;
        T_REASON = t_REASON;
        T_IDPOSITION = t_IDPOSITION;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public String getT_ACCOUNT() {
        return T_ACCOUNT;
    }

    public void setT_ACCOUNT(String t_ACCOUNT) {
        T_ACCOUNT = t_ACCOUNT;
    }

    public String getT_PASS() {
        return T_PASS;
    }

    public void setT_PASS(String t_PASS) {
        T_PASS = t_PASS;
    }

    public String getT_NAME() {
        return T_NAME;
    }

    public void setT_NAME(String t_NAME) {
        T_NAME = t_NAME;
    }

    public String getT_SEX() {
        return T_SEX;
    }

    public void setT_SEX(String t_SEX) {
        T_SEX = t_SEX;
    }

    public Date getT_BIRTHDAY() {
        return T_BIRTHDAY;
    }

    public void setT_BIRTHDAY(Date t_BIRTHDAY) {
        T_BIRTHDAY = t_BIRTHDAY;
    }

    public Long getT_PHONE() {
        return T_PHONE;
    }

    public void setT_PHONE(Long t_PHONE) {
        T_PHONE = t_PHONE;
    }

    public String getT_EMAIL() {
        return T_EMAIL;
    }

    public void setT_EMAIL(String t_EMAIL) {
        T_EMAIL = t_EMAIL;
    }

    public Integer getT_AGE() {
        return T_AGE;
    }

    public void setT_AGE(Integer t_AGE) {
        T_AGE = t_AGE;
    }

    public String getT_ADDRESS() {
        return T_ADDRESS;
    }

    public void setT_ADDRESS(String t_ADDRESS) {
        T_ADDRESS = t_ADDRESS;
    }

    public String getT_IMAGE() {
        return T_IMAGE;
    }

    public void setT_IMAGE(String t_IMAGE) {
        T_IMAGE = t_IMAGE;
    }

    public Integer getT_WORKINGSTATE() {
        return T_WORKINGSTATE;
    }

    public void setT_WORKINGSTATE(Integer t_WORKINGSTATE) {
        T_WORKINGSTATE = t_WORKINGSTATE;
    }

    public String getT_REASON() {
        return T_REASON;
    }

    public void setT_REASON(String t_REASON) {
        T_REASON = t_REASON;
    }

    public Integer getT_IDPOSITION() {
        return T_IDPOSITION;
    }

    public void setT_IDPOSITION(Integer t_IDPOSITION) {
        T_IDPOSITION = t_IDPOSITION;
    }


    public String toStringS() {
        return "员工信息{" +
                ", 姓名='" + T_NAME + '\'' +
                ", 性别='" + T_SEX + '\'' +
                ", 出生日期=" + T_BIRTHDAY +
                ", 手机号码=" + T_PHONE +
                ", 邮箱地址='" + T_EMAIL + '\'' +

                '}';
    }

    @Override
    public String toString() {
        return "员工信息{" +
                "员工id=" + T_ID +
                ", 姓名='" + T_NAME + '\'' +
                ", 性别='" + T_SEX + '\'' +
                ", 出生日期=" + T_BIRTHDAY +
                ", 手机号码=" + T_PHONE +
                ", 邮箱地址='" + T_EMAIL + '\'' +
                ", 工龄=" + T_AGE +
                ", 地址='" + T_ADDRESS + '\'' +
                '}';
    }
}
