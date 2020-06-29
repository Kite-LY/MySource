package cn.kitey.test;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void test01() throws Exception {
        InputStream stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        //创建sqlSession对象
        SqlSession session = factory.openSession();
        //获取代理对象
        AccountDao mapper = session.getMapper(AccountDao.class);
        //执行查询方法
        List<Account> all = mapper.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

        //关闭资源
        session.close();
        stream.close();

    }

    @Test
    public void testSaveAccount() throws Exception {
        //读取配置文件
        InputStream resource = Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取session对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(resource);
        SqlSession session = factory.openSession();
        AccountDao mapper = session.getMapper(AccountDao.class);
        Account account = new Account();
        account.setName("Happy");
        account.setMoney(new Double(1233));
        mapper.saveAccount(account);
        System.out.println("存储成功！");
        //提交事务，这样数据才可以存储
        session.commit();
        session.close();
        resource.close();
    }


}



















