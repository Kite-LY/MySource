package cn.kitey.controller;

import cn.kitey.exception.SysException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 文件上传控制类
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("testException")
    public String testException() throws SysException {
        System.out.println("testException执行了！");


        try {
            //模拟异常
            int i =1/0;
        } catch (Exception e) {
            //打印异常
            e.printStackTrace();
            throw new SysException("查询的所有用户出现错误");
        }


        return  "success";
    }


}
