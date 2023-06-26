import java.util.*;

public class BucketSort {
    public static void sort(int[] array, int numberOfBuckets){
        List<List<Integer>> buckets = new ArrayList<>();
        int index = 0;

        for(int i = 0; i < numberOfBuckets; i++)
            buckets.add(new ArrayList<>());

        for(int item: array)
            buckets.get(item / numberOfBuckets).add(item);

        for(List<Integer> bucket: buckets) {
            Collections.sort(bucket);
            for(int item: bucket)
                array[index++] = item;
        }
    }
}
