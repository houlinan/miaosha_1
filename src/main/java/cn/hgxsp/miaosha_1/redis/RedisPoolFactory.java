package cn.hgxsp.miaosha_1.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * DESC：配置redis链接参数
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 11:19
 */
@Service
public class RedisPoolFactory {

    @Autowired
    RedisConfig redisConfig;

    /**
     *DESC:配置redis链接参数
     *@author hou.linan
     *@date:  2018/9/26 11:16
     *@param:  []
     *@return:  redis.clients.jedis.JedisPool
     */
    @Bean
    public JedisPool JedisFactory() {
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(redisConfig.getPoolMaxIdle());
        poolConfig.setMaxTotal(redisConfig.getPoolMaxTotal());
        poolConfig.setMaxWaitMillis(redisConfig.getPoolMaxWait() * 1000);
        JedisPool jp = new JedisPool(poolConfig, redisConfig.getHost(),
                redisConfig.getPort(), redisConfig.getTimeout() * 1000, redisConfig.getPassword(), redisConfig.getDatabase(), "miaosha1");

        return jp;

    }

}
