package cn.kitey.test;

import cn.kitey.domain.Account;
import cn.kitey.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTest {

//
//    AOP原理
//       <aop:aspectj-autoproxy />声明自动为spring容器中那些配置@aspectJ切面的bean创建代理，织入切面。
//      <aop:aspectj-autoproxy />的proxy-target-class属性，默认为false，表示使用jdk动态代理织入增强。当配为<aop:aspectj-autoproxy  poxy-target-class="true"/>时，表示使用CGLib动态代理技术织入增强。如果proxy-target-class设置为false，但是目标类没有声明接口，则spring将自动使用CGLib动态代理。
//    解决方法
//    把<aop:aspectj-autoproxy/> 修改成<aop:aspectj-autoproxy proxy-target-class="true"/>

    @Test
    public void test02(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AccountServiceImpl service = context.getBean("accountService", AccountServiceImpl.class);
        List<Account> all = service.findAll();
        for (Account account : all) {
            System.out.println(account);
        }

    }
}
