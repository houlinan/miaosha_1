package cn.hgxsp.miaosha_1.redis;

/**
 * DESC：redisKey接口类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 12:06
 */
public interface KeyPrefix {

    /**
    *DESC: 设置过期时间  0为用不过去
    *@author hou.linan
    *@date:  2018/9/26 12:10
    *@param:  []
    *@return:  int
    */
    public int expireSecondS();

    /**
    *DESC: 获取前缀字符串
    *@author hou.linan
    *@date:  2018/9/26 12:11
    *@param:  []
    *@return:  java.lang.String
    */
    public String getPrefix();
}
