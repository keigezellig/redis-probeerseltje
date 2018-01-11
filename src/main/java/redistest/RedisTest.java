package redistest;

import redistest.cache.DoubleCache;
import redistest.cache.LocationCache;
import redistest.cache.NullCacheProvider;
import redistest.cache.RedisCacheProvider;
import redistest.dataobjects.GeoPoint;
import redistest.dataprovider.DescriptionProvider;
import redistest.dataprovider.LocationProvider;

public class RedisTest {

    public static void main(String[] args) {

        RedisCacheProvider redisCacheProvider = new RedisCacheProvider();
        NullCacheProvider nullCacheProvider = new NullCacheProvider();
        redisCacheProvider.init();

        DoubleCache cache = new DoubleCache(nullCacheProvider);
        LocationCache locationCache = new LocationCache(redisCacheProvider);
        locationCache.init();
        cache.init();

        NumberDescriptor n = new NumberDescriptorImpl(new DescriptionProvider());
        System.out.println(n.getDescriptionForNumber(1.33123));
        System.out.println(n.getDescriptionForNumber(1.33123));
        System.out.println(n.getDescriptionForNumber(1.33123));
        System.out.println(n.getDescriptionForNumber(1.33124));
        System.out.println(n.getDescriptionForNumber(1.33125));
        System.out.println(n.getDescriptionForNumber(1.33125));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(n.getDescriptionForNumber(1.33125));


        LocationService locationService = new LocationServiceImpl(new LocationProvider());
        System.out.println(locationService.getLocation(new GeoPoint(52.23423432,8)));
        System.out.println(locationService.getLocation(new GeoPoint(52.23456722,8)));
        System.out.println(locationService.getLocation(new GeoPoint(52.23456733,8)));
        System.out.println(locationService.getLocation(new GeoPoint(54,8)));
        System.out.println(locationService.getLocation(new GeoPoint(55,6)));


        redisCacheProvider.destroy();


    }
}
