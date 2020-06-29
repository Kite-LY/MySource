package com.kiteYY.test;


import com.kiteYY.dao.UserDao;
import com.kiteYY.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class userTest {

    private InputStream in;
    private SqlSession session;
    private UserDao userDao;
    private SqlSessionFactory build;

    @Before  //在执行测试方法前进行执行
    public void init(){
        try {
            //1.读取配置文件获取字节输入流
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.获取SqlSessionFactor工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            build = builder.build(in);
            session = build.openSession();    //如果没openSession(true) :则是自动提交
            //3.获取代理对象
            userDao =  session.getMapper(UserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After //在执行测试方法后进行执行
    public void destroy(){

        //事务的提交
        session.commit();
        //5.释放资源
        session.close();
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void FirstLevelCacheTest(){
        User byId = userDao.findById(1);

//        调用了清空缓存的方法
        session.clearCache();

        User byId2= userDao.findById(1);
        System.out.println(byId == byId2);

    }

}



































