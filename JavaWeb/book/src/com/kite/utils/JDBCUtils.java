package com.kite.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtils {

    //创建连接池
    private static DruidDataSource dataSource;
    //创建一个保存连接的threadLocal
    private static ThreadLocal<Connection> conns = new ThreadLocal<>();
    static {
        Properties properties = new Properties();
        try {
            //通过流读取jdbc.properties属性配置文件 注意不能使用ClassLoader加载，应该使用JDBCUtils加载
            InputStream inputStream = JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
             properties.load(inputStream);
            //创建数据连接池
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    /**
     * 获取连接
     * @return
     */
    public static Connection getConnection(){
        Connection conn = conns.get();

        if(conn == null){
            try {
                //获取链接
                conn = dataSource.getConnection();
                //保存到ThreadLocal对象中，供后面的jdbc使用
                conns.set(conn);
                //设置提交为默认提交（设置为手动管理业务）
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }


    /**
     * 提交事务，并且关闭释放连接
     */
    public static void commitAndClose(){
        //获取threadLocal中的连接
        Connection connection = conns.get();
        if(connection != null){
            //不是空的时候说明之前使用过此链接
            try {
                connection.commit();  //提交事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();  //关闭连接释放资源！
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要使用remove()操作（Tomcat底层使用的为线程池技术）
        conns.remove();
    }

    /**
     * 回滚事务，并且关闭释放连接
     */
    public static void rollbackAndClose(){
        //获取threadLocal中的连接
        Connection connection = conns.get();
        if(connection != null){
            //不是空的时候说明之前使用过此链接
            try {
                connection.rollback();  //回滚事务
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close();  //关闭连接释放资源！
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要使用remove()操作（Tomcat底层使用的为线程池技术）
        conns.remove();
    }






    /**
     * 关闭连接
     * @param conn


    public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
*/
}
