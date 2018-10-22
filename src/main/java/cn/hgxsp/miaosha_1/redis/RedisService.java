package cn.hgxsp.miaosha_1.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * DESC：redis服务类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 18:28
 */
@Service
public class RedisService {

    @Autowired
    JedisPool jedisPool;



    /**
    *DESC:      get!
    *@author hou.linan
    *@date:  2018/9/26 10:56
    *@param:  [key, clazz]
    *@return:  T
    */
    public <T> T get(KeyPrefix keyPrefix ,String key, Class<T> clazz) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis = jedisPool.getResource();
            //生成真正的key
            String realKey = keyPrefix.getPrefix() + key ;
            String strValue = jedis.get(realKey);
            T t = stringToBean(strValue, clazz);
            return t;

        } finally {
            returnToPoll(jedis);
        }
    }
    /**
     *DESC:      set!
     *@author hou.linan
     *@date:  2018/9/26 10:56
     *@param:  [key, clazz]
     *@return:  T
     */
    public <T> boolean set(KeyPrefix keyPrefix ,String key, T value) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis = jedisPool.getResource();

            String strValue = beanToString(value) ;
            if(StringUtils.isEmpty(strValue)) return false ;
            //生成真正的key
            String realKey = keyPrefix.getPrefix() + key ;
            int expireSecondS = keyPrefix.expireSecondS();
            if(expireSecondS > 0 ){
                jedis.setex(realKey , expireSecondS , strValue);
                return true ;
            }
            jedis.set(realKey , strValue);
            return true;

        } finally {
            returnToPoll(jedis);
        }
    }

    /**
    *DESC: 判断Key是否存在
    *@author hou.linan
    *@date:  2018/9/26 16:25
    *@param:  [keyPrefix, key]
    *@return:  boolean
    */
    public <T> boolean exists(KeyPrefix keyPrefix ,String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key ;
            return  jedis.exists(realKey) ;

        } finally {
            returnToPoll(jedis);
        }
    }

    /**
    *DESC: 增加值
    *@author hou.linan
    *@date:  2018/9/26 16:26
    *@param:  [keyPrefix, key]
    *@return:  java.lang.Long
    */
    public <T> Long incr(KeyPrefix keyPrefix ,String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key ;
            return  jedis.incr(realKey) ;
        } finally {
            returnToPoll(jedis);
        }
    }

    /**
    *DESC: 减少值
    *@author hou.linan
    *@date:  2018/9/26 16:27
    *@param:  [keyPrefix, key]
    *@return:  java.lang.Long
    */
    public <T> Long decr(KeyPrefix keyPrefix ,String key) {
        Jedis jedis = jedisPool.getResource();
        try {
            jedis = jedisPool.getResource();
            String realKey = keyPrefix.getPrefix() + key ;
            return  jedis.decr(realKey) ;
        } finally {
            returnToPoll(jedis);
        }
    }

    /**
    *DESC: 将对象类型转成JSon数据
    *@author hou.linan
    *@date:  2018/9/26 11:15
    *@param:  [value]
    *@return:  java.lang.String
    */
    public static  <T> String beanToString(T value) {
        if(value == null ) return null ;
        Class<?> aClass = value.getClass();
        if(aClass == int.class || aClass == Integer.class) return "" + value ;
        if(aClass == String.class)  return (String)value;
        if(aClass == long.class || aClass == Long.class) return "" + value ;

        return JSON.toJSONString(value);
    }


    /**
    *DESC: returnToPoll
    *@author hou.linan
    *@date:  2018/9/26 11:15
    *@param:  [jedis]
    *@return:  void
    */
    private void returnToPoll(Jedis jedis) {
        if (jedis != null) jedis.close();
    }


    /**
    *DESC: 将String数据转成对象类型
    *@author hou.linan
    *@date:  2018/9/26 11:14
    *@param:  [strValue, clazz]
    *@return:  T
    */
    public static  <T> T stringToBean(String strValue , Class<T> clazz){

        if(StringUtils.isEmpty(strValue) || StringUtils.isEmpty(clazz)) return null ;
        if(clazz == int.class || clazz == Integer.class) return (T)Integer.valueOf(strValue) ;
        if(clazz == String.class )  return (T)strValue ;
        if(clazz == long.class || clazz == Long.class)  return (T)Long.valueOf(strValue);

        return JSON.toJavaObject(JSON.parseObject(strValue) , clazz ) ;
    }



}
