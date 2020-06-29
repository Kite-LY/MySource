package cn.kitey.demo02_config;

import cn.kitey.demo02_config.bean.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * SpringBoot单元测试
 *
 * 可以在测试期间很方便的类似编码一样的进行自动注入等操作
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class Demo02ConfigApplicationTests {

    @Autowired
    Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void contextLoads() {

        System.out.println(person);
    }

    @Test
    public void testHelloService(){
        boolean helloService = ioc.containsBean("helloService");
        System.out.println(helloService);
    }

}
