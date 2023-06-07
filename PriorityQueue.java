import java.util.Arrays;

public class PriorityQueue {
    private int[] array = new int[5];
    private int count = 0;

    public void add(int item){
        if(isFull())
            throw new IllegalStateException();
        int i;
        for(i = count - 1; i >= 0; i--){
            if(array[i] > item)
                array[i + 1] = array[i];
            else
                break;
        }
        array[i + 1] = item;
        count++;
    }

    public int remove(){  //Biggest number has the biggest priority
        if(isEmpty())
            throw new IllegalStateException();
        return array[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
