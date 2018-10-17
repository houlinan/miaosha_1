package cn.hgxsp.miaosha_1.resultVO;

import cn.hgxsp.miaosha_1.Domain.Goods;
import lombok.Data;

import java.util.Date;

/**
 * DESC：商品列表返回值对象，添加秒杀商品表中的字段
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/17
 * Time : 16:52
 */
@Data
public class GoodsVO extends Goods {

    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
