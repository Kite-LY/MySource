package cn.kitey.ui;


import cn.kitey.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountServiceImpl service = context.getBean("accountService", AccountServiceImpl.class);
        AccountServiceImpl service1 = context.getBean("accountService",AccountServiceImpl.class);
        System.out.println(service1);
        System.out.println(service);

        System.out.println(service == service1);




    }
}
