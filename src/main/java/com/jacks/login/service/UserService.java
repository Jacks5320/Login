package com.jacks.login.service;

import com.jacks.login.mapper.UserMapper;
import com.jacks.login.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public String login(User user){//TODO：登陆逻辑函数
        try {
            User userExistN = userMapper.findByName(user.getUsername());
            if (userExistN != null){
                String userExistP = userMapper.findPswByName(user.getUsername());
                if (userExistP.equals(user.getPassword())){
                    return user.getUsername()+" 用户登录成功,欢迎您！";
                }else {
                    return "登陆失败,密码错误！";
                }
            }else {
                return "登陆失败，账户不存在";
            }
        }catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }

    public String regist(User user){//TODO：注册判断逻辑函数
        try{
            User userExist = userMapper.findByName(user.getUsername());
            if (user.getUsername().equals("")){
                return "账户名不能为空";
            }else if (user.getPassword().equals("")){
                return "密码不能为空";
            }else if (userExist != null){
                return "账户已经存在";
            }else {
                userMapper.save(user);
                return "注册成功";
            }
        }catch (Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
