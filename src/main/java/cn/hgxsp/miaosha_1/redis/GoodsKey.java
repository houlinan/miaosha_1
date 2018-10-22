package cn.hgxsp.miaosha_1.redis;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 14:58
 */
public class GoodsKey extends BasePrifix {


    private GoodsKey(String prefix) {
        super(prefix);
    }

    private GoodsKey(int expireSecondS, String prefix){
        super(expireSecondS , prefix);
    }

    public static GoodsKey getGoodsList = new GoodsKey(60, "goodsList" ) ;
    public static GoodsKey getGoodsDetail = new GoodsKey(60, "goodsDetail" ) ;

}
