package redistest.cache;

import redistest.dataobjects.GeoPoint;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;

public class LocationCache extends BaseCache<GeoPoint, String> {

    private int accuracy;
    public LocationCache(CacheProvider cacheProvider) {
        super(cacheProvider);
    }

    @PostConstruct
    public void init() {
        this.accuracy = 5;
        this.expirationTime = 2000;

    }
    @Override
    protected String convertKey(GeoPoint key) {
        DecimalFormat df = getDecimalFormat();

        String lat = df.format(key.getLat());
        String lon = df.format(key.getLon());
        return String.format("%s,%s",lat,lon);
    }

    private DecimalFormat getDecimalFormat() {
        String formatString = "#.";
        for (int i=0; i < this.accuracy; i++) {
            formatString += "#";
        }
        return new DecimalFormat(formatString);
    }
}
