package com.jk.login.service;

import com.jk.login.info.ResultInfo;
import com.jk.login.mapper.UserMapper;
import com.jk.login.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @description: 桥接前端和后端的服务类UserService
* @author: Jacks丶
* @date: 2019-11-19 18:30:17
* @version: 1.0
*/
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    UserMapper userMapper;
    private ResultInfo result = new ResultInfo<>();

    /**
     * 注册服务
     * @param user 从前端获取的参数
     * @return
     */
    public ResultInfo registUser(User user) {
        try {
            User name = userMapper.findByUserName(user.getUserName());
            if (name != null) {
                result.setMsg("用户已存在，请重新选择新的用户名。");
            } else {
                System.out.println(user);
                userMapper.registUser(user);
                result.setMsg("注册成功，请返回登陆页面登陆。");
                result.setSuccess(true);
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 登陆服务
     * @param user 登录账户
     * @return
     */
    public ResultInfo loginUser(User user) {
        try {
            User userExist = userMapper.loginUser(user);
            if (userExist == null) {
                result.setMsg("用户名或密码错误，请重新核对");
            } else {
                result.setMsg("登录成功。");
                user.setUserId(user.getUserId());
                result.setSuccess(true);
                user = userMapper.findByUserName(user.getUserName());
                result.setDetail(user);
            }
        } catch (Exception e) {
            result.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public ResultInfo updateUserPassword(User user){
        result.setMsg("修改成功");
        result.setSuccess(true);
        result.setDetail(user);
        userMapper.updateUserPassword(user);
        return result;
    }
}
