package cn.kitey.service;

import cn.kitey.domain.Account;

import java.util.List;

/**
 * 实现层接口
 */
public interface AccountService {
    public List<Account> findAll();
    public void saveAccount(Account account);
}
