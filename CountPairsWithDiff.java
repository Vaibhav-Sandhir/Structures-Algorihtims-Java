import java.util.*;

public class CountPairsWithDiff {
    public static int countPairs(int[] array, int difference){
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for(int item: array)
            set.add(item);
        for(int item: array){
            if(set.contains(item + difference))
                count++;
            if(set.contains(item - difference))
                count++;
            set.remove(item);
        }
        return count;
    }
}
