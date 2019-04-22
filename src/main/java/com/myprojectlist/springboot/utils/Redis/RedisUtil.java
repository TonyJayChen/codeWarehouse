package com.myprojectlist.springboot.utils.Redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class RedisUtil {
    /**
     * redis实体
     */
    private Jedis jedis=RedisConnection.getJedis();

    /**
     * 连接redis服务器
     */
    public void connectRedis() {
        jedis=RedisConnection.getJedis();
    }

    /**
     * 添加数据到redis
     * @param key
     * @param val
     */
    public void set(String key,String val) {
        jedis.set(key,val);
    }

    /**
     * 拼接字符串
     * @param key
     * @param val
     */
    public void append(String key,String val) {
        jedis.append(key,val);
    }

    /**
     * 删除redis数据
     * @param key
     */
    public void del(String key) {
        jedis.del(key);
    }

    /**
     * redis添加MAP
     * @param key
     * @param map
     */
    public void redisMap(String key,Map<String,String> map){
        jedis.hmset(key,map);
    }

    /**
     *  redis添加List
     * @param key 指的要用list中哪个数据字段作为key来标识
     * @param list
     */
    public void redisList(String key,List<Map<String,String>> list){
        for(int i = 0; list.size() > i ; i++){
            redisMap(key,list.get(i));
        }

    }

    /**
     * 删除redis中的List
     * @param key  指的要用list中哪个数据字段作为key来标识
     * @param list
     */
    public void delList(String key,List<Map<String,String>> list){
        for(int i = 0; list.size() > i ; i++){
            del(list.get(i).get(key));
        }
    }

    public static void main(String[] args) {
        RedisUtil redis = new RedisUtil();
        redis.set("name","政务");
    }
}
