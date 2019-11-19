package com.jk.login.mapper;

import com.jk.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
* @description: 访问数据库的mapper映射类
* @author: Jacks丶
* @date: 2019-11-19 18:28:27
* @version: 1.0
*/
@Mapper
@Repository
public interface UserMapper {
    //查询所有用户信息
    List<User> findAll();
    //根据用户名查询记录
    User findByUserName(String userName);
    //登录用户
    User loginUser(User user);
    //注册用户
    void registUser(User user);
    //修改用户密码
    void updateUserPassword(User user);
}
