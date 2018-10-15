package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.redis.MiaoShaUserKey;
import cn.hgxsp.miaosha_1.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * DESC：商品controller
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/15
 * Time : 16:59
 */
@Controller
@RequestMapping("/goods")
public class GoodController {

    @Autowired
    RedisService redisService ;

    @RequestMapping("/to_list")
    public String toLogin(Model model  ,
                          @CookieValue(value = MiaoShaUserKey.COOKIE_NAME_TOKEN , required = false)String cookieToken ,
                          @RequestParam(value =  MiaoShaUserKey.COOKIE_NAME_TOKEN , required = false)String requestToken) {
        if(StringUtils.isEmpty(cookieToken) && StringUtils.isEmpty(requestToken)) return "login" ;
        String token = StringUtils.isEmpty(requestToken) ? cookieToken : requestToken ;

        User user = redisService.get(MiaoShaUserKey.token, token, User.class);
        model.addAttribute("user" , user) ; 

        return "goods_list";
    }
}
