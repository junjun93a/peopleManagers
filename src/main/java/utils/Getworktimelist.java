package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Getworktimelist {
    public static List<String> gettlist() throws ParseException {
        List<String> list = new ArrayList<>();
        Date date=new Date();
        DateFormat month=new SimpleDateFormat("yyyy-MM");
        String ym = month.format(date);
        DateFormat day=new SimpleDateFormat("dd");
        Integer dd = Integer.valueOf(day.format(date));
        String m=null;
        for (int i =1; i<dd; i++) {
            if(i>9){
                m= String.valueOf(i);
            }else {
                m="0"+i;
            }
            String aDate =ym+"-"+m;
            DateFormat date1=new SimpleDateFormat("yyyy-MM-dd");
            Date weekday = date1.parse(aDate);
            if(weekday.getDay()!=0&&weekday.getDay()!=6){
                list.add(aDate);
            }
        }
       return list;
    }
}
