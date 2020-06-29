package com.kiteYY.dao;


import com.kiteYY.domain.Account;


import java.util.List;

public interface AccountDao {

    /**
     * 查询所有账户的方法
     */
    List<Account> findAllAccount();


}
