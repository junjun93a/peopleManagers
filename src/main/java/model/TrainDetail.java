package model;

public class TrainDetail {
    private Integer T_ID;
    private Integer T_IDSTAFF;
    private Integer T_IDTRAINING;

    public TrainDetail() {

    }

    public TrainDetail(Integer t_IDSTAFF, Integer t_IDTRAINING) {
        T_IDSTAFF = t_IDSTAFF;
        T_IDTRAINING = t_IDTRAINING;
    }

    public Integer getT_ID() {
        return T_ID;
    }

    public void setT_ID(Integer t_ID) {
        T_ID = t_ID;
    }

    public Integer getT_IDSTAFF() {
        return T_IDSTAFF;
    }

    public void setT_IDSTAFF(Integer t_IDSTAFF) {
        T_IDSTAFF = t_IDSTAFF;
    }

    public Integer getT_IDTRAINING() {
        return T_IDTRAINING;
    }

    public void setT_IDTRAINING(Integer t_IDTRAINING) {
        T_IDTRAINING = t_IDTRAINING;
    }


    @Override
    public String toString() {
        return "Traindetail{" +
                "T_ID=" + T_ID +
                ", T_IDSTAFF=" + T_IDSTAFF +
                ", T_IDTRAINING=" + T_IDTRAINING +
                '}';
    }
}
