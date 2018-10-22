package cn.hgxsp.miaosha_1.rabbitmq;

import cn.hgxsp.miaosha_1.redis.RedisService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC：rabbitMq的发送者
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/22
 * Time : 17:04
 */
@Service
public class MQSender {

    @Autowired
    AmqpTemplate amqpTemplate ;


    public void send(Object object){
        String msg = RedisService.beanToString(object) ;
        amqpTemplate.convertAndSend(MQConfig.DIRECTQUEUENAME , msg);
    }

}
