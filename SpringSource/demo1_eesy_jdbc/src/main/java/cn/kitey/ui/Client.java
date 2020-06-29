package cn.kitey.ui;


import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 获取spring的ioc容器，并根据id获取对象
 *
 * ApplicationContext的三个实现类
 *      ClassPathXmlApplicationContext:可以加载类路径下的配置文件，要求配置文件必须在类路径下，如果不存在，就不能进行加载
 *      FileSystemXmlApplicationContext:它可以加载磁盘任意路径下的配置文件（必须具有访问权限）
 *      AnnotationConfigApplicationContext：用于读取注解创建的容器
 *
 *
 * 核心容器的两个接口引发的问题：
 * ApplicationContext：单例模式使用
 *      它在创建核心容器时，创建对象采取的策略是采取立即加载的方式，就是当你读取配置文件的时候就会进行加载
 * BeanFactory： 多例对象使用
 *      它在创建核心容器的时候，采取的策略是延迟加载的方式，什么时候有了id对象，才会真正的创建对象
 */
public class Client {

    public static void main(String[] args) {
        //1.获取核心容器对象
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        //2.根据id获取Bean对象
        AccountServiceImpl service = context.getBean("accountService", AccountServiceImpl.class);
        AccountDaoImpl accountDao = context.getBean("accountDao", AccountDaoImpl.class);

        System.out.println(service);
        System.out.println(accountDao);



//        --------------使用BeanFactory创建对象--------


        //这个在执行获取id的时候才会创建对象

//
//        Resource resource = new ClassPathResource("bean.xml");
//        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(resource);
//        AccountServiceImpl accountService = xmlBeanFactory.getBean("accountService", AccountServiceImpl.class);
//        System.out.println(accountService);
    }
}
