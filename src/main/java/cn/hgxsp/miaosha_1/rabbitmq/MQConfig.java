package cn.hgxsp.miaosha_1.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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

    //Direct模式 消息队列的名字
    public static final String DIRECTQUEUENAME = "directQueue" ;

    //Topic模式 消息队列的名字
    public static final String TOPICQUEUE1 = "topicQueue1" ;
    //Topic模式 消息队列的名字
    public static final String TOPICQUEUE2 = "topicQueue2" ;
    //TopicExchange
    public static final String TOPICEXCHANGE = "topicExchange" ;

    /**
    *DESC: 创建消息队列
    *@author hou.linan
    *@date:  2018/10/22 17:10
    *@param:  []
    *@return:  org.springframework.amqp.core.Queue
    */
    /**
     * Direct模式 交换机(类似中介路由)exchange 模式 就是创建一个队列，发送一个接收一个
     */
    @Bean
    public Queue queue(){
        return new Queue(DIRECTQUEUENAME ,true) ;
    }

    /**
     *Topic模式 交换机Exchange
     */
    @Bean
    public Queue topicQueue1(){
        return new Queue(TOPICQUEUE1 ,true) ;
    }
    @Bean
    public Queue topicQueue2(){
        return new Queue(TOPICQUEUE2,true) ;
    }
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange(TOPICEXCHANGE );
    }
    //绑定TopicExchange
    public Binding topic

}
