package cn.kitey.service.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 账户的业务实现层A
 */

@Service("accountService")
public class AccountServiceImpl implements AccountService {

//    当我们使用注解注入的时候set方法不是必要的了
    @Autowired   //自动注入
    private AccountDao accountDao;


    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    public void saveAccount(Account account) {
        accountDao.saveAccount(account );
    }

    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }


}
