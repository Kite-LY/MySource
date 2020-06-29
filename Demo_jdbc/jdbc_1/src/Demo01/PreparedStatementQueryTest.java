package Demo01;

import Demo01.Demo01_bean.Customers;
import Demo01.Demo01_bean.Order;
import demoUtils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 使用PreparedStatement对不同的表进行通用的查询条件
 */
public class PreparedStatementQueryTest {


    @Test
    public void testGetForList(){
        String sql ="select id, name, email, birth from customers where id < ?";
        List<Customers> forList = getForList(Customers.class, sql, 12);
        for (Customers customers : forList) {
            System.out.println(customers);
        }
    }


    /**
     * 查询返回多条数据
     *
     */
    public <T> List<T> getForList(Class<T> clazz, String sql, Object ...args){
        //1.数据连接
//        ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
//        Properties properties = new Properties();
//        String user = properties.getProperty("user");
//        String password = properties.getProperty("password");
//        String url = properties.getProperty("url");
//        String classDriver = properties.getProperty("classDriver");
//
//        Class.forName(classDriver);
//
//        Connection connection = DriverManager.getConnection(url, user, password);

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();

            ps = connection.prepareStatement(sql);

            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+ 1, args[i]);
            }
            //获取数据
            rs = ps.executeQuery();
            //获取元数据
            ResultSetMetaData rsmd = ps.getMetaData();
            //获取字段的列数
            int columnCount = rsmd.getColumnCount();
            //创建集合
            List<T> list = new ArrayList<>();
            while(rs.next()){
                T t = clazz.newInstance();
                for(int i = 0; i < columnCount; i++){
                    //存储数据
                    //获取字段名
                    String columnName = rsmd.getColumnLabel(i + 1);
                    Object columnValue = rs.getObject(i + 1);
                    Field field = clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                list.add(t);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(connection, ps, rs);

        }
        return null;
    }



    /**
     * 测试类
     */
    @Test
    public void PreparedStatementQueryTest(){
        String sql = "SELECT order_id orderId, order_name orderName, order_date orderDate FROM `order` WHERE order_id = ?";
        Order instance = getInstance(Order.class, sql, 1);
        System.out.println(instance);

        String sql1 = "select id, name, email, birth from customers where id < ?";
        Customers instance1 = getInstance(Customers.class, sql1, 1);
        System.out.println(instance1);
    }


    /**
     * 通用的查询方法
     * @param clazz
     * @param sql
     * @param args
     * @param <T>
     * @return
     */
    public <T> T getInstance(Class<T> clazz, String sql, Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);

            //给通配符赋值
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = ps.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                T t = clazz.newInstance();  //加载空参构造器
                for (int i = 0; i < columnCount; i++){
                    //获取字段值
                    Object columnVale = rs.getObject(i + 1);
                    //获取字段名
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    Field field = clazz.getDeclaredField(columnLabel);//通过反射确定加载的属性名称
                    field.setAccessible(true);                        //使私用的属性名也可以进行访问
                    field.set(t,columnVale);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection, ps, rs);

        }


        return null;
    }

}
