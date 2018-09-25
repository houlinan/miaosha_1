package cn.hgxsp.miaosha_1.resultVO;

import lombok.Getter;

/**
 * DESC：结果集返回对象
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 14:41
 */
@Getter
public class Result<T> {

    private int code ;
    private String msg ;
    private T data ;

    private Result(T data){
        this.code = 0 ;
        this.msg = "success" ;
        this.data = data ;
    }
    private Result(CodeMsg cm){
        this.code = cm.getCode() ;
        this.msg = cm.getMsg() ;

    }

    public static <T> Result<T> success(T data){
        return new Result<>(data ) ;
    }

    public static <T> Result<T> error(CodeMsg cm){
        return new Result<>(cm) ;
    }

}
