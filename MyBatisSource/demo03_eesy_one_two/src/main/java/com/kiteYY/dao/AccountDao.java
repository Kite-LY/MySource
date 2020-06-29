package com.kiteYY.dao;


import com.kiteYY.domain.Account;
import com.kiteYY.domain.AccountUser;

import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户的方法
     */
    List<Account> findAllAccount();

    /**
     * 查询所有用户，并且待用用户名名称和地址
     * @return
     */
    List<AccountUser> findUserAccount();
}
