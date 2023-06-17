public class MinHeap {
    private class Node{
        private int key;
        private String value;

        public Node(int key,String value){
            this.key = key;
            this.value = value;
        }
    }

    private Node[] heap;
    private int p = 0;

    public MinHeap(int size){
        heap = new Node[size];
    }

    public void insert(int key, String value){
        if(isFull())
            throw new IllegalStateException();
        heap[p++] = new Node(key,value);
        bubbleUp();
    }

    public String rootRemoval(){
        if(isEmpty())
            throw new IllegalStateException();
        String root = heap[0].value;
        heap[0] = heap[--p];
        bubbleDown();
        return root;
    }

    private void bubbleDown(){
        int i = 0;
        while(i <= p && !isValidParent(i)){
            int smaller_index = smallerChild(i);
            swap(i,smaller_index);
            i = smaller_index;
        }
    }

    private boolean isValidParent(int i){
         if(!hasLeftChild(i))
             return true;

         if(!hasRightChild(i))
             return heap[i].key <= heap[getLeftChild(i)].key;

         return heap[i].key <=  heap[getLeftChild(i)].key && heap[i].key <=  heap[getRightChild(i)].key;
    }

    private int smallerChild(int i){
        if(!hasLeftChild(i))
            return i;

        if(!hasRightChild(i))
            return getLeftChild(i);

        if(heap[getLeftChild(i)].key > heap[getRightChild(i)].key)
            return getRightChild(i);
        return getLeftChild(i);
    }

    private int getLeftChild(int i){
        return (i * 2) + 1;
    }

    private int getRightChild(int i){
        return (i * 2) + 2;
    }

    private boolean hasLeftChild(int i){
        return getLeftChild(i) <= p;
    }

    private boolean hasRightChild(int i){
        return getRightChild(i) <= p;
    }

    private void bubbleUp(){
        int index = p - 1;
        while(index > 0 && heap[index].key < heap[getParent(index)].key){
            swap(index,getParent(index));
            index = getParent(index);
        }
    }

    public void swap(int first,int second){
        Node temp = heap[first];
        heap[first] = heap[second];
        heap[second] = temp;
    }

    private int getParent(int i){
        return (i - 1) / 2;
    }

    public boolean isFull(){
        return p == heap.length;
    }

    public boolean isEmpty(){
        return p == 0;
    }
}
