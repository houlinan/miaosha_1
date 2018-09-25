package cn.hgxsp.miaosha_1.controller;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.resultVO.Result;
import cn.hgxsp.miaosha_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DESC：用户Controller层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 16:27
 */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService ;

    @GetMapping("/getById")
    public Result<User> getById(){
        return Result.success(userService.getById(0));
    }
}
