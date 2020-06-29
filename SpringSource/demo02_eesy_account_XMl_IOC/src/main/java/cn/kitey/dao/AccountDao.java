package cn.kitey.dao;

import cn.kitey.domain.Account;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所用
     * @return
     */
    List<Account> findAll();

    /**
     * 按照id进行查询
     * @return
     */
    Account findById(Integer accountId);

    /**
     * 数据的保存
     */
    void saveAccount(Account account);

    /**
     * 数据的更新操作
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 数据的删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);
}
