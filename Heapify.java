public class Heapify {

    public static void heapify(int[] array){
        for(int i = (array.length / 2) - 1; i >= 0; i++)
            heapify(array,i);
    }

    private static void heapify(int[] array, int index){
        int larger = index;

        int leftIndex = index * 2 + 1;
        if(leftIndex < array.length && array[larger] < array[leftIndex])
            larger = leftIndex;

        int rightIndex = index * 2 + 2;
        if(rightIndex < array.length && array[larger] < array[rightIndex])
            larger = rightIndex;

        if(index == larger)
            return;

        swap(array,index,larger);
        heapify(array,larger);
    }

    private static void swap(int[] array,int first,int second){
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
