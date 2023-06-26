import java.util.Arrays;

public class BinarySearchRec {
    public static int search(int[] array,int target){
        //Arrays.sort(array);
        return search(array,0,array.length - 1,target);
    }

    private static int search(int[] array,int left,int right,int target){
        int middle = (left + right) / 2;

        if(right < left)
            return -1;

        if(array[middle] == target)
            return middle;

        else if(array[middle] > target)
            return search(array,left,middle - 1,target);

        else
            return search(array,middle + 1,right,target);

    }
 }
