public class InsertionSort {

    public static void sort(int[] array){
        for(int i = 1; i < array.length; i++){
            int current = array[i];
            for(int j = i - 1; j >= 0; j--){
                if(array[j] > current){
                    array[j + 1] = array[j];
                    array[j] = current;
                }
            }
        }
    }
}
