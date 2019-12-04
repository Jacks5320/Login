package com.jacks.login.mapper;

import com.jacks.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    List<User> findAll();
    User findByName(String name);
    String findPswByName(String UserName);
    void save(User user);
}
