package cn.hgxsp.miaosha_1.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * DESC：rabbitMq的消息接受者
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/22
 * Time : 17:04
 */
@Service
@Slf4j
public class MQReceiver {


    @RabbitListener(queues = MQConfig.DIRECTQUEUENAME)
    public void receive(String msg){
      log.info("receive message = " + msg);
    }



}
