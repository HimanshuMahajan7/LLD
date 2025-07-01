package src;

public class HashMap<K, V> {
    private static final int INITIAL_CAPACITY = 1 << 4; // aka 16
    private static final float MAXIMUM_CAPACITY = 1 << 30;

    public Entry<K, V>[] hashTable;

    public HashMap() {
        hashTable = new Entry[INITIAL_CAPACITY];
    }

    public HashMap(int capacity) {
        int tableSize = tableSize(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSize(int capacity) {
        int n = capacity - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (int) ((n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);
    }

    public void put(K key, V value) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];
        if (node == null) {
            Entry<K, V> newNode = new Entry<>(key, value);
            hashTable[hashCode] = newNode;
        } else {
            Entry<K, V> prevoiusNode = node;
            while (node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                }
                prevoiusNode = node;
                node = node.next;
            }
            Entry<K, V> newNode = new Entry(key, value);
            prevoiusNode.next = newNode;
        }
    }

    public V get(K key) {
        int hashCode = key.hashCode() % hashTable.length;
        Entry<K, V> node = hashTable[hashCode];
        while (node != null) {
            if (node.key.equals(key)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }

    class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
