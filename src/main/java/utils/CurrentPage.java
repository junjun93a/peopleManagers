package utils;

import java.util.ArrayList;
import java.util.List;

public class CurrentPage {
    public static <T> List<List<T>> split(Class<T> clazz,List<T> list,Integer items){
        List<List<T>> page = new ArrayList<>();
        int totalPage = 1;
        if(list.size()!=0){
            if((list.size())%items==0){
                totalPage = (list.size()/items);
            }else{
                totalPage = (list.size()/items)+1;
            }
            for(int i=1;i<=totalPage;i++){
                List<T> save = new ArrayList<>();
                for(int j=1; j<=items; j++){
                    try {
                        save.add(list.get(((i - 1) * items + j) - 1));
                    } catch (Exception e) {
                        break;
                    }
                }
                page.add(save);
            }
        }
        return page;
    }
    public static <T> List<T> getSplit(Class<T> clazz,List<List<T>> list,Integer page){
        int choose = page-1;
        if(list.isEmpty()){
            return null;
        }else if(page > list.size()){
            choose = list.size()-1;
        }
        if(page<1){
            choose = 0;
        }
        return list.get(choose);
    }
}
