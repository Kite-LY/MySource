package com.kite.service.impl;

import com.kite.dao.UserDao;
import com.kite.dao.impl.UserDaoImpl;
import com.kite.pojo.User;
import com.kite.service.UserService;

public class UserServiceImpl implements UserService {


    //需要操作数据库，则需要创建数据库操作对象
    public UserDao userDao = new  UserDaoImpl();

    //注册
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPassWord(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            //等于null是表明没有查到可用的用户
            return false;
        }

        return true;
    }
}
