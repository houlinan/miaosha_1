package cn.hgxsp.miaosha_1.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * DESC：校验数据工具类
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 14:25
 */
public class ValidatorDataUtils {

    /**
     * 判断是否是手机号
     *
     * @param mobile
     * @return
     */
    public static boolean isMobile(String mobile) {
        String regex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }
}
