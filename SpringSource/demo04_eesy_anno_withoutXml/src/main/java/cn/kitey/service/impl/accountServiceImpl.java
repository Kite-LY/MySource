package cn.kitey.service.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
@Transactional  //事务注解
public class accountServiceImpl  implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    public void transfer(Integer sourceId, Integer targetId, double money) {
        System.out.println("转账操作");
        //1.获取转出账户
        Account accountById = accountDao.findAccountById(sourceId);
        //2.获取转入账户
        Account accountById1 = accountDao.findAccountById(targetId);
        //3.传出减钱
        accountById.setMoney(accountById.getMoney() - money);
        //4.转入加钱


        //int i = 1/0;
        accountById1.setMoney(accountById1.getMoney() + money);
        //5.账户数据更新
        accountDao.update(accountById);

        accountDao.update(accountById1);
    }
}
