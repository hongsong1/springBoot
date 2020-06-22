package com.hs.service;

import com.hs.entiry.User;
import com.hs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @description:
 * @author: 彭于晏
 * @create: 2020-04-03 11:39
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userDao;

    public User getAll(User user){
        return userDao.getuser(user);
    }

    public Set<String> getRole(String userName){
        return userDao.queryRolesByUserName(userName);
    }
    public Set<String> getResource(String username){
        return userDao.queryMenusByUserName(username);
    }
}
