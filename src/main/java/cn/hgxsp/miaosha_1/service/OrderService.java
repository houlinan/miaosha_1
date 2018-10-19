package cn.hgxsp.miaosha_1.service;

import cn.hgxsp.miaosha_1.Domain.MiaoshaOrder;
import cn.hgxsp.miaosha_1.dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return OrderDao.getMiaoshaoOrderByUserIdAndGoodsId(id , goodsId) ;
    }
}
