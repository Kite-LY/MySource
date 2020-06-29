package cn.kitey.service;

import cn.kitey.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {

    Account findAccountById(Integer id);

    void transfer(Integer sourceId, Integer targetId , double money);
}
