package com.kiteYY.test;

import com.kiteYY.dao.AccountDao;
import com.kiteYY.dao.UserDao;

import com.kiteYY.domain.Account;
import com.kiteYY.domain.AccountUser;
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

public class MyBatisTest {

    private InputStream in;
    private SqlSession session;
    private AccountDao accountDao;

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
            accountDao =  session.getMapper(AccountDao.class);
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


    /**
     * 查询所有的用户信息和相关的账户信息
     */
    @Test
    public void findAccountUserTest(){
        List<AccountUser> userAccount = accountDao.findUserAccount();
        for (AccountUser accountUser : userAccount) {
            System.out.println("-------每一个account信息-----------");
            System.out.println(accountUser);

        }
    }


    /**
     * 测试查询所所有的账户信息
     */
    @Test
    public void findAllAccountTest(){
        List<Account> allAccount = accountDao.findAllAccount();
        for (Account account : allAccount) {
            System.out.println("-------每一个account信息-----------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
