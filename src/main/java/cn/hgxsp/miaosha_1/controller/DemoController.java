package cn.hgxsp.miaosha_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * DESC：
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 14:30
 */
@RequestMapping("/demo")
@Controller
public class DemoController {

    @RequestMapping("/thymeleaf")
    public String thymeleaf(Model model){
        model.addAttribute("name" , "houlinan") ;
        return "hello" ;
    }
}
