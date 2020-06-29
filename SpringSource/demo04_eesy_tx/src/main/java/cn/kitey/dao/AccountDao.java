package cn.kitey.dao;

import cn.kitey.domain.Account;

import java.util.List;

/**
 * 账户的持久层接口
 */
public interface AccountDao {

    Account findAccountById(Integer id);

    void InsertAccount(Account account);

    List<Account> findAll();

    void update(Account account);
}
