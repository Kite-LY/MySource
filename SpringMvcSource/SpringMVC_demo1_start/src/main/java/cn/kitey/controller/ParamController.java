package cn.kitey.controller;


import cn.kitey.domain.Account;
import cn.kitey.domain.Iter;
import cn.kitey.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/params")
public class ParamController {


    @RequestMapping(path = "/testParam")
    public String testParam(String username, String password){
        System.out.println("testParam执行了。。。");
        System.out.println("用户名：" + username);
        System.out.println("用户密码：" + password);

        return "success";
    }

    /**
     * 把参数绑定数据封装数据到JavaBean中
     * @param account
     * @return
     */
    @RequestMapping(path = "/saveAccount" ,method = {RequestMethod.POST})
    public String saveAccount(Account account){
        System.out.println("Account中的数据");
        System.out.println(account);
        return "success";
    }

    @RequestMapping(path = "/saveIter" ,method = {RequestMethod.POST})
    public String saveIter(Iter iter){
        System.out.println("Account中的数据");
        System.out.println(iter);
        return "success";
    }

    @RequestMapping(path = "/saverUser")
    public String saveUser(User user){
        System.out.println("SaveUser执行了");
        System.out.println(user);
        return "success";
    }
}
