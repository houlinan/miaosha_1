package cn.hgxsp.miaosha_1.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


/**
 * DESC：rabbitMq Bean配置文件
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/22
 * Time : 17:08
 */
@Component
public class MQConfig {

    //消息队列的名字
    public static final String QUEUENAME = "queue" ;

    /**
    *DESC: 创建消息队列
    *@author hou.linan
    *@date:  2018/10/22 17:10
    *@param:  []
    *@return:  org.springframework.amqp.core.Queue
    */
    @Bean
    public Queue queue(){
        return new Queue(QUEUENAME ,true) ;
    }

}
