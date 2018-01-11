package redistest;

import redistest.cache.Cache;
import redistest.dataobjects.GeoPoint;
import redistest.dataprovider.LocationProvider;


public class LocationServiceImpl implements LocationService {
    private Cache cache;
    private LocationProvider locationProvider;

    public LocationServiceImpl(Cache cache, LocationProvider locationProvider) {
        this.cache = cache;
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
