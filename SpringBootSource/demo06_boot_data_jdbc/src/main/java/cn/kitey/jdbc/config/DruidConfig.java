package cn.kitey.jdbc.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 数据源配置类
 */
@Configuration
public class DruidConfig {

    /**
     * 将配置添加到容器中
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    //配置Druid的监控
    //1. 配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        HashMap<String, String> map = new HashMap<>();
        map.put("loginUsername","kite");
        map.put("loginPassword","250025");
        map.put("allow","");    //允许所有访问
        map.put("delly","192.168.11.21");   //不允许访问

        //可以配置一定初始化参数
        bean.setInitParameters(map);
        return bean;
    }

    //2. 配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new WebStatFilter());
        HashMap<String, String> stringStringHashMap = new HashMap<>();
        //不拦截那些请求
        stringStringHashMap.put("exclusions","*.js, *.css, /druid");
        bean.setInitParameters(stringStringHashMap);
        //拦截那些请求
        bean.setUrlPatterns(Arrays.asList("/*"));

        return bean;
    }
}



















