package connection;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.Test;


import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Test {

    /**
     * 方式一
     * @throws Exception
     */
    @Test
    public void testGetConnection() throws Exception {
        //获取数据库连接池
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver");
        cpds.setJdbcUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8");
        cpds.setUser("root");
        cpds.setPassword("25002500");

        //通过设置相关的参数，对数据库连接池进行管理
        //设置初始换的数据库连接池中的连接数
        cpds.setInitialPoolSize(1);
        Connection conn = cpds.getConnection();
        System.out.println(conn);

        //销毁c3p0数据连接池
        //DataSources.destroy(cpds);
    }

    /**
     * 使用配置文件
     *
     */
    @Test
    public void test02() throws SQLException {
        ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
        Connection conn = cpds.getConnection();
        System.out.println(conn);

    }
}
