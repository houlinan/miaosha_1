package cn.hgxsp.miaosha_1.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * DESC：validation校验器，校验是否是手机号
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 14:04
 */
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = {IsMoblieValidator.class})
public @interface IsMoblie {

    String message() default "手机号码格式有误";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

//    允许不为空
    boolean required() default true;



}
