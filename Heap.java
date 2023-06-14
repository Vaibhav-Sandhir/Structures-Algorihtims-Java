import java.util.Arrays;

public class Heap {
    private int[] heap;
    private int p = 0;

    public Heap(int size){
        heap = new int[size];
    }

    public void insert(int value){
        if(isFull())
            throw new IllegalStateException();
        heap[p++] = value;
        bubbleUp();
    }

    public int rootRemoval(){
        if(p == 0)
            throw new IllegalStateException();
        int root = heap[0];
        heap[0] = heap[--p]; //Putting the last element in the root
        bubbleDown();
        return root;
    }

    private void bubbleDown(){
        int index = 0;
        while(!isValid(index) && index <= p){
            int larger = largerChild(index);
            swap(index,larger);
            index = larger;
        }
    }

    private int largerChild(int index){
        if(!hasLeftChild(index))  //Left nahin hain toh right bhi nahin hoga
            return index;

        if(!hasRightChild(index))
            return getLeftChild(index);

        if(heap[getLeftChild(index)] > heap[getRightChild(index)])
            return getLeftChild(index);
        return getRightChild(index);
    }

    private boolean hasLeftChild(int index){
        return getLeftChild(index) <= p;
    }

    private boolean hasRightChild(int index){
        return getRightChild(index) <= p;
    }

    private boolean isValid(int index){
        if(!hasLeftChild(index))
            return true;

        if(!hasRightChild(index))
            return heap[index] >= getLeftChild(index);

        return heap[index] >= heap[getLeftChild(index)] && heap[index] >= heap[getRightChild(index)];
    }

    private int getLeftChild(int index){
        return index * 2 + 1;
    }

    private int getRightChild(int index){
        return index * 2 + 2;
    }

    public boolean isEmpty(){
        return p == 0;
    }

    public boolean isFull(){
        return p == heap.length;
    }

    private void bubbleUp(){
        int index = p - 1;
        while(index > 0 && heap[index] > heap[getParent(index)]){
            swap(index,getParent(index));
            index = getParent(index);
        }
    }

    private int getParent(int index){
        return (index - 1) / 2;
    }

    private void swap(int first, int second){
        int temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    @Override
    public String toString(){
        return Arrays.toString(Arrays.copyOfRange(heap,0,p));
    }
}
