package WePay;

public class MyHashtable<K, V> {
    public static void main(String args[]) throws Exception {
        MyHashtable<String, String> map = new MyHashtable<String, String>();
        map.put("1", "one");
        map.put("1", "onee");
        System.out.println(map.get("2"));
    }

    private final int HASH_TABLE_SIZE = 256;
    private HashNode<K, V>[] table;

    public MyHashtable() {
        table = new HashNode[HASH_TABLE_SIZE];
    }

    public void put(K key, V value) {
        int hash = hash(key);
        if (table[hash] == null)
            table[hash] = new HashNode<K, V>(key, value);
        else {
            HashNode<K, V> entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new HashNode<K, V>(key, value);
        }
    }

    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null)
            return null;
        else {
            HashNode<K, V> entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;

            if (entry.key.equals(key))
                return entry.value;
            else
                return null;
        }
    }

    private int hash(K key) {
        return key.hashCode() % HASH_TABLE_SIZE;
    }

    class HashNode<K, V> {
        K key;
        V value;
        HashNode<K, V> next;

        HashNode(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }
}