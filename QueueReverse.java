import java.util.Queue;
import java.util.Stack;

public class QueueReverse {
    public static void reverse(Queue<Integer> queue){
        Stack<Integer> stack = new Stack<>();
        while(!(queue.isEmpty())){
            stack.push(queue.remove());
        }
        while(!(stack.isEmpty())){
            queue.add(stack.pop());
        }
    }
}
