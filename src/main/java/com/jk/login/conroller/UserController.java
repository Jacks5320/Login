package com.jk.login.conroller;

import com.jk.login.info.ResultInfo;
import com.jk.login.pojo.User;
import com.jk.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
/**
* @description: 与前端交互的Controller层，UserController
* @author: Jacks丶
* @date:2019-11-19 18:34:17
* @version: 1.0
*/
@Controller
@ResponseBody
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * 注册
     * @param user
     * @return 反馈信息
     */
    @PostMapping(value = "/regist")
    public ResultInfo regist(User user){
        return userService.registUser(user);
    }

    /**
     * 登录
     * @param user
     * @return 反馈信息
     */
    @PostMapping(value = "/login")
    public ResultInfo login(User user){
        return userService.loginUser(user);
    }

    /**
     * 修改密码
     * @param user
     * @return 反馈信息
     */
    @PostMapping(value = "/updateUserPassword")
    public ResultInfo updateUserPassword(User user){
        return userService.updateUserPassword(user);
    }
}
