package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.resultVO.CodeMsg;
import cn.hgxsp.miaosha_1.resultVO.LoginVO;
import cn.hgxsp.miaosha_1.resultVO.Result;
import cn.hgxsp.miaosha_1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
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

    @Autowired
    UserService userService ;

    @RequestMapping("/to_login")
    public String toLogin(){
        return "login" ;
    }

    @PostMapping(value = "/do_login" )
    @ResponseBody
    public Result doLogin(LoginVO loginVO ) {
        if(ObjectUtils.isEmpty(loginVO)) return Result.error(CodeMsg.USER_IS_EMPTY);
        if(StringUtils.isEmpty(loginVO.getMobile())) return Result.error(CodeMsg.USER_LOGIN_MOBLIE_IS_EMPYT) ;

        String mobile = loginVO.getMobile();
        User user = userService.findUserByName(mobile);
        return Result.success(user) ;
    }





}
