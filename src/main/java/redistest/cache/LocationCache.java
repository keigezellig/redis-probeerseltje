package redistest.cache;

import redistest.dataobjects.GeoPoint;

public class LocationCache extends BaseCache<GeoPoint, String> {

    public LocationCache(CacheProvider cacheProvider, int expirationTime) {
        super(cacheProvider, expirationTime);
    }

}
