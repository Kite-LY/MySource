package cn.kitey.service.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 实现层接口的实现类
 */
@Service("accountService")   //添加注解，将其交给IOC容器管理
public class AccountServiceImpl implements AccountService {

    //创建accountDao对象
    @Autowired    //自动注入
    private AccountDao accountDao;

    @Override
    public List<Account> findAll() {
        System.out.println("业务层：查询所有用户");
        List<Account> all = accountDao.findAll();
        return all;
    }

    @Override
    public void saveAccount(Account account) {
        System.out.println("业务层：保存用户！");
        accountDao.saveAccount(account);
    }
}
