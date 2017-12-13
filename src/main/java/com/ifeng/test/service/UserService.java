package com.ifeng.test.service;

import com.ifeng.test.dao.mapper.UserMapper;
import com.ifeng.test.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by whling on 2017/12/12.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<User> getAll() {
        return userMapper.getAll();
    }

    public User getUserById(int id) {
        return userMapper.getUserById(id);
    }

    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }


    @Transactional(rollbackFor = Exception.class)
    public void testTransaction(User user1, User user2) {
        System.out.println("save use test");
        int i = userMapper.saveUser(user1);
        System.out.println("..dfjdlsjlfjldjslfjlajdlfjjei");
        int j = userMapper.updateUser(user2);
        System.out.println("i=" + i + " j=" + j);
    }
}
