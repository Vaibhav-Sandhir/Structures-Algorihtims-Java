import java.util.Arrays;

public class MinStack {
    private int top;
    private int capacity;
    private int[] items;

    public MinStack(int capacity){
        if(capacity <= 0)
            throw new IllegalArgumentException();
        this.capacity = capacity;
        items = new int[capacity];
        top = -1;
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == capacity - 1;
    }
    public int minElement(){
        if(isEmpty())
            return -1;
        return items[top];
    }
    public void push(int item) {
        if (isFull())
            throw new IllegalStateException();
        if (isEmpty())
            items[++top] = item;
        else {
            int temp = minElement();
            if (temp < item) {
                pop();
                items[++top] = item;
                items[++top] = temp;
            } else {
                items[++top] = item;
            }
        }
    }
    public int pop(){
            if(isEmpty())
                throw new IllegalStateException();
            return items[top--];
        }
    @Override
    public String toString(){
        return Arrays.toString(items);
    }
}
