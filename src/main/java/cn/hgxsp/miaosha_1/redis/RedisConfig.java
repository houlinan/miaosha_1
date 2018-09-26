package cn.hgxsp.miaosha_1.redis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * DESC：redis配置类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 18:00
 */
@Component
@ConfigurationProperties(prefix = "redis")
@Data
public class RedisConfig {
    private String host;
    private int port;
    private String password;
    private int timeout ;
    private int poolMaxTotal;
    private int poolMaxIdle;
    private int poolMaxWait;

}
