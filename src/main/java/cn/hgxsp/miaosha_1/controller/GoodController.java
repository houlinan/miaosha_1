package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.exception.GlobleException;
import cn.hgxsp.miaosha_1.redis.MiaoShaUserKey;
import cn.hgxsp.miaosha_1.redis.RedisService;
import cn.hgxsp.miaosha_1.resultVO.CodeMsg;
import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import cn.hgxsp.miaosha_1.service.GoodsService;
import cn.hgxsp.miaosha_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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



    @RequestMapping("/to_detail/{goodsId}")
    public String toDetail(User user , Model model , @PathVariable("goodsId") long goodsId){
        model.addAttribute("user" , user) ;


        //获取商品信息
        GoodsVO goodsVO = goodsService.getGoodsById(goodsId) ;
        model.addAttribute("goods" , goodsVO) ;

        if(ObjectUtils.isEmpty(goodsVO)) throw new GlobleException(CodeMsg.GOODS_IS_NOT_FIND) ;

        //判断秒杀时间
        Long currTime = System.currentTimeMillis() ;
        Long startMiaoshaTime = goodsVO.getStartDate().getTime() ;
        Long endMiaoshaTime = goodsVO.getEndDate().getTime() ;

        //秒杀状态，0 未开始   ； 1  正在进行中 ； 2 已经结束
        int miaoshaStatus =  0 ;
        long remainSeconds = 0 ;

        if(startMiaoshaTime > currTime){
            //秒杀未开始
            miaoshaStatus = 0  ;
            remainSeconds =(int)((startMiaoshaTime - currTime)/1000) ;
            System.out.println("remainSeconds = " + remainSeconds);
        }else if(currTime > endMiaoshaTime){
            //秒杀已经结束
            miaoshaStatus = 2 ;
            remainSeconds = -1 ;
        }else{
            //正在进行中
            miaoshaStatus = 1 ;
            remainSeconds = 0 ;
        }
        model.addAttribute("miaoshaStatus" , miaoshaStatus) ;
        model.addAttribute("remainSeconds" , remainSeconds) ;

        return "goods_detail";
    }




}
