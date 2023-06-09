import java.util.HashMap;
import java.util.Map;
public class FirstNonRepeating {
    public static char check(String str){
        Map<Character,Integer> map = new HashMap<>();
        for(var item: str.toCharArray()){
            if(map.containsKey(item)){
                var count = map.get(item) + 1;
                map.put(item,count);
            }
            else
                map.put(item,1);
        }
        for(var item: str.toCharArray()){
            if(map.get(item) == 1)
                return item;
        }
        return ' ';
    }
}
