import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int top = -1;
    private int[] array = new int[5];

    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == array.length;
    }
    public void push(int item){
        if(isFull()){
            throw new StackOverflowError();
        }
        array[++top] = item;
    }
    public int pop(){
        if(isEmpty())
            throw new EmptyStackException();
        return array[top--];
    }
    public int peek() {
        if(isEmpty())
            throw new EmptyStackException();
        return array[top];
    }

    @Override
    public String toString(){
        var content = Arrays.copyOfRange(array,0,top + 1);
        return Arrays.toString(content);
    }
}
