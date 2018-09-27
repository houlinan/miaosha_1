package cn.hgxsp.miaosha_1.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * DESC：MD5工具类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 16:57
 */
public class MD5Util {

    public static String MD5(String str ){
        return DigestUtils.md2Hex(str );
    }

    private static final String SALT = "nsuia@$9802nmcdls(*$()@!m" ;

    public static String fromPass2ServerPass (String passWord ) {

        return  MD5("" + SALT.charAt(5) + SALT.charAt(5) +SALT.charAt(8)
                + SALT.charAt(10) + SALT.charAt(2)+ passWord + SALT.charAt(6)
                + SALT.charAt(11)+SALT.charAt(1));
    }


    public static String serverPass2DBPass(String serPass , String salt) {
        return  MD5("" + salt.charAt(0 ) + salt.charAt(2 ) + serPass + salt.charAt(4 ) +salt.charAt(3 )) ;
    }

    public static String fromPass2DBPass(String serPass , String salt){
        return serverPass2DBPass(fromPass2ServerPass(serPass) ,salt ) ;
    }

    public static void main(String[] args) {
        System.out.println(fromPass2DBPass("admin" , "256d4sa86c4"));
    }


}
