import java.util.*;

public class FirstRepeated {
    public static char firstRepeated(String str){
        Map<Character,Integer> map = new HashMap<>();
        char[] array = str.toCharArray();
        for(var item: str.toCharArray()){
            if(map.containsKey(item))
                return item;
            else
                map.put(item,1);
        }
        return ' ';
    }
}
