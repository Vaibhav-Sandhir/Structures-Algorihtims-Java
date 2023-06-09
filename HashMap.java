import java.util.Arrays;
import java.util.NoSuchElementException;

public class HashMap {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key,String value){
            this.key = key;
            this.value = value;
        }
        @Override
        public String toString(){
            return value;
        }
    }
    private Entry[] array;
    private int capacity;
    public HashMap(int capacity){
        this.capacity = capacity;
        array = new Entry[capacity];
    }
    private int hash(int key){
        return key % capacity;
    }
    public void put(int key,String value){
        Entry e = new Entry(key,value);
        int index = hash(key);
        if(array[index] == null)
            array[index] = e;
        else{
            int p = index + 1;
            while(true){
                if(p == index){
                    System.out.println("Hash Table is Full");
                    return;
                }
                else if(array[p] == null) {
                    array[p] = e;
                    return;
                }
                p = (p + 1) % capacity;
            }
        }
    }
    public String get(int key){
        int index = hash(key);
        if(array[index] == null)
            throw new NoSuchElementException();
        else if(array[index].key == key)
            return array[index].value;
        else{
            int p = index + 1;
            while(p != index){
                if(array[p].key == key)
                    return array[p].value;
                p = (p + 1) % capacity;
            }
        }
        return "";
    }
    public void remove(int key){
        int index = hash(key);
        if(array[index] == null)
            return;
        else if(array[index].key == key)
            array[index] = null;
        else{
            int p = index + 1;
            while(p != index){
                if(array[p].key == key)
                    array[p] = null;
                p = (p + 1) % capacity;
            }
        }
    }
    public int size(){
        int count = 0;
        for(int i = 0; i < capacity;i++){
            if(array[i] != null)
                count++;
        }
        return count;
    }
    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
