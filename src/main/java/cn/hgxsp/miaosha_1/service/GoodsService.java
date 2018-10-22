package cn.hgxsp.miaosha_1.service;
import java.util.Date;

import cn.hgxsp.miaosha_1.dao.GoodsDao;
import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * DESC：商品service类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/17
 * Time : 16:50
 */
@Service
public class GoodsService {

    @Autowired
    GoodsDao goodsDao ;

    public List<GoodsVO> getGoodsList(){
        return goodsDao.listGoodsVO() ;
    }

    public GoodsVO getGoodsById(long goodsId) {
        return goodsDao.getGoodsById(goodsId) ;

    }

    public int reduceStock(GoodsVO goodsVo) {

        return  goodsDao.reduceStock(goodsVo.getId()) ;
    }
}
