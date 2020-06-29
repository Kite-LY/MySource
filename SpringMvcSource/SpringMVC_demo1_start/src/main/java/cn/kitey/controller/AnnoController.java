package cn.kitey.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

/**
 * 常用注解的控制类
 */
@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"})   //将msg = 妹妹存入session域
public class AnnoController {
    @RequestMapping("testRequestParam")
    //RequestParam 添加了该注解，如果不传name 就会报错
    public String testRequestParam(@RequestParam(name="name") String username){
        System.out.println("testRequestParam执行了。。。。");
        System.out.println(username);
        return "success";
    }


    /**
     * 获取请求体内容
     * @param body
     * @return
     */
    @RequestMapping("/testRequestBody")
    //RequestParam 添加了该注解，如果不传name 就会报错
    public String testRequestBody(@RequestBody String body){
        System.out.println("testRequestParam执行了。。。。");
        System.out.println(body);
        return "success";
    }


    /**
     * PathVariable注解
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{sid}")
    //RequestParam 添加了该注解，如果不传name 就会报错
    public String testPathVariable(@PathVariable(name = "sid") String id){
        System.out.println("testRequestParam执行了。。。。");
        System.out.println(id);
        return "success";
    }

    /**
     * 创建requestScope中存值
     * @param model
     * @return
     */
    @RequestMapping(value = "/testSessionAttributes")
    //RequestParam 添加了该注解，如果不传name 就会报错
    public String testSessionAttributes(Model model){
        System.out.println(" testSessionAttributes;。。。。");
        model.addAttribute("msg", "妹妹");
        return "success";
    }

    /**
     * 获取session的值
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/testGetSessionAttributes")
    public String testGetSessionAttributes(ModelMap modelMap){
        System.out.println(" testSessionAttributes;。。。。");
        String msg = (String)modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    @RequestMapping(value = "/testDeleteSessionAttributes")
    public String testDeleteSessionAttributes(SessionStatus status){
        System.out.println(" testDeleteSessionAttributes。。。。");
        //删除session中的值
        status.setComplete();
        return "success";
    }
}





















