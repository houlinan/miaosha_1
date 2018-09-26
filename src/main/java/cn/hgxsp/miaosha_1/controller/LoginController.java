package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.resultVO.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DESC：用户登陆controller层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/26
 * Time : 17:43
 */
@Controller
@Slf4j
@RequestMapping("/login")
public class LoginController {


    @RequestMapping("/to_login")
    public String toLogin(){
        return "login" ;
    }

    @PostMapping("/do_login")
    @ResponseBody
    public String doLogin( @RequestBody LoginVO loginVO ) {
        System.out.println(loginVO.toString());
        return null ;
    }



}
