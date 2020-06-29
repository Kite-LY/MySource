package cn.kitey.demo02_config.config;


import cn.kitey.demo02_config.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBoot推荐给容器夹组件的方式；推荐使用全注解
 */
@Configuration  //知名该类为配置类
public class MyConfig {

    /**
     * 将方法的返回值添加到容器中；容器中的这个组件默认的id就是方法名
     * @return
     */
    @Bean
     public HelloService helloService(){
        System.out.println("配置类@Bean给容器中添加了组件！");
        return new HelloService();
    }
}
