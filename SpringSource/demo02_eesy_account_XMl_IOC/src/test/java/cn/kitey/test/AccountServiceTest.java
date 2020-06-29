package cn.kitey.test;

import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import cn.kitey.service.impl.AccountServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceTest {
    private  AccountService xmlBean;

    @Before
    public void init(){
        ApplicationContext xml = new ClassPathXmlApplicationContext("bean.xml");
         xmlBean = xml.getBean("accountService", AccountServiceImpl.class);

    }



    @Test
    public void transfer(){
        xmlBean.transfer(1,2,100);
    }
//
//    @Test
//    public void findAll() {
//        List<Account> all = xmlBean.findAll();
//        System.out.println("findAll()数据结果为：");
//        for (Account account : all) {
//            System.out.println(account);
//        }
//    }
//
//    @Test
//    public void findById() {
//        Account byId = xmlBean.findById(1);
//        System.out.println(byId);
//    }
//
//    @Test
//    public void saveAccount() {
//        Account acc = new Account();
//        acc.setId(6);
//        acc.setUid(1);
//        acc.setMoney(123456);
//        xmlBean.saveAccount(acc);
//        List<Account> all = xmlBean.findAll();
//        for (Account account : all) {
//            System.out.println("进行数据插入后的结果：");
//            System.out.println(account);
//        }
//    }
//
//    @Test
//    public void updateAccount() {
//        Account acc = new Account(6, 1, 8888);
//        xmlBean.updateAccount(acc);
//        List<Account> all = xmlBean.findAll();
//        for (Account account : all) {
//            System.out.println("进行数据更新后的结果后的结果：");
//            System.out.println(account);
//        }
//    }
//
//    @Test
//    public void deleteAccount() {
//        xmlBean.deleteAccount(6);
//        List<Account> all = xmlBean.findAll();
//        for (Account account : all) {
//            System.out.println("进行数据删除后的结果：");
//            System.out.println(account);
//        }
//    }
}