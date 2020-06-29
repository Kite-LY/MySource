package cn.kitey.service.impl;

import cn.kitey.service.AccountService;

/**
 * 账户的业务层的实现方法
 */
public class AccountServiceImpl implements AccountService {
    public void saveAccount() {
        System.out.println("执行了保存方法");


    }

    public void updateAccount(int i) {
        System.out.println("执行了更新   "  + i);
    }

    public int deleteAccount() {
        System.out.println("执行的删除方法！");
        return 0;
    }
}
