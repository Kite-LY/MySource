package cn.kitey.service.impl;

import cn.kitey.dao.IAccountDao;
import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.service.IAccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    IAccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl() {
        System.out.println("AccountServiceImpl对象创建了！");
    }

    public void  saveAccount(){

        accountDao.saveAccount();
    }
}
