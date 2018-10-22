package cn.hgxsp.miaosha_1.service;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.dao.UserDao;
import cn.hgxsp.miaosha_1.redis.MiaoShaUserKey;
import cn.hgxsp.miaosha_1.redis.RedisService;
import cn.hgxsp.miaosha_1.redis.UserKey;
import cn.hgxsp.miaosha_1.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * DESC： 用户Service层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 16:23
 */
@Service
@Slf4j
public class UserService {

    @Autowired
    private UserDao userDao ;

    @Autowired
    RedisService redisService ;

    /**
    *DESC: 通过ID查询用户
    *@author hou.linan
    *@date:  2018/9/27 10:49
    *@param:  [id]
    *@return:  cn.hgxsp.miaosha_1.Domain.User
    */
    public User getById(int id){

        User user = redisService.get(UserKey.getReidsById, "" + id, User.class);
        if(!ObjectUtils.isEmpty(user)) return user ;
        user = userDao.getById(id) ;
        if(!ObjectUtils.isEmpty(user))   redisService.set(UserKey.getReidsById, "" + id, user) ;

        return user ;
    }


    /**
    *DESC: 添加用户
    *@author hou.linan
    *@date:  2018/9/27 10:50
    *@param:  [user]
    *@return:  int
    */
    public int add(User user) {
        //TODO ：待完善用户添加
        return userDao.insert(user) ;
    }


    public User findUserByName(String username) {
        return userDao.getByName(username) ;
    }



    public User getByToken(String token , HttpServletResponse response){
        if(StringUtils.isEmpty(token)) return null ;
        User user = redisService.get(MiaoShaUserKey.token, token, User.class);
        if(!ObjectUtils.isEmpty(user)){
            addCookie(user ,response ,token ) ;
        }

        return user ;
    }


    /**
    *DESC: 将用户添加到cookie中
    *@author hou.linan
    *@date:  2018/10/17 14:26
    *@param:  [user, response]
    *@return:  void
    */
    public void addCookie(User user , HttpServletResponse response , String token ){

        redisService.set(MiaoShaUserKey.token , token , user) ;
        Cookie cookie = new Cookie(MiaoShaUserKey.COOKIE_NAME_TOKEN , token );
        cookie.setMaxAge(MiaoShaUserKey.token.expireSecondS());
        cookie.setPath("/");
        response.addCookie(cookie);
    }

}
