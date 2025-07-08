import java.util.*;

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private final int capacity;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(2);
        lru.put(1, 1); // cache: {1=1}
        lru.put(2, 2); // cache: {1=1, 2=2}
        System.out.println(lru.get(1)); // returns 1
        lru.put(3, 3); // evicts key 2 → cache: {1=1, 3=3}
        System.out.println(lru.get(2)); // returns -1
        lru.put(4, 4); // evicts key 1 → cache: {4=4, 3=3}
        System.out.println(lru.get(1)); // returns -1
        System.out.println(lru.get(3)); // returns 3
        System.out.println(lru.get(4)); // returns 4
    }
}
