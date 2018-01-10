package redistest;


public interface Cache {
    String get(double value);
    void put(double value, String text);
}

