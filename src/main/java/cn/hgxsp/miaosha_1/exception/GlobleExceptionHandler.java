package cn.hgxsp.miaosha_1.exception;

import cn.hgxsp.miaosha_1.resultVO.CodeMsg;
import cn.hgxsp.miaosha_1.resultVO.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * DESC：全局异常处理类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 15:22
 */
@ControllerAdvice
@ResponseBody
public class GlobleExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest req , Exception e ){

        if(e instanceof GlobleException){
            GlobleException glex = (GlobleException)e;
            return Result.error(glex.getCodeMsg()) ;

        }else if(e instanceof BindException){
            BindException ex = (BindException)e ;
            List<ObjectError> allErrors = ex.getAllErrors();
            ObjectError objectError = allErrors.get(0);
            String defaultMessage = objectError.getDefaultMessage();


            return Result.error(CodeMsg.BIND_ERROR.fillArge(defaultMessage)) ;
        }else{
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }


}
