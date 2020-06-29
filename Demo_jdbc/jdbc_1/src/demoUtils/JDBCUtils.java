package demoUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 *数据库连接的工具类
 *
 */
public class JDBCUtils {
    /**
     *
     * 建立数据库连接
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {

        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driverClass = properties.getProperty("driverClass");

        //加载驱动
        Class.forName(driverClass);

        Connection connection = DriverManager.getConnection(url, user, password);
        return connection;


    }

    /**
     * 数据库连接的关闭， statement操作的关闭
     *
     * @param conn
     * @param st
     */
    public static void closeResource(Connection conn, Statement st){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 查询数据资源的关闭
     *
     * @param conn
     * @param st
     * @param rs
     */

    public static void closeResource(Connection conn, Statement st, ResultSet rs){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(st != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(rs != null){
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
