package redistest.cache;

import redistest.dataobjects.GeoPoint;


public class CacheFactory {
    public static Cache<GeoPoint, String> locationCache() {
        LocationCache cache = new LocationCache(new NullCacheProvider());
        cache.init();
        return cache;
    }

    public static Cache<Double, String> doubleCache() {
        DoubleCache cache = new DoubleCache(new RedisCacheProvider());
        cache.init();
        return cache;
    }

}
