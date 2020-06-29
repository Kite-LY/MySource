package com.kite.dao.impl;

import com.kite.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {

    //创建runner对象
    private QueryRunner queryRunner= new QueryRunner();

    /**
     * update():语句用来执行Insert\Update\Delete语句，特点不需要数据接收返回值
     * @param sql
     * @param args
     * @return 如果返回为-1，说明执行失败， 返回其他表示影响的行数
     */
    public int upDate(String sql, Object ...args){

        System.out.println("BaseDao程序在【"+Thread.currentThread().getName()+"】中");

        //创建连接
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException(e);
        }


    }

    /**
     * 查询返回一个对象的
     *
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */

    public <T> T queryForOne(Class<T> type, String sql, Object ...args){
        Connection conn = JDBCUtils.getConnection();

        try {
            return queryRunner.query(conn, sql, new BeanHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException(e);
        }
    }


    /**
     * 查询返回多个JavaBean对象
     * @param type
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> List<T> queryForList(Class<T> type, String sql, Object ...args){
        Connection conn = JDBCUtils.getConnection();

        try {
            //需要添加conn的数据连接池
            return queryRunner.query(conn, sql, new BeanListHandler<>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException(e);
        }

    }

    /**
     * 查询返回值为一行一列
     * @param sql
     * @param args
     * @return
     */

    public Object queryForSingValue(String sql, Object ...args){

        Connection conn = JDBCUtils.getConnection();
        try {
            return queryRunner.query(conn, sql, new ScalarHandler(), args);
        }catch (SQLException e) {
            e.printStackTrace();
            throw new  RuntimeException(e);
        }

    }

}






























