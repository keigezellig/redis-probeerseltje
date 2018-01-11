package redistest;

import redistest.dataobjects.GeoPoint;


public interface LocationService {
    String getLocation(GeoPoint coordinates);
}
