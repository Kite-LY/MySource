package Demo01;

import Demo01.Demo01_bean.Customers;
import demoUtils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;

/**
 * 针对Customer表的查询操作
 *
 */
public class CustomersForQuery {

    /**
     * 通用查询方法的测试方法
     *
     */

    @Test
    public void testQueryForCustomers(){
        String sql = "select id, name, email, birth from customers where id = ?";
        Customers customers = queryForCustomers(sql, 2);
        System.out.println(customers);

        String sql1 = "select id, name, birth from customers where name = ?";
        Customers 周杰伦 = queryForCustomers(sql1, "周杰伦");
        System.out.println(周杰伦);

    }
    /**
     * 针对于customers表的通用的查询方法
     *
     */

    public Customers queryForCustomers(String sql, Object ...args) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for(int i = 0; i < args.length; i++) {
                //设置通配符中的值
                ps.setObject(i + 1, args[i]);
            }
            resultSet = ps.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData metaData = resultSet.getMetaData();
            //获取结果集中的列数
            int columnCount = metaData.getColumnCount();

            if(resultSet.next()){
                Customers ct = new Customers();
                for(int i = 0; i < columnCount; i ++){
                    //获取这一列的列值
                    Object columnValue = resultSet.getObject(i + 1);
                    //获取这一列的列名
                    //String columnName = metaData.getColumnName(i + 1);
                    //使用别名
                    String columnLabel = metaData.getColumnLabel(i + 1);

                    //通过反射根据columnName属性，赋值为columnValue给customers对象
                    Field df = Customers.class.getDeclaredField(columnLabel);
                    df.setAccessible(true);
                    df.set(ct,columnValue);
                }
                return ct;

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,ps,resultSet);
        }



        return null; //没有查询到数据
    }

    @Test
    public void testQuery(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtils.getConnection();

            String sql = "select id, name, email, birth from customers where id = ?";
            ps = connection.prepareStatement(sql);

            ps.setObject(1,1);

            //执行并的到返回值
            resultSet = ps.executeQuery();

            if(resultSet.next()){  //判断下一条数据是否含有结果集，有的话返回true
                //获取当前字段的各个字段的结果集
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                Date birth = resultSet.getDate(4);

                //打印数据方式一
                // System.out.println(name);

                //推荐的数据打印方式：将数据封装成为一个对象
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,ps, resultSet);
        }


    }
}








