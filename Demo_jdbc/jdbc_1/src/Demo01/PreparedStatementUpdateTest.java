package Demo01;

import demoUtils.JDBCUtils;
import org.junit.Test;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

/**
 * 使用PreparedStatement代替Statement，实现对数据库的增删改查
 *
 */
public class PreparedStatementUpdateTest {


    @Test
    public void testDelete(){
//        String sql = "delete from customers where id = ?";
//        update(sql,23);

        String sql = "update `order` set order_name = ? where order_id = ?";
        update(sql, "DD", 2);


//        String sql = "update customers set name = ? where id = ?";
//        update(sql,"张飞",23);

//        Connection connection = JDBCUtils.getConnection();
//        String sql = "delete from customers where id = ?";
//        PreparedStatement preparedStatement = connection.prepareStatement(sql);
//        preparedStatement.setObject(1,21);
//
//        preparedStatement.execute();
//        preparedStatement.close();
//        connection.close();
    }

    /**
     * 通用的增删改操作
     *
     */
    public void update(String sql, Object ...args){   //sql中占位符的数目应该跟args的长度相同
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //创建连接
            connection = JDBCUtils.getConnection();
            //预编译
            ps = connection.prepareStatement(sql);
            //填充通配符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);  //注意在sql中索引的第一位从1开始
            }
            //执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            JDBCUtils.closeResource(connection,ps);

        }

    }

    @Test
    public void testUpdate(){
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1.建立数据库连接
            conn = JDBCUtils.getConnection();
            //2.预编译sql语句，返回PreparedStatement实例
            String sql = "update customers set name = ? where id = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, "关羽");
            ps.setObject(2,20);

            //3.语句的执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            //4.资源的关闭
            JDBCUtils.closeResource(conn, ps);
        }

    }


    /**
     * 向数据库中插入一条数据
     *
     */
    @Test
    public void testInsert(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //1.获取连接
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            properties.load(is);
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
            //加载驱动
            Class.forName(driverClass);
            //建立连接
            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);

            //2.sql语句预编译
            String sql = "insert into customers(name, email, birth) values(?,?,?)";  //? 为占位符
            ps = connection.prepareStatement(sql);

            //3.填充占位符号
            ps.setString(1,"刘备");
            ps.setString(2,"111@qq.com");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date parse = format.parse("1639-11-22");
            ps.setDate(3,new java.sql.Date(parse.getTime()));

            //4执行操作
            ps.execute();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {

            //5.资源的关闭
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }




    }
}
