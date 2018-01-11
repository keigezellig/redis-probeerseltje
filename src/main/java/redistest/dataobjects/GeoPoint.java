package redistest.dataobjects;

import java.text.DecimalFormat;

public class GeoPoint {
    private static final int ACCURACY = 4;
    private double lat;
    private double lon;

    public GeoPoint(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    public double getLat() {
        return lat;
    }
    public double getLon() {
        return lon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GeoPoint geoPoint = (GeoPoint) o;

        if (Double.compare(geoPoint.lat, lat) != 0) return false;
        return Double.compare(geoPoint.lon, lon) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lat);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lon);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        DecimalFormat df = getDecimalFormat();

        String lat = df.format(this.getLat());
        String lon = df.format(this.getLon());
        return String.format("%s,%s", lat, lon);
    }

    private DecimalFormat getDecimalFormat() {
        String formatString = "#.";
        for (int i = 0; i < ACCURACY; i++) {
            formatString += "#";
        }
        return new DecimalFormat(formatString);
    }
}
