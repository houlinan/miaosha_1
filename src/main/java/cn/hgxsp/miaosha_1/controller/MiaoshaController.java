package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.MiaoshaOrder;
import cn.hgxsp.miaosha_1.Domain.OrderInfo;
import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.exception.GlobleException;
import cn.hgxsp.miaosha_1.redis.RedisService;
import cn.hgxsp.miaosha_1.resultVO.CodeMsg;
import cn.hgxsp.miaosha_1.resultVO.GoodsVO;
import cn.hgxsp.miaosha_1.service.GoodsService;
import cn.hgxsp.miaosha_1.service.MiaoshaService;
import cn.hgxsp.miaosha_1.service.OrderService;
import cn.hgxsp.miaosha_1.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.Oneway;

/**
 * DESC：秒杀Controller 层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/10/18
 * Time : 17:24
 */
@Controller
@Slf4j
@RequestMapping("/miaosha")
public class MiaoshaController {

    @Autowired
    RedisService redisService ;

    @Autowired
    UserService userService ;

    @Autowired
    GoodsService goodsService ;

    @Autowired
    OrderService orderService ;

    @Autowired
    MiaoshaService miaoshaService ;

    @RequestMapping("/do_miaosha")
    public String doMiaosha(Model model , User user , @RequestParam("goodsId")Long goodsId){
        model.addAttribute("user" , user ) ;
        if(ObjectUtils.isEmpty(user)) return "login" ;


        GoodsVO goodsVo = goodsService.getGoodsById(goodsId);
        if(ObjectUtils.isEmpty(goodsVo)) throw new GlobleException(CodeMsg.GOODS_IS_EMPTY);

        //判断库存
        Integer stockCount = goodsVo.getStockCount();
        if(stockCount <= 0 ){
            model.addAttribute("errmsg" , CodeMsg.GOODS_STOCK_IS_EMPTY.getMsg()) ;
            return "miaoshao_fail" ;
        }

        //判断是否已经秒杀到了
        MiaoshaOrder miaoshaOrder = orderService.getMiaoshaoOrderByUserIdAndGoodsId(user.getId() , goodsId) ;

        if(!ObjectUtils.isEmpty(miaoshaOrder)){

            model.addAttribute("errmsg" ,CodeMsg.GOODS_REPEATE_MIAOSHA.getMsg() ) ;
            return "miaoshao_fail" ;
        }

        OrderInfo  orderInfo = miaoshaService.miaosha(user ,goodsVo) ;
        model.addAttribute("orderInfo" , orderInfo ) ;
        model.addAttribute("goods" , goodsVo ) ;

        return "order_detail";
    }

}
