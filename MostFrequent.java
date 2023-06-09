import java.util.*;

public class MostFrequent {
    public static int mostFrequent(int[] array){
        Map<Integer, Integer> map = new HashMap<>();
        for(int item: array){
            if(map.containsKey(item)){
                int count = map.get(item) + 1;
                map.put(item,count);
            }
            else{
                map.put(item,1);
            }
        }
        int max = array[0];
        for(int item: array){
            if(map.get(max) < map.get(item))
                max = item;
        }
        return max;
    }
}
