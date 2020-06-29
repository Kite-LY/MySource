package cn.kitey.test;

import cn.kitey.dao.AccountDao;
import cn.kitey.dao.UserDao;
import cn.kitey.domain.Account;
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

public class AccountTest {

    private InputStream inputStream;
    SqlSession session;
    AccountDao accountDao;
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
            accountDao = session.getMapper(AccountDao.class);
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
    public void findAll(){
        List<Account> aLl1 = accountDao.findALl();
        for (Account account : aLl1){
            System.out.println("------每一个账户信息---------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }
}
