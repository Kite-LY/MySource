package test;

import cn.kitey.config.SpringConfiguration;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import cn.kitey.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;


/**
 * Spring类整合junit测试配置
 *      @RunWith：
 *          告知spring的运行器，spring和ioc创建时基于xml还是注解的，并且说明位置
 *      @ContextConfiguration：
 *          Location：指定位置
 *          classes：指定注解类所在位置
 *      @Autowired：注解的注入
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    //自动注入
    @Autowired
    private AccountService xmlBean;


    @Before
    public void init(){
        ApplicationContext xml = new AnnotationConfigApplicationContext(SpringConfiguration.class);
         xmlBean = xml.getBean("accountService", AccountServiceImpl.class);

   }



    @Test
    public void findAll() {
        List<Account> all = xmlBean.findAll();
        System.out.println("findAll()数据结果为：");
        for (Account account : all) {
            System.out.println(account);
        }
    }

    @Test
    public void findById() {
        Account byId = xmlBean.findById(1);
        System.out.println(byId);
    }

    @Test
    public void saveAccount() {
        Account acc = new Account();
        acc.setId(6);
        acc.setUid(1);
        acc.setMoney(123456);
        xmlBean.saveAccount(acc);
        List<Account> all = xmlBean.findAll();
        for (Account account : all) {
            System.out.println("进行数据插入后的结果：");
            System.out.println(account);
        }
    }

    @Test
    public void updateAccount() {
        Account acc = new Account(6, 1, 8888);
        xmlBean.updateAccount(acc);
        List<Account> all = xmlBean.findAll();
        for (Account account : all) {
            System.out.println("进行数据更新后的结果后的结果：");
            System.out.println(account);
        }
    }

    @Test
    public void deleteAccount() {
        xmlBean.deleteAccount(6);
        List<Account> all = xmlBean.findAll();
        for (Account account : all) {
            System.out.println("进行数据删除后的结果：");
            System.out.println(account);
        }
    }
}