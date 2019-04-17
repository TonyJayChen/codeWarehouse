package redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class redisTest {

    private JedisPool jedisPool;//非切片连接池
    Jedis jedis ;
    @Test
    public void tset0(){
        System.out.println("test ok");
        //连接本地的 Redis 服务
        JedisPoolConfig config = new JedisPoolConfig();
        //这里可以配置很多jedisPoolConfig的参数   
        config.setMaxIdle(5);
        config.setTestOnBorrow(false);

        //开启线程池
        jedisPool = new JedisPool(config,"127.0.0.1",6379,3000,"123456");

        //开启一个连接
        jedis = jedisPool.getResource();
        System.out.println("连接成功");

        //删除redis的缓存
        jedis.flushAll();
        //set
        jedis.set("key","hello");
        //get
        System.out.println(jedis.get("key"));

    }
}
