package com.kiteYY.test;

import com.kiteYY.dao.UserDao;
import com.kiteYY.domain.QueryVo;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MyBatisTest {

    private InputStream in;
    private SqlSession session;
    private UserDao mapper;

    @Before  //在执行测试方法前进行执行
    public void init(){
        try {
            //1.读取配置文件获取字节输入流
            in = Resources.getResourceAsStream("SqlMapConfig.xml");
            //2.获取SqlSessionFactor工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory build = builder.build(in);
            session = build.openSession();    //如果没openSession(true) :则是自动提交
            //3.获取代理对象
            mapper =  session.getMapper(UserDao.class);
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
    public void findUserInIdsTest(){
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(3);
        list.add(5);
        vo.setIds(list);
        List<User> inIds = mapper.findInIds(vo);
        for (User inId : inIds) {
            System.out.println(inId);
        }

    }

    @Test
    public void findByQueryVo(){
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUserName("%老%");
        queryVo.setUser(user);
        List<User> userByVo = mapper.findUserByVo(queryVo);
        for (User user1 : userByVo) {
            System.out.println(user1);
        }

    }


    @Test
    public void findUserByConditionTest(){
        User user = new User();
        user.setUserName("老闫");
        user.setUserSex("男");
        List<User> users = mapper.findUserByCondition(user);
        for (User user1 : users) {
            System.out.println(user1);
        }
    }





    @Test
    public void findByNameTest(){
        List<User> byName = mapper.findByName("%老%");
        for (User user : byName) {
            System.out.println(user);
        }
    }


    @Test
    public void findByIdTest(){
        User byId = mapper.findById(1);
        System.out.println(byId);
    }







    /**
     * 测试读取用户信息
     */
    @Test
    public void findAllTest(){

        //4.执行代理方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }
}
