package cn.kitey.service.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;
import cn.kitey.utils.TransactionManger;

import java.util.List;

/**
 * 账户的业务实现层
 */
public class AccountServiceImpl_OLD implements AccountService {

    private AccountDao accountDao;
    private TransactionManger tManger;

    public void settManger(TransactionManger tManger) {
        this.tManger = tManger;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    /**
     * 通过IOC容器进行配置
     * @param accountDao
     */
    public void setAccountDao(AccountDaoImpl accountDao) {
        this.accountDao=accountDao;
    }

    public List<Account> findAll() {
        try {
            //1.开启事务
            tManger.beginTransaction();
            //2.执行操作
            List<Account> list = accountDao.findAll();
            //3.提交事务
            tManger.commitTransaction();
            //4.返回结果
            return  list;
        } catch (Exception e) {
            //5.回滚操作
            tManger.rollbackTransaction();
            //产生错误了，程序就不在继续运行
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManger.relaseTransaction();
        }
    }

    public Account findById(Integer accountId) {
        try {
            //1.开启事务
            tManger.beginTransaction();
            //2.执行操作
            Account byId = accountDao.findById(accountId);
            //3.提交事务
            tManger.commitTransaction();
            //4.返回结果
            return byId;
        } catch (Exception e) {
            //5.回滚操作
            tManger.rollbackTransaction();
            //产生错误了，程序就不在继续运行
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManger.relaseTransaction();
        }

    }

    public void saveAccount(Account account) {
        try {
            //1.开启事务
            tManger.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account );
            //3.提交事务
            tManger.commitTransaction();
        } catch (Exception e) {
            //5.回滚操作
            tManger.rollbackTransaction();
            //产生错误了，程序就不在继续运行
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManger.relaseTransaction();
        }

    }

    public void updateAccount(Account account) {
        try {
            //1.开启事务
            tManger.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            tManger.commitTransaction();
        } catch (Exception e) {
            //5.回滚操作
            tManger.rollbackTransaction();
            //产生错误了，程序就不在继续运行
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManger.relaseTransaction();
        }

    }

    public void deleteAccount(Integer accountId) {
        try {
            //1.开启事务
            tManger.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(accountId);
            //3.提交事务
            tManger.commitTransaction();
        } catch (Exception e) {
            //5.回滚操作
            tManger.rollbackTransaction();
            //产生错误了，程序就不在继续运行
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManger.relaseTransaction();
        }


    }


    /**
     * 这里需要在同一个线程中只有一个能控制事务对象
     * @param sourceId
     * @param targetId
     * @param money
     */
    public void transfer(Integer sourceId, Integer targetId, double money) {

        try {
            //1.开启事务
            tManger.beginTransaction();
            //2.执行操作

            //2.1.根据名称查询传出账户
            Account source = accountDao.findById(sourceId);
            //2.2.根据id
            Account target = accountDao.findById(targetId);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney() - money);

            int i =  10/0;

            //2.4.转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);
            //2.6.更新转入账户
            accountDao.updateAccount(target);
            //3.提交事务
            tManger.commitTransaction();

        } catch (Exception e) {
            //5.回滚操作
            tManger.rollbackTransaction();
            //产生错误了，程序就不在继续运行
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManger.relaseTransaction();
        }



    }


}
