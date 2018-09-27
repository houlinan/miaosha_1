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

    /**
    *DESC: 通过ID查询用户
    *@author hou.linan
    *@date:  2018/9/27 10:49
    *@param:  [id]
    *@return:  cn.hgxsp.miaosha_1.Domain.User
    */
    public User getById(int id){
        return userDao.getById(id) ;
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

}
