package model;

public class Admin {
    private Integer T_ID;
    private String T_ACCOUNT;
    private String T_PASS;

    public Admin() {
    }

    public Admin(String t_ACCOUNT, String t_PASS) {
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

    @Override
    public String toString() {
        return "Admin{" +
                "T_ID=" + T_ID +
                ", T_ACCOUNT='" + T_ACCOUNT + '\'' +
                ", T_PASS='" + T_PASS + '\'' +
                '}';
    }
}
