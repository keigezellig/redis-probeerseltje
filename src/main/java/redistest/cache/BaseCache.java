package redistest.cache;

public abstract class BaseCache<K, V> implements Cache<K,V>{

    private CacheProvider cacheProvider;
    protected int expirationTime;

    protected BaseCache(CacheProvider cacheProvider, int expirationTime) {
        this.cacheProvider = cacheProvider;
        this.expirationTime = expirationTime;
    }

    @Override
    public String get(K key) {
        System.out.println("Getting cache content for key: " + key);
        String stringkey = convertKey(key);
        return cacheProvider.get(stringkey);
    }

    @Override
    public void put(K key, V value) {
        System.out.println("Put stuff in the cache");
        String stringKey = convertKey(key);
        cacheProvider.put(stringKey,value.toString(),expirationTime);
    }

    protected String convertKey(K key) {
        return key.toString();
    }
}
