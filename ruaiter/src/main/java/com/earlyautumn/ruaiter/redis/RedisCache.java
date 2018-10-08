package com.earlyautumn.ruaiter.redis;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisCache {

    /**
     * set expire time for key
     *
     * @param key key
     */
    void setExpire(String key, Integer time, TimeUnit timeUnit);

    /**
     * pattern to get keys
     *
     * @param pattern key pattern
     * @return keys
     */
    Set<String> keys(String pattern);

    /**
     * delete key
     *
     * @param key key
     */
    void delete(String key);

    /**
     * set key and value
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * get value by key
     *
     * @param key key
     * @return value
     */
    String get(String key);

    /**
     * set key,value with expire time
     *
     * @param key    key
     * @param second expire 过期时间
     * @param value  value
     */
    void setWithExpire(String key, Integer second, String value);

    /**
     * update string from start index
     *
     * @param key   key
     * @param start 起始位置
     * @param value 从起始位置开始设值
     */
    void setRange(String key, Integer start, String value);

}
