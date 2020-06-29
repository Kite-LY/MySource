package JDBCUtils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {

    private static DataSource source;
    static{
        try {
            Properties pro = new Properties();
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);

            source = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
    }


    /**
     * 使用Druid实现数连接池的连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnertionDruid() throws SQLException {

        Connection conn = source.getConnection();

        return conn;

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
