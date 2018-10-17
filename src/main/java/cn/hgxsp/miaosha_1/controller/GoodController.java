package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.redis.MiaoShaUserKey;
import cn.hgxsp.miaosha_1.redis.RedisService;
import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import cn.hgxsp.miaosha_1.service.GoodsService;
import cn.hgxsp.miaosha_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

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

    @Autowired
    UserService userService ;

    @Autowired
    GoodsService goodsService ;


    @RequestMapping("/to_list")
    public String toLogin(HttpServletResponse response , Model model  ,
//                          @CookieValue(value = MiaoShaUserKey.COOKIE_NAME_TOKEN , required = false)String cookieToken ,
//                          @RequestParam(value =  MiaoShaUserKey.COOKIE_NAME_TOKEN , required = false)String requestToken
                                User user) {

        model.addAttribute("user" , user) ;

        //获取所有的商品列表
        List<GoodsVO> goodsList = goodsService.getGoodsList();
        model.addAttribute("goodsList" , goodsList) ;

        return "goods_list";
    }




}
