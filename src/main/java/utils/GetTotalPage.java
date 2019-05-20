package utils;

public class GetTotalPage {
    public static int getTp(int totalRows ,int pageSize){
        if (totalRows==0){
            return 1;
        }
        return totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
    }
}
