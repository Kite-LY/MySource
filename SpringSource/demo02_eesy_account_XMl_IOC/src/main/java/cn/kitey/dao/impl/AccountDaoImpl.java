package cn.kitey.dao.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import cn.kitey.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 持久层实现类
 */

public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner;
    private ConnectionUtils connectionUtils;

    /**
     * 从spring中注入相关数据
     * @param connectionUtils
     */
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 从spring中配置
     * @param queryRunner
     */
    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAll() {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account",
                    new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    public Account findById(Integer accountId) {
        try {
            return queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where id = ?", new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }

    }

    public void saveAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"insert into account(id,uid, money) values(?,?,?)", account.getId(),account.getUid(),account.getMoney());
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    public void updateAccount(Account account) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"update account set uid = ?, money = ?  where id = ?", account.getUid(),account.getMoney(),account.getId());
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    public void deleteAccount(Integer accountId) {
        try {
            queryRunner.update(connectionUtils.getThreadConnection(),"delete from account where id = ?",accountId);
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }

    public Account findAccountByName(String accountName) {
        try {
            List<Account> accounts = queryRunner.query(connectionUtils.getThreadConnection(),"select * from account where name = ?",
                    new BeanListHandler<Account>(Account.class),accountName);
            if(accounts == null|| accounts.size() == 0){
                return null;
            }else if(accounts.size() > 1){
                throw new RuntimeException("结果不唯一，数据错误");
            }else{
                return accounts.get(0);
            }
        } catch (SQLException e) {
            throw new  RuntimeException(e);
        }
    }
}












































