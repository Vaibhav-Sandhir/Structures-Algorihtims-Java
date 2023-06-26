public class MergeSort {
    public static void sort(int[] array){
        if(array.length <= 1)
            return;

        int middle = array.length / 2;

        int[] leftPartition = new int[middle];
        for(int i = 0; i < middle; i++){
            leftPartition[i] = array[i];
        }

        int[] rightPartition = new int[array.length - middle];
        for(int i = middle; i < array.length; i++){
            rightPartition[i - middle] = array[i];
        }

        sort(leftPartition);
        sort(rightPartition);
        merge(leftPartition,rightPartition,array);
    }

    private static void merge(int[] leftPartition, int[] rightPartition, int[] result){
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < leftPartition.length && j < rightPartition.length){
            if(leftPartition[i] <= rightPartition[j])
                result[k++] = leftPartition[i++];
            else
                result[k++] = rightPartition[j++];
        }

        while(i < leftPartition.length)
            result[k++] = leftPartition[i++];

        while(j < rightPartition.length)
            result[k++] = rightPartition[j++];
    }
}
