import java.util.Arrays;

public class ArrayQueue {
    private int[] array;
    private int front = 0;
    private int rear = 0;
    private int count = 0;

    public ArrayQueue(int capacity){
        array = new int[capacity];
    }

    public void enqueue(int item){
        if(count == array.length)
            throw new IllegalStateException();
        array[rear] = item;
        rear = (rear + 1) % array.length;
        count++;
    }

    public int dequeue(){
        var item = array[front];
        array[front] = 0;
        front = (front + 1) % array.length;
        count--;
        return item;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == array.length;
    }

    public int peek(){
        return array[front];
    }

    @Override
    public String toString(){
        return Arrays.toString(array);
    }
}
