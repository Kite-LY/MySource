package com.kiteYY.mybatis.sqlSession.defaults;

import com.kiteYY.mybatis.cfg.Configuration;
import com.kiteYY.mybatis.sqlSession.SqlSession;
import com.kiteYY.mybatis.sqlSession.proxy.MapperProxy;
import com.kiteYY.mybatis.utils.DataSourceUtile;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 */
public class DefaultSqlSession implements SqlSession {

    private Connection conn;
    private Configuration cfg;
    public DefaultSqlSession(Configuration cfg){
        this.cfg = cfg;
        conn = DataSourceUtile.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao接口的字节码
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        //使用代理对象
        Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
                new MapperProxy(cfg.getMappers(),conn)
                );
        return null;
    }

    /**
     * 用于释放对象
     */
    public void close() {
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
