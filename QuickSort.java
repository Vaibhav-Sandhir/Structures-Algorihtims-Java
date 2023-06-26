public class QuickSort {

    public static void sort(int[] array){
        sort(array,0,array.length - 1);
    }

    private static void sort(int[] array, int start, int end){
        if(start >= end)
            return;

        int boundary = partition(array, start, end);
        sort(array,start,boundary - 1);
        sort(array,boundary + 1, end);
    }

    private static int partition(int[] array, int start, int end){
        int pivot = array[end];
        int boundary = start - 1;
        for(int i = start; i <= end; i++){
            if(array[i] <= pivot)
                swap(array, i, ++boundary);
        }
        return boundary;
    }

    private static void swap(int[] array,int first,int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
