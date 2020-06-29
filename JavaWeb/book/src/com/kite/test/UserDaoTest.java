package com.kite.test;

import com.kite.dao.impl.UserDaoImpl;
import com.kite.pojo.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void  queryUserByUsername(){
        UserDaoImpl userDao = new UserDaoImpl();
        if(userDao.queryUserByUsername("admin") == null){
            System.out.println("用户名可以用！");
        }else {
            System.out.println("用户名不可以用！");
        }
    }


    @Test
    public void queryUserByUsernameAndPassWord(){
        UserDaoImpl userDao = new UserDaoImpl();
        if(userDao.queryUserByUsernameAndPassWord("admin1", "admin") == null){
            System.out.println("用户名密码错误，登录失败！");
        }else {
            System.out.println("查询成功！");
        }
    }



    @Test
    public void  saveUser(){
        UserDaoImpl userDao = new UserDaoImpl();
        //返回值为 1 则成功！
        System.out.println(userDao.saveUser(new User(null,"kite2","123456","kite@qq.com")));
    }

}