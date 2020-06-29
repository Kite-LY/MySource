package cn.kitey.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * spring配置类
 */
@Configuration
@ComponentScan("cn.kitey")
@Import({jdbcConfig.class,transactionConfig.class})
@PropertySource("jdbcConfig.properties")  //注入配置文件内容
@EnableTransactionManagement   //开启事务支持
public class SpringConfiguration {
}
