package cn.kitey.springboot.config;


import cn.kitey.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置类
 * 使用WebMvcConfigurerAdapter可以来扩展SpringMVC的功能
 * */
@Configuration
public class MyMVCConfig extends WebMvcConfigurerAdapter {




//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//
//        //浏览器发送/kite请求来到success页面
//        registry.addViewController("/kite").setViewName("/success");
//    }


    /**
     * 所有的WebMvcConfigurerAdapter组件会一起起作用
     * @return
     */
    @Bean   //将组件注册在容器中
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            /**
             * 注册拦截器
             * @param registry
             */
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //告诉拦截器，那些进行拦截，那些不进行拦截
                //SpringBoot已经做好了静态资源的映射，所以也可进行正常访问
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
//                        .excludePathPatterns("/","/index.html","/user/login");

            }
        };
        return adapter;
    }

    //将我们获取的国际化信息传入容器
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }

}
