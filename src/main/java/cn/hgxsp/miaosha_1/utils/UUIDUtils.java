package cn.hgxsp.miaosha_1.utils;

import java.util.UUID;

/**
 * DESC：处理返回唯一的UUID
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 16:45
 */
public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-" , "");
    }
}
