package redistest.cache;

import java.text.DecimalFormat;

public class DoubleCache extends BaseCache<Double, String> {

    private int accuracy;

    public DoubleCache(CacheProvider cacheProvider, int expirationTime) {
        super(cacheProvider, expirationTime);
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
