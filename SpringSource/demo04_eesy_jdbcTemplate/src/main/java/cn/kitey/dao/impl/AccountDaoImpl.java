package cn.kitey.dao.impl;

import cn.kitey.dao.AccountDao;
import cn.kitey.domain.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class AccountDaoImpl extends JdbcSupport implements AccountDao {



    public List<Account> findAccountById(Integer id) {
        //从父类获取方法
        return  super.getJdbcTemplate().query("select * from account where id =?" ,
                new BeanPropertyRowMapper<Account>(Account.class),id);
    }

    public void InsertAccount(Account account) {
        getJdbcTemplate().update("insert into account(id, uid, money) values (?,?,?)",account.getId(),account.getUid(),account.getMoney());
    }

    public List<Account> findAll() {
        return getJdbcTemplate().query("select * from account" ,
                new BeanPropertyRowMapper<Account>(Account.class));
    }
}
