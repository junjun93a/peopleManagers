package model;

import java.util.Date;

public class Rewardandpunish {
    private Integer T_ID;
    private String T_TIME;
    private String T_REASON;
    private Double T_MONEY;
    private Integer T_IDSTAFF;

    public Rewardandpunish() {
    }

    public Rewardandpunish(String t_TIME, String t_REASON, Double t_MONEY, Integer t_IDSTAFF) {
        T_TIME = t_TIME;
        T_REASON = t_REASON;
        T_MONEY = t_MONEY;
        T_IDSTAFF = t_IDSTAFF;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public String getT_TIME() {
        return T_TIME;
    }

    public void setT_TIME(String t_TIME) {
        T_TIME = t_TIME;
    }

    public String getT_REASON() {
        return T_REASON;
    }

    public void setT_REASON(String t_REASON) {
        T_REASON = t_REASON;
    }

    public Double getT_MONEY() {
        return T_MONEY;
    }

    public void setT_MONEY(Double t_MONEY) {
        T_MONEY = t_MONEY;
    }

    public Integer getT_IDSTAFF() {
        return T_IDSTAFF;
    }

    public void setT_IDSTAFF(Integer t_IDSTAFF) {
        T_IDSTAFF = t_IDSTAFF;
    }


    @Override
    public String toString() {
        return "Rewardandpunish{" +
                "T_ID=" + T_ID +
                ", T_TIME=" + T_TIME +
                ", T_REASON='" + T_REASON + '\'' +
                ", T_MONEY=" + T_MONEY +
                ", T_IDSTAFF=" + T_IDSTAFF +
                '}';
    }
}
