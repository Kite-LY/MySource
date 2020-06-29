package DataSourceTest;

import Demo01.Demo01_bean.Customers;
import JDBCUtils.JDBCUtils;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;

public class DuirdTest {

    @Test
    public void test01() throws Exception {
        Connection conn = JDBCUtils.getConnertionDruid();
        String sql = "select id, name, email, birth from customers";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        ArrayList<Customers> list = new ArrayList<>();
        while (rs.next()){
            Customers customers = new Customers();//创建一个空参构造器存放数据
            for (int i = 0; i < columnCount; i++) {
                Object columnValue = rs.getObject(i + 1);
                String columnLabel = metaData.getColumnLabel(i + 1);
                Field field = Customers.class.getDeclaredField(columnLabel);
                field.set(customers,columnValue);
            }
            list.add(customers);
        }

        for (Customers customers : list) {
            System.out.println(customers);
        }
    }
}
