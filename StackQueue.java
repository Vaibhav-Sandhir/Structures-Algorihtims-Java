import java.util.Stack;

public class StackQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public void enqueue(int item){
        s1.push(item);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        Moves1Tos2();

        return s2.pop();
    }

    public boolean isEmpty(){
        return s1.isEmpty() && s2.isEmpty();
    }
    
    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        Moves1Tos2();
        return s2.peek();
    }

    private void Moves1Tos2() {
        if(s2.isEmpty())
            while(!(s1.isEmpty()))
                s2.push(s1.pop());
    }
}
