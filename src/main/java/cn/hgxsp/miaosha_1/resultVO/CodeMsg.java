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


}
