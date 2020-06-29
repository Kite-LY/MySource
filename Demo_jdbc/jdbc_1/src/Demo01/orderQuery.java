package Demo01;

import Demo01.Demo01_bean.Order;
import demoUtils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对表的字段名与类的属性名不同时：
 * 1.必须声明sql时，使用类的属性名来命名字段的别名
 * 2.使用ResultSetMetaDate时，需要使用getColumnLabel()来代替getColumnName()
 *      注意：字段中中没有别名，getColumnLabel可以获取字段名
 */
public class orderQuery {


    @Test
    public void testOrderQuery(){
        String sql = "SELECT order_id orderId, order_name orderName, order_date orderDate from `order` WHERE order_id = ?";
        Order order = orderQuery(sql, 1);
        System.out.println(order);
    }

    /**
     * 针对于Order表的查询操作
     *
     */
    public Order orderQuery(String sql, Object ...args){

        Connection ct = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ct = JDBCUtils.getConnection();
            ps = ct.prepareStatement(sql);
            //填充通配符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsmd = rs.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            while (rs.next()){
                Order order = new Order();
                for(int i = 0; i < columnCount; i++){
                    //获取列值：通过ResultSet
                    Object columnValue = rs.getObject(i + 1);
                    //获取列名：ResultSetMetaData    //不推荐使用
                    //String columnName = rsmd.getCatalogName(i + 1);

                    //获取列的别名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //通过反射存储数据
                    Field field = Order.class.getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(order,columnValue);
                }
                return order;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(ct, ps, rs);

        }



        return null;
    }

    @Test
    public void testOrderQuery1(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "select order_id, order_name, order_date from `order` where order_id = ?";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,2);

            resultSet = ps.executeQuery();
            if(resultSet.next()){
                int id = (int) resultSet.getObject(1);
                String name = resultSet.getString(2);
                Date date = resultSet.getDate(3);

                Order order = new Order(id, name, date);
                System.out.println(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(connection, ps, resultSet);
        }


    }
}
