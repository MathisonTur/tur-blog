package com.blog.service.intf;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/31 20:02
 * @description redis封装工具
 */
public interface RedisService {

    /**
     * @author tur
     * @date 2023/3/31 20:04
     * @description 缓存基本对象，Integer、String、实体类等
     * @param key 缓存的键
     * @param value 缓存的值
     */
    void setCacheObject(String key, Object value);

    /**
     * @author tur
     * @date 2023/3/31 22:34
     * @description 缓存基本对象，Integer、String、实体类等
     * @param key 缓存键
     * @param value 缓存值
     * @param timeout 时间
     * @param timeUnit 时间粒度
     */
    void setCacheObject(String key, Object value, Integer timeout, TimeUnit timeUnit);

    /**
     * @author tur
     * @date 2023/3/31 22:36
     * @description 设置有效时间
     * @param key redis键
     * @param timeout 超时时间
     * @param timeUnit 时间单位
     * @return boolean
    */
    boolean expire(String key, long timeout, TimeUnit timeUnit);

    /**
     * @author tur
     * @date 2023/3/31 22:36
     * @description 获取缓存的基本对象
     * @param key 缓存键
     * @return java.lang.Object
    */
    Object getCacheObject(String key);

    /**
     * @author tur
     * @date 2023/3/31 22:37
     * @description 删除单个对象
     * @param key 缓存键
     * @return boolean
    */
    boolean deleteObject(final String key);

    /**
     * @author tur
     * @date 2023/3/31 22:38
     * @description 缓存List数据
     * @param key 键
     * @param dataList 待缓存的List数据
     * @return long
    */
    long setCacheList(String key, List<Object> dataList);

    /**
     * @author tur
     * @date 2023/3/31 22:39
     * @description 获取缓存的list对象
     * @param key 键
     * @return java.util.List<java.lang.Object>
    */
    List<Object> getCacheList(final String key);

    /**
     * @author tur
     * @date 2023/3/31 22:40
     * @description 缓存Map
     * @param key 键
     * @param dataMap 值
     * @return void
    */
    void setCacheMap(String key, Map<String, Object> dataMap);

    /**
     * @param key 键
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author tur
     * @date 2023/3/31 22:40
     * @description 获取缓存的Map
     */
    Map<String, Object> getCacheMap(final String key);

    /**
     * @param key1 键1
     * @param key2 键2
     * @return java.util.Set<java.lang.String>
     * @author tur
     * @date 2023/3/31 22:42
     * @description 返回集合key1中存在，但集合key2中不存在的数据结合
     */
    Set<Object> diff(String key1, String key2);

    /**
     * @author tur
     * @date 2023/3/31 22:43
     * @description 判断键值是否存在
     * @param key 键
     * @param value 键
     * @return java.lang.Boolean
    */
    Boolean sIsMember(String key, Object value);

    /**
     * @author tur
     * @date 2023/3/31 22:45
     * @description 键的值相加指定数量
     * @param key 键
     * @param hashKey 键值
     * @param delta 数量
     * @return java.lang.Long
    */
    Long hIncr(String key, String hashKey, Long delta);

    /**
     * @author tur
     * @date 2023/3/31 22:47
     * @description 键的值相减指定数量
     * @param key 键
     * @param hashKey 键值
     * @param delta 数量
     * @return java.lang.Long
    */
    Long hDecr(String key, String hashKey, Long delta);

    /**
     * @author tur
     * @date 2023/3/31 22:48
     * @description 获取指定键的集合
     * @param key 键
     * @return java.util.Set<java.lang.Object>
    */
    Set<Object> sMembers(String key);

    /**
     * @author tur
     * @date 2023/3/31 22:48
     * @description 移除多个值
     * @param key 键
     * @param values 键
     * @return java.lang.Long
    */
    Long sRemove(String key, Object... values);

    /**
     * @author tur
     * @date 2023/3/31 22:49
     * @description 获取对象
     * @param key 键
     * @param hashKey 键值
     * @return java.lang.Object
    */
    Object hGet(String key, String hashKey);

    /**
     * @author tur
     * @date 2023/3/31 22:50
     * @description 键增加指定数量
     * @param key 键
     * @param delta 数量
     * @return java.lang.Long
    */
    Long incr(String key, long delta);

    /**
     * @author tur
     * @date 2023/3/31 22:53
     * @description 为键添加多个值
     * @param key 键
     * @param values 值
     * @return java.lang.Long
    */
    Long sAdd(String key, Object... values);

    RedisTemplate getRedisTemplate();
}
