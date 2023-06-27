public class ExponentialSearch {
    public static int search(int[] array,int target){
        int bound = 1;
        while(bound < array.length && array[bound] < target)
            bound *= 2;

        int left = bound/2;
        int right = Math.min(bound,array.length - 1);
        return binarySearch(array,target,left,right);
    }

    private static int binarySearch(int[] array, int target, int left, int right){
        if(left > right)
            return -1;

        int mid = (left + right) / 2;

        if(array[mid] == target)
            return mid;
        if(array[mid] > target)
            return binarySearch(array,target,left,mid - 1);
        return binarySearch(array,target,mid + 1,right);
    }
}
