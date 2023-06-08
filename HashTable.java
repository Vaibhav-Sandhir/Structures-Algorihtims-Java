import java.util.*;
public class HashTable {
    private class Entry{
        private int key;
        private String value;

        public Entry(int key,String value){
            this.key = key;
            this.value = value;
        }
    }
    private int size;
    private LinkedList<Entry>[] list;

    public HashTable(int size){
        this.size = size;
        list = new LinkedList[size];
    }
    public void put(int key, String value){
        int index = hash(key);
        if(list[index] == null)
            list[index] = new LinkedList<>();

        for(var entry: list[index]){
            if(entry.key == key){
                entry.value = value;
                return;
            }
        }
        list[index].addLast(new Entry(key,value));
    }

    public String get(int key){
        int index = hash(key);
        if(list[index] != null){
            for(var entry : list[index]){
                if(entry.key == key)
                    return entry.value;
            }
        }
        return null;
    }

    public void remove(int key){
        int index = hash(key);
        if(list[index] == null)
            throw new IllegalStateException();
        else{
            for(var entry: list[index]){
                if(entry.key == key) {
                    list[index].remove(entry);
                    return;
                }
            }
        }
    }
    private int hash(int key){
        return key % size;
    }
}
