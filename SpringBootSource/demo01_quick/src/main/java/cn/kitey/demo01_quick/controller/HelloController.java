package cn.kitey.demo01_quick.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody   //这个属性表示返回的数据直接写给浏览器，（如果是对象转换为json数据）
//@Controller

@RestController   //这注解为ResponseBod与Controller的合体
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello Kite quick";
    }
}
