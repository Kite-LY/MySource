package cn.kitey.test;

import cn.kitey.dao.UserDao;
import cn.kitey.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.util.Date;
import java.util.List;

public class MyBatisAnnotationTest {
    private InputStream inputStream;
    SqlSession session;
    UserDao userDao;
    @Before
    public void init()  {
        try {
            //读取文件输入流
            inputStream   = Resources.getResourceAsStream("SqlMapConfig.xml");
            //获取SqlSessionFactory
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(inputStream);
            //获取session对象
            session = factory.openSession();
            //获取代理对象
            userDao = session.getMapper(UserDao.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @After
    public void destroy(){
        //进行事务的提交
        session.commit();

        //释放资源
        session.close();
        try {
            if( inputStream != null){
                inputStream.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void findByIdTest(){
        User byId = userDao.findById(1);
        System.out.println(byId);
    }


    @Test
    public void FindAllTest(){
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }

    @Test
    public void insertUserTest(){
        User userDate = new User();
        userDate.setUsername("赵云insert 2");
        userDate.setSex("男");
        userDate.setAddress("three KingDom");
        userDate.setBirthday(new Date());
        userDao.insertUser(userDate);

        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }


}
