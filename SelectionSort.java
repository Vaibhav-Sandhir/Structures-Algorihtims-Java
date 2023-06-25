public class SelectionSort {

    public static void sort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            for(int j = i; j < array.length; j++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            swap(array,i,minIndex);
        }
    }

    private static void swap(int[] array, int first, int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
