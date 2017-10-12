package top.xyloto.blackbox.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.xyloto.blackbox.constant.RedisKey;
import top.xyloto.blackbox.redis.RedisClient;
import top.xyloto.blackbox.util.TimeUtil;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zhaocong05
 * @createTime 2017-09-18
 * @description SmokerService
 */
@Service
public class SmokerService {


    @Autowired
    private RedisClient redisClient;


    private Set<String> history(long min, long max) {
        return redisClient.zrangeByScore(RedisKey.SMOKER, min, max);
    }

    public void addOne() {
        long score = System.currentTimeMillis();
        redisClient.zadd(RedisKey.SMOKER, score, String.valueOf(score));
    }

    public List<String> history() {
        Set<String> result = this.history(get24hAgo(), System.currentTimeMillis());
        if (CollectionUtils.isEmpty(result))
            return Collections.EMPTY_LIST;

        List<String> _result = new ArrayList<String>(result);
        Collections.sort(_result, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (int) (Long.valueOf(o2) - Long.valueOf(o1));
            }
        });

        List<String> __result = new ArrayList<String>();
        for (String s : _result) {
            __result.add(TimeUtil.formatTime(s));
        }
        return __result;
    }

    private static long get24hAgo() {
        return System.currentTimeMillis() - TimeUtil.OneDay;
    }


}
