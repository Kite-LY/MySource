package Demo01_transaction;

import demoUtils.JDBCUtils;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 什么叫做数据库事务：
 * 事务：一组逻辑操作端元，使数据从一种状态转换为另一种事务
 *       > 一组逻辑操作单元，  一个或者DML操作
 *
 */
public class TransactionTest {

    /**
     * 针对数据表user_table来说
     * AA向BB转账100
     */
    @Test
    public void testUpdate() {
        String sql = "update user_table set balance = balance - 100 where user = ?";
        update(sql, "AA");

        System.out.println(10 / 0);

        String sql2 = "update user_table set balance = balance + 100 where user = ?";
        update(sql2, "BB");

        System.out.println("转账成功！");
    }

    @Test
    public void testpDUatUeWitTX() throws Exception {

        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            //关闭自动提交
            System.out.println(conn.getAutoCommit());
            conn.setAutoCommit(false);
            String sql = "update user_table set balance = balance - 100 where user = ?";
            upDateWitTX(conn, sql, "AA");

            System.out.println(10 / 0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            upDateWitTX(conn, sql2, "BB");

            System.out.println("转账成功！");

            //提交数据
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            //数据回滚
            conn.rollback();
        } finally {
            JDBCUtils.closeResource(conn, null);
        }


    }


    /**
     * 考虑数据操作的事务问题
     */
    public void upDateWitTX(Connection conn, String sql, Object... args) {
        PreparedStatement ps = null;
        try {
            //预编译
            ps = conn.prepareStatement(sql);
            //填充通配符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);  //注意在sql中索引的第一位从1开始
            }
            //执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            JDBCUtils.closeResource(null, ps);

        }
    }


    /**
     * 通用的增删改操作
     */
    public void update(String sql, Object... args) {   //sql中占位符的数目应该跟args的长度相同
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //创建连接
            connection = JDBCUtils.getConnection();
            //预编译
            ps = connection.prepareStatement(sql);
            //填充通配符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);  //注意在sql中索引的第一位从1开始
            }
            //执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            JDBCUtils.closeResource(connection, ps);

        }

    }

}































