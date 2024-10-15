import java.util.LinkedList;
import java.util.Map;

public class HashTable<K, V> {
    private final int[] sizes = new int[]{5, 10, 20, 40, 80, 160, 320, 640, 1280, 2560, 5120, 10240};
    private int sizes_index = 0;
    private static final float LOAD = 0.7f;
    private LinkedList<Entry<K, V>>[] table;
    private int size;

    public HashTable() {
        table = new LinkedList[sizes[sizes_index]];
        size = 0;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % sizes[sizes_index];
    }

    public void put(K key, V value) {
        if ((float) size / table.length >= LOAD) {
            resize();
        }
        int index = hash(key);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }
        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }
        table[index].add(new Entry<>(key, value));
        size++;
    }

    private void resize() {
        LinkedList<Entry<K, V>>[] newTable = new LinkedList[sizes[++sizes_index]];

        for (LinkedList<Entry<K, V>> s : table) {
            if (s != null) {
                for (Entry<K, V> entry : s) {
                    int newIndex = hash(entry.getKey());
                    if (newTable[newIndex] == null) {
                        newTable[newIndex] = new LinkedList<>();
                    }
                    newTable[newIndex].add(entry);
                }
            }
        }

        table = newTable;
    }

    public V get(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return sizes[sizes_index];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class Entry<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        this.value = value;
        return value;
    }
}