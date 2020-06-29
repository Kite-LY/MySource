package cn.kitey.springboot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class loginController {
//    @DeleteMapping
//    PutMapping
//    GetMapping
    @PostMapping(value = "/user/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Map<String,Object> map,
                        HttpSession session){
        //进行判断用户名是否正确
        if(!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功就会存在一个username的值(将username的值存入session)
            session.setAttribute("loginUser", username);
            //防止表单的重复提交，可以使用重定向的方式
            return "redirect:/main.html";
        }else {
            //登录失败
            //存放错误信息
            map.put("msg", "用户名密码错误！");
            return "login";
        }




    }
}
