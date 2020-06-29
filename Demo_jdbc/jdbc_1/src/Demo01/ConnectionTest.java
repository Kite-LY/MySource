package Demo01;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {

    /**
     * 方式一
     * @throws SQLException
     */
    @Test
    public void test01() throws SQLException {

        //获取Driver类的实例对象
        Driver driver = new com.mysql.jdbc.Driver();

        /*
        jdbc:mysql : 协议
        localhost:ip地址
        3306： mysql默认的端口号
        test:test数据库
         */
        String ur1 = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8"; //characterEncoding=utf8 告诉数据库此次连接传输UTF8数据，
                                                                                //项目为UTF8 数据库为其他编码，在持久化时会把项目UTF8的
                                                                                //数据转换为数据库存储的格式；从数据库取数据同理。
                                                                                // 项目和数据库都为UTF8的话，可以不写


        //将用户名密码封装在Properties中
        Properties properties = new Properties();
        properties.setProperty("user","root");
        properties.setProperty("password", "25002500");

        Connection con = driver.connect(ur1,properties);
        System.out.println(con);
    }

    /**
     * 方式二 ：是对方式一的迭代
     *
     */
    @Test
    public void test02() throws Exception {
        //1.使用反射获取Driver对象实例
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //2.提供数据要连接的数据库
        String ur1 = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8";

        //3.提供链接的用户名和密码
        Properties info = new Properties();
        info.setProperty("user","root");
        info.setProperty("password","25002500");

        //4.获取连接
        Connection con1= driver.connect(ur1,info);
        System.out.println(con1);
    }
    /**
     * 方式三: 使用DriverManager替换Driver
     */
    @Test
    public void test03() throws Exception {
        //1.使用反射获取Driver对象实例
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();

        //注册驱动
       // DriverManager.registerDriver(driver);


        Connection root = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?characterEncoding=utf8", "root", "25002500");
        System.out.println(root);
    }

    //方式四：
    @Test
    public void test04() throws Exception {
        //读取配置文件
        InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
        Properties properties = new Properties();
        properties.load(is);

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driverClass = properties.getProperty("driverClass");
        String url = properties.getProperty("url");
        //加载驱动
        Class.forName(driverClass);
        //建立连接
        Connection connection = DriverManager.getConnection(url, user, password);
        System.out.println(connection);
    }
}





















