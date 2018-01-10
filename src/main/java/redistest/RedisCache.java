package redistest;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.text.DecimalFormat;

public class RedisCache implements Cache {

    private int expirationTime;
    private int accuracy;
    private RedisClient redisClient;


    @PostConstruct
    public void init() {
        System.out.println("Init");
        RedisURI redisUri = RedisURI.Builder.redis("localhost")
                .build();
        redisClient = RedisClient.create(redisUri);
        this.expirationTime = 600;
        this.accuracy = 5;
    }
    @Override
    public String get(double value) {
        String result;
        System.out.println("Getting cache contnet for value: "+value);
        String key = getKey(value);

        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisCommands<String, String> syncCommands = connection.sync();
            result = syncCommands.get(key);
        }
        return result;
    }

    private String getKey(double value) {
        DecimalFormat df = getDecimalFormat();
        return df.format(value);
    }

    private DecimalFormat getDecimalFormat() {
        String formatString = "#.";
        for (int i=0; i < this.accuracy; i++) {
            formatString += "#";
        }
        return new DecimalFormat(formatString);
    }

    @Override
    public void put(double value, String text) {
        String key = getKey(value);
        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisCommands<String, String> syncCommands = connection.sync();
            syncCommands.setex(key, expirationTime, text);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
        redisClient.shutdown();
    }
}
