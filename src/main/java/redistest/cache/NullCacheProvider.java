package redistest.cache;

public class NullCacheProvider implements CacheProvider {

    @Override
    public String get(String key) {
        System.out.println("No caching enabled");
        return null;
    }

    @Override
    public void put(String key, String value, int expirationTime) {
        System.out.println("No caching enabled");
    }

}
