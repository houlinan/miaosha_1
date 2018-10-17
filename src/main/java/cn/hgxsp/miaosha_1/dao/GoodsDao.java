package cn.hgxsp.miaosha_1.dao;

import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * DESC：商品DAO层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/17
 * Time : 16:50
 */
@Mapper
public interface GoodsDao {

    @Select("select g.* ,mg.miaosha_price , mg.stock_count , mg.start_date , mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id")
    List<GoodsVO> listGoodsVO();
}
