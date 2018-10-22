package cn.hgxsp.miaosha_1.service;

import cn.hgxsp.miaosha_1.Domain.Goods;
import cn.hgxsp.miaosha_1.Domain.OrderInfo;
import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 * DESC：秒杀service类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/18
 * Time : 17:48
 */
@Service
public class MiaoshaService {

    @Autowired
    GoodsService goodsService ;

    @Autowired
    OrderService orderService ;

    @Transactional
    public OrderInfo miaosha(User user, GoodsVO goodsVo) {
        //减少库存
        goodsService.reduceStock(goodsVo) ;

        //创建订单（orderInfo 和 miaosha_order）
        return  orderService.createOrder(user ,goodsVo) ;



    }
}
