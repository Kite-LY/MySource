package cn.kitey.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * 连接的工具类，用于获取数据源中的一个连接，并且实现线程的绑定
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    DataSource dataSource;

    /**
     * 用于从IOC中注入
     * @param dataSource
     */
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getThreadConnection(){
        try {
            //1.先从ThreadLocal上获取
            Connection conn = threadLocal.get();
            //2.判断当前线程上是否存在连接
            if(conn == null){
                conn = dataSource.getConnection();
                threadLocal.set(conn);
            }
            //返回当前线程的连接
            return conn;
        } catch (SQLException e) {

            throw new RuntimeException(e);
        }


    }

    /**
     * 把连接与线程解绑了
     */
    public void removeConnection(){
        //移除连接
        threadLocal.remove();

    }
}
