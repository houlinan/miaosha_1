package cn.hgxsp.miaosha_1.resultVO;

import lombok.Getter;

/**
 * DESC：错误信息结果集
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 14:49
 */
@Getter
public class CodeMsg {

    private String msg ;
    private int code ;

    private CodeMsg(String msg , int code ){
        this.msg = msg ;
        this.code = code ;
    }

    /**
     *
     * 下列为结果集
     *
     * */

    public static CodeMsg success = new CodeMsg("成功" , 0 );
    public static CodeMsg SERVER_ERROR = new CodeMsg("服务器系统异常" , 500100) ;
    public static CodeMsg BIND_ERROR = new CodeMsg("参数校验异常：%s" , 500101) ;

    /** 用户登陆类错误  -- 5001xx  */
    public static CodeMsg USER_IS_EMPTY = new CodeMsg("用户对象为空" , 500200 );
    public static CodeMsg USER_LOGIN_MOBLIE_IS_EMPYT = new CodeMsg("用户传入手机为空" , 500201 );
    public static CodeMsg USER_PASSWORD_IS_EMPTY = new CodeMsg("用户传入密码为空" , 500202 );
    public static CodeMsg USERNAME_OR_PASSWORD_ERROR = new CodeMsg("用户账号或者密码错误" , 500203 );


    /**
    *DESC:
    *@author hou.linan
    *@date:  2018/10/15 15:43
    *@param:
    *@return:
    */
    public CodeMsg fillArge(Object... args ){
        int code = this.code ;
        String message = String.format(this.msg , args);
        return new CodeMsg(message , code) ;
    }



}
