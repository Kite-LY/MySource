package cn.kitey.service.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.dao.impl.AccountDaoImpl;
import cn.kitey.domain.Account;
import cn.kitey.service.AccountService;

import java.util.List;

/**
 * 账户的业务实现层
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;


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

        return accountDao.findAll();

    }

    public Account findById(Integer accountId) {
      return accountDao.findById(accountId);


    }

    public void saveAccount(Account account) {

            accountDao.saveAccount(account );

    }

    public void updateAccount(Account account) {

            accountDao.updateAccount(account);


    }

    public void deleteAccount(Integer accountId) {

            accountDao.deleteAccount(accountId);



    }


    /**
     * 这里需要在同一个线程中只有一个能控制事务对象
     * @param sourceId
     * @param targetId
     * @param money
     */
    public void transfer(Integer sourceId, Integer targetId, double money) {
              System.out.println("转账前");
            //2.1.根据名称查询传出账户
            Account source = accountDao.findById(sourceId);
            //2.2.根据id
            Account target = accountDao.findById(targetId);
            //2.3.转出账户减钱
            source.setMoney(source.getMoney() - money);



            //2.4.转入账户加钱
            target.setMoney(target.getMoney() + money);
            //2.5.更新转出账户
            accountDao.updateAccount(source);
            //2.6.更新转入账户
            accountDao.updateAccount(target);

             System.out.println("转账成功");
    }


}
