package cn.kitey.test;

import cn.kitey.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AOPtest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //是基于面向接口的动态代理，所以只能获取接口对象
        AccountService accountService = context.getBean("accountService",AccountService.class);
        accountService.saveAccount();
//        accountService.updateAccount(1);
//        accountService.deleteAccount();

    }

}
