package cn.kitey.jdbcTemplate;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的基本用法
 *
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //配属数据连接的数据源（使用spring内部的数据源）
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql:///eesy?characterEncoding=utf8");
        ds.setUsername("root");
        ds.setPassword("25002500");
        //创建jdbcTemplate对象
        JdbcTemplate jt = new JdbcTemplate();
        //设置数据源
        jt.setDataSource(ds);
        //执行数据库操作
        jt.execute("insert into account(id, uid, money) values(12, 2,1000)");

    }
}
