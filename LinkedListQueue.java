import java.util.NoSuchElementException;

public class LinkedListQueue {
    private class Node{
        private int data;
        private Node next;
        public Node(int data){
            this.data = data;
        }
    }
    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void enqueue(int item){
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
    }

    public int dequeue(){
        int value;
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            value = first.data;
            first = last = null;
            return value;
        }
        Node temp = first;
        value = temp.data;
        first = first.next;
        temp = null;
        return value;
    }

    public int peek(){
        if(isEmpty())
            throw new NoSuchElementException();
        return first.data;
    }

    public int size(){
        int count = 0;
        Node p = first;
        while(p != null){
            count++;
            p = p.next;
        }
        return count;
    }

    public void display(){
        Node p = first;
        while(p != null) {
            System.out.println(p.data);
            p = p.next;
        }
    }
}
