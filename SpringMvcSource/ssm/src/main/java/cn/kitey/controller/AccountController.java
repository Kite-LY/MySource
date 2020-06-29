package cn.kitey.controller;

import cn.kitey.domain.Account;
import cn.kitey.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 账户web控制层（表现层）
 */
@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired  //自动注入
    private AccountServiceImpl accountService;

    /**
     *
     * @param model  获取存储对象
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(Model model){
        System.out.println("查询所有用户！");
        List<Account> all = accountService.findAll();
        model.addAttribute("list",all);

        return "list";
    }

    @RequestMapping("/save")
    public void saveAccount(Account account, HttpServletRequest request, HttpServletResponse response){
        accountService.saveAccount(account);
        //重定向
        try {
            response.sendRedirect(request.getContextPath() + "/account/findAll");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
