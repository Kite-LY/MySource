package cn.kitey.dao.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 持久层实现类
 */

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    @Autowired  //自动注入
    QueryRunner queryRunner;



    public List<Account> findAll() {
        try {
            return queryRunner.query("select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    public Account findById(Integer accountId) {
        try {
            return queryRunner.query("select * from account where id = ?", new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update("insert into account(id,uid, money) values(?,?,?)", account.getId(),account.getUid(),account.getMoney());
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update("update account set uid = ?, money = ?  where id = ?", account.getUid(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update("delete from account where id = ?",accountId);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
}












































