package Demo_DAO;

import Demo01.Demo01_bean.Customers;
import demoUtils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;


public class CustomerDAOImplTest {
    private CustomerDAOImpl dao = new CustomerDAOImpl();

    @Test
    public void testGetCount(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            long count = dao.getCount(conn);

            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }



    }
    /**
     * 测试得到表中的数据
     */
    @Test
    public void testGetAll(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            List<Customers> all = dao.getAll(conn);
            for (Customers customers : all) {
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }

    }

    /**
     * 测试数据的修改
     */
    @Test
    public void testUpdate(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = sdf.parse("1922-11-22");
            Customers customers = new Customers(61,"老高","laomo@163.com",new Date(parse.getTime()));
            int update = dao.update(conn, customers);
            if(update == 1){
                System.out.println("数据修改成功！");
            }else {
                System.out.println("数据修改失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }


    }

    /**
     * 测试书数据删除
     */
    @Test
    public void testDeleteByID(){
        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();
            Customers cus = new Customers();
            cus.setId(60);
            dao.deleteByID(connection,cus);
            System.out.println("删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,null);
        }

    }


    /**
     * 测试数据的插入
     */
    @Test
    public void testInsert(){
        Connection conn = null;
        try {
            conn = JDBCUtils.getConnection();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date parse = format.parse("1639-11-22");
            Customers cust = new Customers(21,"老闫","111@testqq.con",new Date(parse.getTime()));
            int insert = dao.insert(conn, cust);
            if(insert == 1){
                System.out.println("添加成功！");
            }else{
                System.out.println("添加失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(conn,null);
        }
    }
}
