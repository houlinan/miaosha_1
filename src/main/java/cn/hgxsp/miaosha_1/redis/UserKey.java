package cn.hgxsp.miaosha_1.redis;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 14:58
 */
public class UserKey extends BasePrifix {


    private UserKey( String prefix) {
        super(prefix);
    }
    private UserKey(int expireSecondS, String prefix){
        super(expireSecondS, prefix);
    }

    public static UserKey getById = new UserKey("id") ;
    public static UserKey getByName = new UserKey("userName") ;


    public static UserKey getReidsById = new UserKey(0 , "userID") ;
}
