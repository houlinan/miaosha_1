package cn.hgxsp.miaosha_1.service;
import java.util.Date;

import cn.hgxsp.miaosha_1.Domain.MiaoshaOrder;
import cn.hgxsp.miaosha_1.Domain.OrderInfo;
import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.dao.OrderDao;
import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * DESC：  订单service类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/18
 * Time : 17:42
 */
@Service
public class OrderService {

    @Autowired
    OrderDao orderDao ;


    public MiaoshaOrder getMiaoshaoOrderByUserIdAndGoodsId(Integer id, Long goodsId) {
        return orderDao.getMiaoshaoOrderByUserIdAndGoodsId(id , goodsId) ;
    }

    @Transactional
    public OrderInfo createOrder(User user, GoodsVO goodsVo) {
        //创建orderInfo
        OrderInfo order = new OrderInfo();
        order.setUserId(user.getId());
        order.setGoodsId(goodsVo.getId());
        order.setDeliveryAddrId(0);
        order.setGoodsName(goodsVo.getGoodsName());
        order.setGoodsCount(1);
        order.setGoodsPrice(goodsVo.getMiaoshaPrice());
        order.setOrderChannel(1);
        order.setStatus(0);
        order.setCreateDate(new Date());
        order.setPayDate(new Date());

        int orderId = orderDao.insert(order) ;

        MiaoshaOrder miaoshaOrder = new MiaoshaOrder() ;
        miaoshaOrder.setUserId(user.getId());
        miaoshaOrder.setOrderId(orderId);
        miaoshaOrder.setGoodsId(goodsVo.getId());

        int miaoshaoOrderId = orderDao.insertMiaoshaOrder(miaoshaOrder);

        return order ;
    }
}
