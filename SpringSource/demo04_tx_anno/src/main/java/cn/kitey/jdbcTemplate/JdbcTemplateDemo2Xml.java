package cn.kitey.jdbcTemplate;


import cn.kitey.domain.Account;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

/**
 * JdbcTemplate的基本用法(使用bean.xm的配置方式)
 *
 */
public class JdbcTemplateDemo2Xml {

    public static void main(String[] args) {
        //获取容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        JdbcTemplate jt = context.getBean("jdbcTemplate", JdbcTemplate.class);
        //数据插入
        //jt.execute("insert into account(id, uid, money) values(9, 2,2000)");
        //数据更新
        //jt.update("update account set id = ?, money = ? where uid = ",8,3,2000 );
        //查询所用操作
        List<Account> query = jt.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
        for (Account account : query) {
            //System.out.println(account);
        }
        //查询一个
        List<Account> query1 = jt.query("select * from account where id = ?", new BeanPropertyRowMapper<Account>(Account.class), 1);
       // System.out.println(query1.isEmpty()?"没有查询到相应的数据": query1.get(0));


        //查询条数
        Integer integer = jt.queryForObject("select count(*) from account", Integer.class);
        System.out.println(integer);
    }
}
