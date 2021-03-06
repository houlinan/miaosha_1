package cn.hgxsp.miaosha_1.dao;

import cn.hgxsp.miaosha_1.Domain.MiaoshaOrder;
import cn.hgxsp.miaosha_1.Domain.OrderInfo;
import org.apache.ibatis.annotations.*;

/**
 * DESC：订单DAO层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/18
 * Time : 22:21
 */
@Mapper
public interface OrderDao {

    @Select("select * from miaosha_order where user_id = #{userId} and goods_id = #{goodsId}")
    MiaoshaOrder getMiaoshaoOrderByUserIdAndGoodsId(@Param("userId") Integer id,@Param("goodsId") Long goodsId) ;

    @Insert("insert into order_info(user_id ,goods_id , goods_name , goods_count , goods_price , order_channel, status ,create_date" +
            ")values (#{userId} , #{goodsId}, #{goodsName}, #{goodsCount}, #{goodsPrice}, #{orderChannel}," +
            "#{status} , #{createDate})")
    @SelectKey(keyColumn = "id" , keyProperty = "id" , resultType = int.class , before = false,
    statement = "select last_insert_id()")
    int insert(OrderInfo order);

    @Insert("insert into miaosha_order(user_id , goods_id , order_id)values(#{userId} , #{goodsId} , #{orderId})")
    int insertMiaoshaOrder(MiaoshaOrder miaoshaOrder);
}
