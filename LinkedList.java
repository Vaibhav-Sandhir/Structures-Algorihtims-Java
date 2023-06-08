import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }
    private Node first;
    private Node last;

    public void addLast(int item){
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int item){
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else{
            node.next = first;
            first = node;
        }
    }

    public int indexOf(int item){
        int index = 0;
        Node current = first;
        while(current != null){
            if(current.value == item)
                return index;
            index++;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int item){
        Node current = first;
        while(current != null){
            if(current.value == item)
                return true;
            current = current.next;
        }
        return false;
    }

    public void removeFirst(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }
        Node temp = first;
        first = first.next;
        temp = null;
    }

    public void removeLast(){
        if(isEmpty())
            throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }
        last = getPrevious(last);
        last.next = null;
    }

    public void reverse(){
        Node current = last;
        while(current != null){
            Node prev = getPrevious(current);
            current.next = prev;
            current = current.next;
        }
        Node p = first;
        first = last;
        last = p;
    }

    public int size(){
        int size = 0;
        Node current = first;
        while(current != null){
            size++;
            current = current.next;
        }
        return size;
    }

    private boolean isEmpty(){
        return first == null;
    }

    public void display(){
        Node current = first;
        while(current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    private Node getPrevious(Node node){
        if(node == first)
            return null;
        Node current = first;
        while(current.next != node)
            current = current.next;
        return current;
    }

    public int getKthFromTheEnd(int k){
        if(isEmpty())
            throw new IllegalStateException();
        Node a = first;
        Node b = first;
        for(int i = 0;i < k - 1; i++) {
            b = b.next;
            if(b == null)
                throw new IllegalArgumentException();
        }
        while(b != last){
            a = a.next;
            b = b.next;
        }
        return a.value;
    }

    public void middleNode(){
        if(isEmpty())
            throw new IllegalArgumentException();
        Node a = first;
        Node b = first;
        while(b.next != last && b != last){
            a = a.next;
            b = b.next.next;
        }
        if(b == last)
            System.out.println(a.value);
        else
            System.out.println(a.value + " , " + a.next.value);
    }
}
