package cn.hgxsp.miaosha_1.service;

import cn.hgxsp.miaosha_1.Domain.User;
import cn.hgxsp.miaosha_1.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * DESC： 用户Service层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 16:23
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao ;

    public User getById(int id){
        return userDao.getById(id) ;
    }


    public int add(User user) {
        return userDao.insert(user) ;
    }
}
