package com.kite.test;

import com.kite.pojo.User;
import com.kite.service.impl.UserServiceImpl;
import org.junit.Test;

public class UserServiceTest {
    UserServiceImpl userService = new UserServiceImpl();


    @Test
    public void registUser(){
        userService.registUser(new User(null, "kite3", "123456","kite2@qq.com"));
    }

    @Test
    public void loginTest(){
        System.out.println(userService.login(new User(null, "kite3", "123456","kite2@qq.com")));

    }

    @Test
    public void existsUsername(){
        if(userService.existsUsername("kite")){
            System.out.println("用户名已经存在！");
        }else{
            System.out.println("用户名不存在！");
        }
    }


}