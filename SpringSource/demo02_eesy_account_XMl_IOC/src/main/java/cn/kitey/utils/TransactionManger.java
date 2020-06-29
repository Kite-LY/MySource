package cn.kitey.utils;

import java.sql.SQLException;

/**
 * 和事务管理相关的工具类，包含了，开启事务，提交事务，回滚事务，释放连接
 */
public class TransactionManger {

    private ConnectionUtils connectionUtils;

    /**
     * 定义set方法，可以通过IOC容器注入
     * @param connectionUtils
     */
    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * 提交事务
     */
    public void commitTransaction(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放事务
     */
    public void relaseTransaction(){
        try {
            //将连接归还到数据连接池
            connectionUtils.getThreadConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
