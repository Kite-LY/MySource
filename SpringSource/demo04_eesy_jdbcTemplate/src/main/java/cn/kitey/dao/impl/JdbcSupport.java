package cn.kitey.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * 这个用于抽取dao代码中的重复代码块
 */
public class JdbcSupport {
    private JdbcTemplate jdbcTemplate;


    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    //使用spring数据注入的方式
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
