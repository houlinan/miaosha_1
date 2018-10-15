package cn.hgxsp.miaosha_1.resultVO;

import cn.hgxsp.miaosha_1.validator.IsMoblie;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * DESC：用户登陆验证vo类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 17:40
 */
@Data
public class LoginVO {

    @NotNull
    @IsMoblie
    private String mobile ;

    @NotNull
    @Length(max = 32)
    private String password ;
}
