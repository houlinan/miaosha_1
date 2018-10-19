package cn.hgxsp.miaosha_1.dao;

import cn.hgxsp.miaosha_1.Domain.MiaoshaOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * DESC：订单DAO层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/18
 * Time : 22:21
 */
@Mapper
public interface OrderDao {

    @Select("")
    MiaoshaOrder getMiaoshaoOrderByUserIdAndGoodsId(Integer id, Long goodsId) ;
}
