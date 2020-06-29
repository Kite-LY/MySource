package Demo02;

import demoUtils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * 使用PrepareStatement实现批量数据的插入
 *
 * 向goods中扎入两万条数据
 *
 */
public class InsertTest {

    /**
     * 使用PrepareStatement执行数据的批量插入
     *
     */
    @Test
    public void testInsert1() {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            long strat = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            String sql = "insert into goods(name) values (?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 2000; i++) {
                ps.setObject(1,"name_" + 1);
                ps.execute();
            }
            long end = System.currentTimeMillis();
            System.out.println("花费的时间是：" + (end - strat));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(conn, ps);
        }


    }

    /**
     * 批量操作方式三：
     * 1.addBatch(), executeBath(), clearBath()
     */
    @Test
    public void testInsert2(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            long strat = System.currentTimeMillis();
            conn = JDBCUtils.getConnection();
            //连接不允许提交
            conn.setAutoCommit(false);

            String sql = "insert into goods(name) values (?)";
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < 2000; i++) {
                ps.setObject(1,"name_" + 1);
                //ps.execute();
                //1.攒sql
                ps.addBatch();
                if(i % 1000 == 0){
                    //执行
                    ps.executeBatch();
                    //清空
                    ps.clearBatch();
                }

            }
            //提交数据
            conn.commit();
            long end = System.currentTimeMillis();
            System.out.println("花费的时间是：" + (end - strat));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(conn, ps);
        }

    }
}
