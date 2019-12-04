package com.jacks.login;

import com.jacks.login.mapper.UserMapper;
import com.jacks.login.pojo.User;
import com.jacks.login.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LoginApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Autowired
    UserService userService;
    @Test
    void testFindAll() {
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }
    @Test
    void testFindByName(){
        User user = userMapper.findByName("admin");
        System.out.println(user);
    }

    @Test
    void testLogin(){
        User user = new User();
        user.setUsername("admin");
        user.setPassword("111");
        userService.login(user);
    }
    @Test
    void testFindPswByname(){
        String psw = userMapper.findPswByName("admin");
        System.out.println(psw);
    }

    @Test
    void testRegist(){
        User user = new User();
        user.setUsername("adminn");
        user.setPassword("111");
        String msg = userService.regist(user);
        System.out.println(msg);
    }
}
