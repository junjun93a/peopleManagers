package model;

public class Visitor {
    private Integer T_ID;
    private String T_ACCOUNT;
    private String T_PASS;
    private String T_SEX;
    private Integer T_IDSTAFF;
    private String T_NAME;

    public Visitor() {
    }

    public Visitor(String t_ACCOUNT, String t_PASS, String t_SEX, String t_NAME) {
        T_ACCOUNT = t_ACCOUNT;
        T_PASS = t_PASS;
        T_SEX = t_SEX;
        T_NAME = t_NAME;
    }

    public Visitor(String t_ACCOUNT, String t_PASS) {
        T_ACCOUNT = t_ACCOUNT;
        T_PASS = t_PASS;
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

    public String getT_SEX() {
        return T_SEX;
    }

    public void setT_SEX(String t_SEX) {
        T_SEX = t_SEX;
    }

    public Integer getT_IDSTAFF() {
        return T_IDSTAFF;
    }

    public void setT_IDSTAFF(Integer t_IDSTAFF) {
        T_IDSTAFF = t_IDSTAFF;
    }

    public String getT_NAME() {
        return T_NAME;
    }

    public void setT_NAME(String t_NAME) {
        T_NAME = t_NAME;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "id='" + T_ID + '\'' +
                "T_ACCOUNT='" + T_ACCOUNT + '\'' +
                ", T_PASS='" + T_PASS + '\'' +
                ", T_SEX='" + T_SEX + '\'' +
                ", T_NAME='" + T_NAME + '\'' +
                '}';
    }
}
