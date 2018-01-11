package redistest.cache;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class RedisCacheProvider implements CacheProvider {

    private RedisClient redisClient;

    @PostConstruct
    public void init() {
        System.out.println("Init");
        RedisURI redisUri = RedisURI.Builder.redis("localhost") //todo: config
                .build();
        redisClient = RedisClient.create(redisUri);
    }
    @Override
    public String get(String key) {
        String result;
        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisCommands<String, String> syncCommands = connection.sync();
            result = syncCommands.get(key);
        }
        return result;
    }

    @Override
    public void put(String key, String value, int expirationTime) {
        try (StatefulRedisConnection<String, String> connection = redisClient.connect()) {
            RedisCommands<String, String> syncCommands = connection.sync();
            syncCommands.setex(key, expirationTime, value);
        }
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroy");
        redisClient.shutdown();
    }


}
