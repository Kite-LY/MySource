package cn.kitey.ui;


import cn.kitey.service.impl.AccountServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountServiceImpl service = context.getBean("accountServiceImpl", AccountServiceImpl.class);
        AccountServiceImpl service1 = context.getBean("accountServiceImpl", AccountServiceImpl.class);

        System.out.println(service == service1);


        context.close();


    }
}
