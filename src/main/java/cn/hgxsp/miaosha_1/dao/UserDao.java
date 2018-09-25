package cn.hgxsp.miaosha_1.dao;

import cn.hgxsp.miaosha_1.Domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * DESC：用户DAo层
 * CREATED BY ：@hou.linan
 * CREATED DATE ：2018/9/25
 * Time : 16:16
 */
@Mapper
public interface UserDao {

    @Select("select * from user where id = #{id}")
    User getById(@Param("id") int id) ;

    @Insert("insert into user (id , username) values(#{id} , #{username})")
    int insert(User user) ;
}
