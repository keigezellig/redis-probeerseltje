package redistest;

import redistest.cache.Cache;
import redistest.cache.CacheFactory;
import redistest.dataobjects.GeoPoint;
import redistest.dataprovider.LocationProvider;


public class LocationServiceImpl implements LocationService {
    private Cache<GeoPoint, String> cache;
    private LocationProvider locationProvider;

    public LocationServiceImpl(LocationProvider locationProvider) {
        this.cache = CacheFactory.locationCache();
        this.locationProvider = locationProvider;
    }

    @Override
    public String getLocation(GeoPoint coordinates) {
        String location = cache.get(coordinates);
        if (location == null) {
            location = locationProvider.getLocationForLatLon(coordinates.getLat(), coordinates.getLon());
            cache.put(coordinates, location);
        }
        return location;
    }


}
