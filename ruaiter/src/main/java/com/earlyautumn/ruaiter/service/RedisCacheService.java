package com.earlyautumn.ruaiter.service;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public interface RedisCacheService {

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
     * key
     *
     * @param key key
     */
    void delete(String key);

    /**
     * String
     *
     * @param key   key
     * @param value value
     */
    void set(String key, String value);

    /**
     * String
     *
     * @param key key
     * @return value
     */
    String get(String key);

    /**
     * String
     *
     * @param key    key
     * @param second expire 过期时间
     * @param value  value
     */
    void setWithExpire(String key, Integer second, String value);

    /**
     * String
     *
     * @param key   key
     * @param start 起始位置
     * @param value 从起始位置开始设值
     */
    void setRange(String key, Integer start, String value);

}
