package model;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Send {
    private Integer T_ID;
    private Integer T_IDRECRUIT;
    private Integer T_IDVISITOR;
    private Integer T_IDRESUME;
    private Integer T_STATE;//0是刚投递，1是投递已读，2是面试通知,3是已面试录取，4是已面试未录用，5放弃面试
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date T_TIME;
    private String T_RECRUITDE;
    private String T_RESUMEDE;
    private Integer T_IDSTAFF;
    public Send() {
    }

    public Send(Integer t_IDRECRUIT, Integer t_IDVISITOR, Integer t_IDRESUME, Integer t_STATE, String t_RECRUITDE, String t_RESUMEDE) {
        T_IDRECRUIT = t_IDRECRUIT;
        T_IDVISITOR = t_IDVISITOR;
        T_IDRESUME = t_IDRESUME;
        T_STATE = t_STATE;
        T_RECRUITDE = t_RECRUITDE;
        T_RESUMEDE = t_RESUMEDE;
    }

    public Integer getT_IDSTAFF() {
        return T_IDSTAFF;
    }

    public void setT_IDSTAFF(Integer t_IDSTAFF) {
        T_IDSTAFF = t_IDSTAFF;
    }

    public String getT_RECRUITDE() {
        return T_RECRUITDE;
    }

    public void setT_RECRUITDE(String t_RECRUITDE) {
        T_RECRUITDE = t_RECRUITDE;
    }

    public String getT_RESUMEDE() {
        return T_RESUMEDE;
    }

    public void setT_RESUMEDE(String t_RESUMEDE) {
        T_RESUMEDE = t_RESUMEDE;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public Integer getT_IDRECRUIT() {
        return T_IDRECRUIT;
    }

    public void setT_IDRECRUIT(Integer t_IDRECRUIT) {
        T_IDRECRUIT = t_IDRECRUIT;
    }

    public Integer getT_IDVISITOR() {
        return T_IDVISITOR;
    }

    public void setT_IDVISITOR(Integer t_IDVISITOR) {
        T_IDVISITOR = t_IDVISITOR;
    }

    public Integer getT_IDRESUME() {
        return T_IDRESUME;
    }

    public void setT_IDRESUME(Integer t_IDRESUME) {
        T_IDRESUME = t_IDRESUME;
    }

    public Integer getT_STATE() {
        return T_STATE;
    }

    public void setT_STATE(Integer t_STATE) {
        T_STATE = t_STATE;
    }

    public Date getT_TIME() {
        return T_TIME;
    }
    public String getT_TIMES() {

        DateFormat format= new SimpleDateFormat("yyyy年MM月dd日 HH点mm分");
        String format1 = format.format(T_TIME);
        return format1;
    }
    public void setT_TIME(Date t_TIME) {
        T_TIME = t_TIME;
    }

    @Override
    public String toString() {
        return "Send{" +
                "T_ID=" + T_ID +
                ", T_IDRECRUIT=" + T_IDRECRUIT +
                ", T_IDVISITOR=" + T_IDVISITOR +
                ", T_IDRESUME=" + T_IDRESUME +
                ", T_STATE=" + T_STATE +
                ", T_TIME=" + T_TIME +
                ", T_RECRUITDE='" + T_RECRUITDE + '\'' +
                ", T_RESUMEDE='" + T_RESUMEDE + '\'' +
                '}';
    }
}
