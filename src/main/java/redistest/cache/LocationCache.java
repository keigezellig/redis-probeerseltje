package redistest.cache;

import redistest.dataobjects.GeoPoint;

import javax.annotation.PostConstruct;

public class LocationCache extends BaseCache<GeoPoint, String> {

    public LocationCache(CacheProvider cacheProvider) {
        super(cacheProvider);
    }

    @PostConstruct
    public void init() {
        this.expirationTime = 2000;
    }


}
