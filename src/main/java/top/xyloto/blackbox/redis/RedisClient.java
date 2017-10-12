package top.xyloto.blackbox.redis;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Set;
import java.util.jar.JarEntry;

/**
 * @author zhaocong05
 * @createTime 2017-09-18
 * @description RedisClient
 */
@Service
public class RedisClient {

    private static final String host = "127.0.0.1";
    private static final int port = 6379;

    public void zadd(String key, double score, String member) {
        Jedis jedis = new Jedis(host, port);
        jedis.zadd(key, score, member);
        jedis.close();
    }

    public Set<String> zrangeByScore(String key, double min, double max) {
        Jedis jedis = new Jedis(host, port);
        Set<String> result = jedis.zrangeByScore(key, min, max);
        jedis.close();
        return result;
    }

}
