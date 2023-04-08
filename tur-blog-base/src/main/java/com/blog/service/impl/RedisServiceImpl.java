package com.blog.service.impl;

import com.blog.service.intf.RedisService;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author tur
 * @version 1.0
 * @date 2023/3/31 22:54
 * @description Redis操作封装
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    RedisTemplate redisTemplate;

    /**
     * @param key   缓存的键
     * @param value 缓存的值
     * @author tur
     * @date 2023/3/31 20:04
     * @description 缓存基本对象，Integer、String、实体类等
     */
    @Override
    public void setCacheObject(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * @param key      缓存键
     * @param value    缓存值
     * @param timeout  时间
     * @param timeUnit 时间粒度
     * @author tur
     * @date 2023/3/31 22:34
     * @description 缓存基本对象，Integer、String、实体类等
     */
    @Override
    public void setCacheObject(String key, Object value, Integer timeout, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, value, timeout, timeUnit);
    }

    /**
     * @param key      redis键
     * @param timeout  超时时间
     * @param timeUnit 时间单位
     * @return boolean
     * @author tur
     * @date 2023/3/31 22:36
     * @description 设置有效时间
     */
    @Override
    public boolean expire(String key, long timeout, TimeUnit timeUnit) {
        return Boolean.TRUE.equals(redisTemplate.expire(key, timeout, timeUnit));
    }

    /**
     * @param key 缓存键
     * @return java.lang.Object
     * @author tur
     * @date 2023/3/31 22:36
     * @description 获取缓存的基本对象
     */
    @Override
    public Object getCacheObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * @param key 缓存键
     * @return boolean
     * @author tur
     * @date 2023/3/31 22:37
     * @description 删除单个对象
     */
    @Override
    public boolean deleteObject(String key) {
        return Boolean.TRUE.equals(redisTemplate.delete(key));
    }

    /**
     * @author tur
     * @date 2023/3/31 23:03
     * @description 删除集合对象
     * @param collection 对个对象
     * @return long
    */
    public long deleteObject(Collection<String> collection){
        return redisTemplate.delete(collection);
    }

    /**
     * @param key      键
     * @param dataList 待缓存的List数据
     * @return long
     * @author tur
     * @date 2023/3/31 22:38
     * @description 缓存List数据
     */
    @Override
    public long setCacheList(String key, List<Object> dataList) {
        Long count = redisTemplate.opsForList().rightPushAll(key, dataList);
        return count == null ? 0 : count;
    }

    /**
     * @param key 键
     * @return java.util.List<java.lang.Object>
     * @author tur
     * @date 2023/3/31 22:39
     * @description 获取缓存的list对象
     */
    @Override
    public List<Object> getCacheList(String key) {
        return redisTemplate.opsForList().range(key, 0, -1);
    }

    /**
     * @param key     键
     * @param dataMap 值
     * @return void
     * @author tur
     * @date 2023/3/31 22:40
     * @description 缓存Map
     */
    @Override
    public void setCacheMap(String key, Map<String, Object> dataMap) {
        if (dataMap != null){
            redisTemplate.opsForHash().putAll(key, dataMap);
        }
    }

    /**
     * @param key 键
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @author tur
     * @date 2023/3/31 22:40
     * @description 获取缓存的Map
     */
    @Override
    public Map<String, Object> getCacheMap(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * @author tur
     * @date 2023/3/31 23:06
     * @description 往Hash中存入数据
     * @param key redis键
     * @param hKey hash键
     * @param value 值
     * @return void
    */
    public <T> void setCacheMapValue(String key, String hKey, T value){
        redisTemplate.opsForHash().put(key, hKey, value);
    }

    /**
     * @author tur
     * @date 2023/3/31 23:06
     * @description 往Hash中存入数据
     * @param key redis键
     * @param hKey hash键
     * @return void
     */
    public <T> T getCacheMapValue(String key, String hKey){
        HashOperations<String, String, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.get(key, hKey);
    }

    /**
     * @author tur
     * @date 2023/3/31 23:12
     * @description 获取多个Hash中的数据
     * @param key redis键
     * @param hKeys hash键集合
     * @return java.util.List<T>
    */
    public <T> List<T> getMultiCacheMapValue(String key, Collection<Object> hKeys){
        HashOperations<String, Object, T> opsForHash = redisTemplate.opsForHash();
        return opsForHash.multiGet(key, hKeys);
    }

    /**
     * @author tur
     * @date 2023/3/31 23:13
     * @description 获取缓存的基本对象列表
     * @param pattern 字符串前缀
     * @return java.util.Collection<java.lang.String>
    */
    public Collection<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * @param key1 键1
     * @param key2 键2
     * @return java.util.Set<java.lang.String>
     * @author tur
     * @date 2023/3/31 22:42
     * @description 返回集合key1中存在，但集合key2中不存在的数据结合
     */
    @Override
    public Set<Object> diff(String key1, String key2) {
        return redisTemplate.opsForSet().difference(key1, key2);
    }

    /**
     * @param key   键
     * @param value 键
     * @return java.lang.Boolean
     * @author tur
     * @date 2023/3/31 22:43
     * @description 判断键值是否存在
     */
    @Override
    public Boolean sIsMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * @param key     键
     * @param hashKey 键值
     * @param delta   数量
     * @return java.lang.Long
     * @author tur
     * @date 2023/3/31 22:45
     * @description 键的值相加指定数量
     */
    @Override
    public Long hIncr(String key, String hashKey, Long delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, delta);
    }

    /**
     * @param key     键
     * @param hashKey 键值
     * @param delta   数量
     * @return java.lang.Long
     * @author tur
     * @date 2023/3/31 22:47
     * @description 键的值相减指定数量
     */
    @Override
    public Long hDecr(String key, String hashKey, Long delta) {
        return redisTemplate.opsForHash().increment(key, hashKey, -delta);
    }

    /**
     * @param key 键
     * @return java.util.Set<java.lang.Object>
     * @author tur
     * @date 2023/3/31 22:48
     * @description 获取指定键的集合
     */
    @Override
    public Set<Object> sMembers(String key) {
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * @param key    键
     * @param values 键
     * @return java.lang.Long
     * @author tur
     * @date 2023/3/31 22:48
     * @description 移除多个值
     */
    @Override
    public Long sRemove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * @param key     键
     * @param hashKey 键值
     * @return java.lang.Object
     * @author tur
     * @date 2023/3/31 22:49
     * @description 获取对象
     */
    @Override
    public Object hGet(String key, String hashKey) {
        return redisTemplate.opsForHash().get(key, hashKey);
    }

    /**
     * @param key   键
     * @param delta 数量
     * @return java.lang.Long
     * @author tur
     * @date 2023/3/31 22:50
     * @description 键增加指定数量
     */
    @Override
    public Long incr(String key, long delta) {
        return redisTemplate.opsForValue().increment(key, delta);
    }

    /**
     * @param key   键
     * @param values 值
     * @return java.lang.Long
     * @author tur
     * @date 2023/3/31 22:53
     * @description 为键的集合添加多个值
     */
    @Override
    public Long sAdd(String key, Object... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return this.redisTemplate;
    }
}
