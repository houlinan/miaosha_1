package cn.hgxsp.miaosha_1.Domain;

import lombok.Data;

import java.util.Date;

/**
 * DESC：用户表
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 16:15
 */
@Data
public class User {
    private int id ;
    private String username ;
    private String password ;
    private String salt;
    private String head ;
    private Date registerDate ;
    private Date lastLoginDate ;
    private Integer loginCount ;
    private String nickName ;
}
