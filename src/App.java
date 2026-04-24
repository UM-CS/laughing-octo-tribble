import java.util.ArrayList;

class KeyValuePair<K, V>{
    K key;
    V value;

    public KeyValuePair(K key, V value){
        this.key = key;
        this.value = value;
    }
}

class HashTable<K, V>{
    private ArrayList<KeyValuePair<K,V>>[] table;

    public HashTable(int capacity){
        table = new ArrayList[capacity];

        for(int i = 0; i < capacity; i++){
            table[i] = new ArrayList<>();
        }
    }

    private int hash(K key){
        return key.hashCode() % table.length;
    }

    public void put(K key, V value){
        int index = hash(key);
        table[index].add(new KeyValuePair(key, value));
    }

    public V get(K key){
        int index = hash(key);
        for(KeyValuePair<K, V> pair: table[index]){
            if(pair.key.equals(key)){
                return pair.value;
            }
        }
        return null;
    }
}

public class App {
    // public static void main(String[] args) {
    //     HashTable<String, Integer> hashTable = new HashTable(20);
    //     hashTable.put("Alice", 25);
    //     hashTable.put("Bob", 30);
    //     hashTable.put("Sam", 25);
    //     hashTable.put("Han", 30);
    //     hashTable.put("Alex", 25);
    //     hashTable.put("Tom", 30);
    //     System.out.println(hashTable.get("Alice"));
    // }
}
