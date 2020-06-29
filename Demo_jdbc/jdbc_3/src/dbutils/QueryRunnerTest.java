package dbutils;

import Demo01.Demo01_bean.Customers;
import JDBCUtils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * commons-dbutils是Apache组织提供和的一个开源的jdbc工具类，封装了对数据库的增删改查操作
 *
 */
public class QueryRunnerTest {
    QueryRunner queryRunner = new QueryRunner();
    /**
     * 数据的插入
     */
    @Test
    public void testInsert(){
        Connection conn = null;
        try {

            conn = JDBCUtils.getConnertionDruid();
            String sql ="insert into customers(name, email, birth)values(?,?,?)";
            int update = queryRunner.update(conn, sql, "老莫！", "qwwr@163.com", new Date(1999 - 11 - 22));

            System.out.println("添加了"+ update + "条记录！");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);

        }

    }

    /**
     * 数据的查询:
     * BeanListHandler:用于封装表中的多条记录
     */
    @Test
    public void testQuery() throws Exception {

        Connection conn = JDBCUtils.getConnertionDruid();
        String sql = "select id, name, email, birth from customers where id < ?";
        BeanListHandler<Customers> handler = new BeanListHandler<>(Customers.class);
        List<Customers> query = queryRunner.query(conn, sql, handler, 12);
        for (Customers customers : query) {
            System.out.println(customers);
        }

    }


    /**
     *ScalarHandler ：用于查询特殊值
     */
    @Test
    public void testQuery1(){

        Connection conn = null;
        try {
            conn = JDBCUtils.getConnertionDruid();
            String sql = "select count(*) from customers";
            ScalarHandler handler1 = new ScalarHandler();
            long query = (long) queryRunner.query(conn, sql, handler1);
            System.out.println(query);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }



    }
}
