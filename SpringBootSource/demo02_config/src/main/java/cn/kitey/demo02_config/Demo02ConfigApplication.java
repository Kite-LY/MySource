package cn.kitey.demo02_config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


//@ImportResource(value = {"classpath:beans.xml"})  //导入spring 的配置文件。添加该注解后，配置beans.xml才可以生效
@SpringBootApplication
public class Demo02ConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(Demo02ConfigApplication.class, args);
    }

}
