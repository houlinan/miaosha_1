package cn.hgxsp.miaosha_1.redis;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 14:59
 */
public class OrderKey extends BasePrifix {


    public OrderKey(int expireSecondS, String prefix) {
        super(expireSecondS, prefix);
    }


}
