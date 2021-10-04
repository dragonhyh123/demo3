package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServicesImpl implements UserServices {
    @Autowired
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;

    User user;

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED,timeout = 1)
    public User queryByID(int id){
        String redisKey = "user"+id;
        if(redisUtil.hasKey(redisKey)){
            user = (User) redisUtil.get(redisKey);
            System.out.println("Using Cache");
        }else{
            user = userMapper.queryByID(id);
            System.out.println("Using Database");
            System.out.println(redisUtil.set(redisKey,user)?"insert success":"insert fail");
        }
        return user;
//        return userMapper.queryByID(id);
    }
}
