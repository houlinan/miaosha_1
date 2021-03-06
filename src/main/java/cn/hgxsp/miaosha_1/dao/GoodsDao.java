package cn.hgxsp.miaosha_1.dao;

import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


    @Select("select g.* ,mg.miaosha_price , mg.stock_count , mg.start_date , mg.end_date from miaosha_goods mg left join goods g on mg.goods_id = g.id where g.id = #{goodsId}")
    GoodsVO getGoodsById(long goodsId);

    @Update("update miaosha_goods set stock_count = stock_count -1 where goods_id = #{id}")
    public int  reduceStock(int id);
}
