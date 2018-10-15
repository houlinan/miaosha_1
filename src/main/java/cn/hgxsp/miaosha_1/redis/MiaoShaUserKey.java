package cn.hgxsp.miaosha_1.redis;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 14:58
 */
public class MiaoShaUserKey extends BasePrifix {

    public static final String COOKIE_NAME_TOKEN = "token" ;

    private static final int TOKEN_EXPIRE = 3600 * 24 * 2 ;

    private int expireSecondS;

    private MiaoShaUserKey(String prefix ,int expireSecondS) {
        super(expireSecondS , prefix);
    }

    public static MiaoShaUserKey token =  new MiaoShaUserKey("token" ,TOKEN_EXPIRE) ;

}
