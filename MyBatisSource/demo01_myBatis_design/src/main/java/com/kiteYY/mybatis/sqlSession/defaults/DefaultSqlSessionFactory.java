package com.kiteYY.mybatis.sqlSession.defaults;

import com.kiteYY.mybatis.cfg.Configuration;
import com.kiteYY.mybatis.sqlSession.SqlSession;
import com.kiteYY.mybatis.sqlSession.SqlSessionFactory;


/**
 * SqlSessionFactory接口的实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private Configuration cfg;

    //创建实现类：接受SqlSessionFactory返回的cfg信息
    public DefaultSqlSessionFactory(Configuration cfg){
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}
