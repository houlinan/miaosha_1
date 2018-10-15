package cn.hgxsp.miaosha_1.validator;

import cn.hgxsp.miaosha_1.utils.ValidatorDataUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 14:09
 */
public class IsMoblieValidator implements ConstraintValidator<IsMoblie ,String > {

    private boolean required = false ;

    @Override
    public void initialize(IsMoblie constraintAnnotation) {
        required = constraintAnnotation.required() ;
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(required){
            return ValidatorDataUtils.isMobile(s) ;
        }else{
            if(StringUtils.isEmpty(s)){
                return true ;
            }else{
                return ValidatorDataUtils.isMobile(s) ;
            }
        }


    }
}
