package cn.kitey.dao.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl extends JdbcSupport implements AccountDao {



    public Account findAccountById(Integer id) {
        //从父类获取方法
        List<Account> accounts = super.getJdbcTemplate().query("select * from account where id =?" ,
                new BeanPropertyRowMapper<Account>(Account.class),id);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public void InsertAccount(Account account) {
        getJdbcTemplate().update("insert into account(id, uid, money) values (?,?,?)",account.getId(),account.getUid(),account.getMoney());
    }

    public List<Account> findAll() {
        return getJdbcTemplate().query("select * from account" ,
                new BeanPropertyRowMapper<Account>(Account.class));
    }

    public void update(Account account) {
        getJdbcTemplate().update("update account set uid = ?, money = ?  where id = ?" , account.getUid(),account.getMoney(),account.getId());
    }


}
