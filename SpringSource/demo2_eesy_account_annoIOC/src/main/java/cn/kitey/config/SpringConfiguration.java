package cn.kitey.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

/**
 * 是一个配置类，作用跟bean.xml相同
 *
 * spring中新注解：
 * Configuration：
 *      作用：指定当前类是一个配置类
 *      有时可以省略不写
 * ComponentScan
 *      作用：用于通过注解指定spring创建容器要扫面的包
 *      属性
 *          value：basePackage的作用一样，指定要扫描的包名
 *          该注解类似于xml中的：
 *            <context:component-scan base-package="cn.kitey"></context:component-scan>
 *
 * bean:
 *      作用：用于把当前对象的返回值存入spring容器中
 *      属性：
 *          name：用于指定bean的id，不写时，为默认值，当前的方法名
 *      特点：
 *          当使用注解配置方法时，如果方法有参数，spring框架就会去容器查找有没有可用的bean对象
 *          查找的方式跟Autowired注解的作用一样的
 * import：
 *      作用：用于引用其他配置类
 *      value:用于指定其他配置类的字节码
 *            当我梦使用import的注解之后，有import注解的类就为父配置类，导入的为子配置类
 *
 * PropertySource
 *      作用：指定properties文件的位置
 *      属性：
 *          value：指定文件的名称和位置
 *              关键字：classpath 表示类路径下
 */
@Import(jdbcConfig.class)
@Configuration
@ComponentScan(value = "cn.kitey")
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {
}
