public class CountSort {
    public static void sort(int[] array){
        int max = maxValue(array);
        int[] counts = new int[max + 1];
        int index = 0;

        for(int item : array){
            counts[item]++;
        }

        for(int i = 0; i < counts.length;i++){
            while(counts[i] > 0){
                array[index++] = i;
                counts[i]--;
            }
        }
    }

    private static int maxValue(int[] array){
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(max < array[i])
                max = array[i];
        }
        return max;
    }
}
