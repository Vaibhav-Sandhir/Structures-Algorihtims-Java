public class BubbleSort {
    public static void sort(int[] array){
        boolean isSorted;
        for(int i = 0; i < array.length - 1; i++){
            isSorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    isSorted = false;
                }
                if(isSorted)
                    return;
            }
        }
    }

    private static void swap(int[] array,int first,int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
