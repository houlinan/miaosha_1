package cn.hgxsp.miaosha_1.exception;

import cn.hgxsp.miaosha_1.resultVO.CodeMsg;
import lombok.Getter;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 16:25
 */
@Getter
public class GlobleException extends RuntimeException {

    private CodeMsg codeMsg ;

    public GlobleException(CodeMsg codeMsg){
      super(codeMsg.toString());
      this.codeMsg = codeMsg ;
    }

}
