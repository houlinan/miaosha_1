package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.redis.RedisService;
import cn.hgxsp.miaosha_1.redis.UserKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 14:30
 */
@RequestMapping("/demo")
@Controller
public class DemoController {

    @Autowired
    RedisService redisService ;

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name" , "houlinan") ;
        return "hello" ;
    }

    @GetMapping("/setRedis")
    @ResponseBody
    public void setRedisKey(String key , String value ){
        redisService.set(UserKey.getById , key , value ) ;

    }
    @GetMapping("/getRedis")
    @ResponseBody
    public String getRedisKey(String key ){
       return redisService.get(UserKey.getById  , key ,String.class);

    }
}
