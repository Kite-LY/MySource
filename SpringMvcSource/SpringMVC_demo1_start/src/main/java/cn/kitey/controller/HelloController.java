package cn.kitey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器类
 */
@Controller   //交给ioc容器进行管理：控制器Controller负责处理由DispatcherServlet分发的请求，它把用户请求的数据经过业务处理层处理之后封装成一个Model ，然后再把该Model返回给对应的View进行展示。
@RequestMapping(path = "/user")   //可以在类上添加注解
public class HelloController {

    @RequestMapping(path="/hello") //@RequestMapping来映射Request请求与处理器
    public String Hello(){
        System.out.println("Hello SpringMvc");
        return "success";
    }
    //method:请的方法 当为method = {RequestMethod.POST  Request method 'GET' not supported
    //params:用于指定限制请求参数条件。支持简单的表达式，要求请求参数的key value 与配置信息必须一样
    //headers = {"Accept"}  表示发送的请求必须包含该请求头
    @RequestMapping( path = "/testRequestMapping" , params = {"username=kite"}, headers = {"Accept"})
    public String testRequestMapping(){
        System.out.println("testRequestMapping注解");
        return "success";
    }

}
