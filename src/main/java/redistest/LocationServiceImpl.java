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
        if (location != null) {
            System.out.println(String.format("Cache hit for %s", coordinates));
        }
        else {
            System.out.println(String.format("Cache miss for %s", coordinates));
            location = locationProvider.getLocationForLatLon(coordinates.getLat(), coordinates.getLon());
            cache.put(coordinates, location);
        }

        return location;
    }

    /*private Cache cache;
    private DescriptionProvider descriptionProvider;

    public NumberDescriptorImpl(Cache cache, DescriptionProvider descriptionProvider) {
        this.cache = cache;
        this.descriptionProvider = descriptionProvider;
    }

    @Override
    public String getDescriptionForNumber(double number) {
        String description = cache.get(number);
        if (description != null) {
            System.out.println(String.format("Cache hit for %s", number));
        }
        else {
            System.out.println(String.format("Cache miss for %s", number));
            description = descriptionProvider.getDescriptionForNumber(number);
            cache.put(number, description);
        }

        return description;
    }*/
}
