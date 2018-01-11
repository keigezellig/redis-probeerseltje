package redistest.dataprovider;

public class LocationProvider {
    public String getLocationForLatLon(double lat, double lon) {
        System.out.println("Thinking thinking..");
        System.out.println("Thinking thinking..");
        System.out.println("Thinking thinking..");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Found location....");
        return String.format("Location for (lat,lon) %f, %f", lat, lon);
    }
}
