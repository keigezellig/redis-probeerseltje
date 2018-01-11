package redistest.cache;

import redistest.cache.BaseCache;
import redistest.cache.CacheProvider;

import javax.annotation.PostConstruct;
import java.text.DecimalFormat;

public class DoubleCache extends BaseCache<Double, String> {

    private int accuracy;

    public DoubleCache(CacheProvider cacheProvider) {
        super(cacheProvider);
    }

    @PostConstruct
    public void init() {
        this.expirationTime = 600;
        this.accuracy = 5;
    }


    private DecimalFormat getDecimalFormat() {
        String formatString = "#.";
        for (int i=0; i < this.accuracy; i++) {
            formatString += "#";
        }
        return new DecimalFormat(formatString);
    }


    @Override
    protected String convertKey(Double key) {
        DecimalFormat df = getDecimalFormat();
        return df.format(key);
    }
}
