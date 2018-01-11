package redistest.cache;


public interface CacheProvider {
    String get(String key);
    void put(String key, String value, int expirationTime);

}
