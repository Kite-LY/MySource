package cn.kitey.test;

import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.domain.Account;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Demo1Test {

    /**
     * 测试dao层查询数据所用
     */
    @Test
    public void testFindAll(){
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountDaoImpl accountDao1 = context.getBean("accountDao", AccountDaoImpl.class);

        List<Account> all = accountDao1.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }
}
