package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.exception.GlobleException;
import cn.hgxsp.miaosha_1.redis.MiaoShaUserKey;
import cn.hgxsp.miaosha_1.redis.RedisService;
import cn.hgxsp.miaosha_1.resultVO.CodeMsg;
import cn.hgxsp.miaosha_1.resultVO.LoginVO;
import cn.hgxsp.miaosha_1.resultVO.Result;
import cn.hgxsp.miaosha_1.service.UserService;
import cn.hgxsp.miaosha_1.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
    UserService userService;

    @Autowired
    RedisService redisService ;

    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @PostMapping(value = "/do_login")
    @ResponseBody
    public Result doLogin(HttpServletResponse response, @Valid LoginVO loginVO) {

        if (ObjectUtils.isEmpty(loginVO)) throw new GlobleException(CodeMsg.USERNAME_OR_PASSWORD_ERROR);

        String mobile = loginVO.getMobile();

        String password = loginVO.getPassword();
//        log.info("用户传送进来的密码为：{}", password) ;

        User user = userService.findUserByName(mobile);
        if (ObjectUtils.isEmpty(user)) throw new GlobleException(CodeMsg.USERNAME_OR_PASSWORD_ERROR);

//        String userInputPWDtoDBPWD = MD5Util.serverPass2DBPass(password, user.getSalt());
        String userInputPWDtoDBPWD = password ;
//        log.info("用户登陆后的密码为：{}"  ,userInputPWDtoDBPWD);
//        log.info("用户的盐为：{}" , user.getSalt());
        if (!userInputPWDtoDBPWD.equals(user.getPassword()))
            throw new GlobleException(CodeMsg.USERNAME_OR_PASSWORD_ERROR);

        //  登陆成功后session的处理
        //生成 cookie
        String token = UUIDUtils.getUUID() ;
        userService.addCookie(user , response ,token);

        return Result.success(user);
    }


}
