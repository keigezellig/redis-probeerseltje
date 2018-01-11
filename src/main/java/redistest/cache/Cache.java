package redistest.cache;


public interface Cache<K, V> {
    String get(K key);
    void put(K key, V value);
}

