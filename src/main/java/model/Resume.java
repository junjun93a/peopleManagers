package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Resume {
    private Integer T_ID;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date T_BIRTHDAY;
    private Long T_PHONE;
    private String T_EMAIL;
    private String T_ADDRESS;
    private Integer T_AGE;
    private Double T_HOPEMONEY;
    private String T_EDUCATION;
    private String T_HOPEPOSITION;
    private String T_WORKEXPERIENCE;
    private String T_LANGUAGE;
    private String T_ADDINFORMATION;
    private Integer T_IDVISITOR;
    private String T_SEX;
    private String T_NAME;


    public Resume() {
    }

    public Resume(Date t_BIRTHDAY, Long t_PHONE, String t_EMAIL, String t_ADDRESS, Integer t_AGE, Double t_HOPEMONEY, String t_EDUCATION, String t_HOPEPOSITION, String t_WORKEXPERIENCE, String t_LANGUAGE, String t_ADDINFORMATION, Integer t_IDVISITOR, String t_SEX, String t_NAME) {
        T_BIRTHDAY = t_BIRTHDAY;
        T_PHONE = t_PHONE;
        T_EMAIL = t_EMAIL;
        T_ADDRESS = t_ADDRESS;
        T_AGE = t_AGE;
        T_HOPEMONEY = t_HOPEMONEY;
        T_EDUCATION = t_EDUCATION;
        T_HOPEPOSITION = t_HOPEPOSITION;
        T_WORKEXPERIENCE = t_WORKEXPERIENCE;
        T_LANGUAGE = t_LANGUAGE;
        T_ADDINFORMATION = t_ADDINFORMATION;
        T_IDVISITOR = t_IDVISITOR;
        T_SEX = t_SEX;
        T_NAME = t_NAME;
    }


    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public Date getT_BIRTHDAY() {
        return T_BIRTHDAY;
    }
    public String getT_BIRTHDAYS() {
        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日");
        String format1 = format.format(T_BIRTHDAY);
        return format1;
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

    public String getT_ADDRESS() {
        return T_ADDRESS;
    }

    public void setT_ADDRESS(String t_ADDRESS) {
        T_ADDRESS = t_ADDRESS;
    }

    public Integer getT_AGE() {
        return T_AGE;
    }

    public void setT_AGE(Integer t_AGE) {
        T_AGE = t_AGE;
    }

    public Double getT_HOPEMONEY() {
        return T_HOPEMONEY;
    }

    public void setT_HOPEMONEY(Double t_HOPEMONEY) {
        T_HOPEMONEY = t_HOPEMONEY;
    }

    public String getT_EDUCATION() {
        return T_EDUCATION;
    }

    public void setT_EDUCATION(String t_EDUCATION) {
        T_EDUCATION = t_EDUCATION;
    }

    public String getT_HOPEPOSITION() {
        return T_HOPEPOSITION;
    }

    public void setT_HOPEPOSITION(String t_HOPEPOSITION) {
        T_HOPEPOSITION = t_HOPEPOSITION;
    }

    public String getT_WORKEXPERIENCE() {
        return T_WORKEXPERIENCE;
    }

    public void setT_WORKEXPERIENCE(String t_WORKEXPERIENCE) {
        T_WORKEXPERIENCE = t_WORKEXPERIENCE;
    }

    public String getT_LANGUAGE() {
        return T_LANGUAGE;
    }

    public void setT_LANGUAGE(String t_LANGUAGE) {
        T_LANGUAGE = t_LANGUAGE;
    }

    public String getT_ADDINFORMATION() {
        return T_ADDINFORMATION;
    }

    public void setT_ADDINFORMATION(String t_ADDINFORMATION) {
        T_ADDINFORMATION = t_ADDINFORMATION;
    }

    public Integer getT_IDVISITOR() {
        return T_IDVISITOR;
    }

    public void setT_IDVISITOR(Integer t_IDVISITOR) {
        T_IDVISITOR = t_IDVISITOR;
    }

    public String getT_SEX() {
        return T_SEX;
    }

    public void setT_SEX(String t_SEX) {
        T_SEX = t_SEX;
    }

    public String getT_NAME() {
        return T_NAME;
    }

    public void setT_NAME(String t_NAME) {
        T_NAME = t_NAME;
    }

    @Override
    public String toString() {
        return "简历：{" +

                ", 生日=" + getT_BIRTHDAYS() +
                ", 电话=" + T_PHONE +
                ", 邮箱='" + T_EMAIL + '\'' +
                ", 地址='" + T_ADDRESS + '\'' +
                ", 工龄=" + T_AGE +
                ", 期望薪资=" + T_HOPEMONEY +
                ", 学历='" + T_EDUCATION + '\'' +
                ", 期望岗位='" + T_HOPEPOSITION + '\'' +
                ", 工作经验='" + T_WORKEXPERIENCE + '\'' +
                ", 语言='" + T_LANGUAGE + '\'' +
                '}';
    }
}
