package model;

public class Position {

    private Integer T_ID;
    private  String T_NAME;
    private Integer T_IDDEPARTMENT;

    public Position(String t_NAME, Integer t_IDDEPARTMENT) {
        T_NAME = t_NAME;
        T_IDDEPARTMENT = t_IDDEPARTMENT;
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

    public Integer getT_IDDEPARTMENT() {
        return T_IDDEPARTMENT;
    }

    public void setT_IDDEPARTMENT(Integer t_IDDEPARTMENT) {
        T_IDDEPARTMENT = t_IDDEPARTMENT;
    }

    @Override
    public String toString() {
        return "Position{" +
                "T_ID=" + T_ID +
                ", T_NAME='" + T_NAME + '\'' +
                ", T_IDDEPARTMENT=" + T_IDDEPARTMENT +
                '}';
    }
}
