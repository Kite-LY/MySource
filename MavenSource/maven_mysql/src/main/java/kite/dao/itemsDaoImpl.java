package kite.dao;

import kite.domian.items;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class itemsDaoImpl implements itemsDao {
    /**
     * 连接数据库注意四个要素：数据库驱动，数据库地址，用户名，用户密码。  四者缺一不可！
     * @return
     */
    public List<items> findAll() {
        List<items> list = null;
        Connection connection = null;
        CallableStatement pst = null;
        ResultSet resultSet = null;
        try {
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
            //先获取connection对象
            connection = DriverManager.getConnection("jdbc:mysql:///book?characterEncoding=utf8","root","25002500");
            //获取真正操作数据的对象
            pst = connection.prepareCall("select * from t_book");
            //执行数据库查询操作(得到查询结果)
            resultSet = pst.executeQuery();
            //创建list集合
            list = new ArrayList<items>();
            while(resultSet.next()){
                items items = new items();
                items.setId(resultSet.getInt("id"));
                items.setBookname(resultSet.getString("name"));
                list.add(items);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                resultSet.close();

                pst.close();

                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return list;
    }
}
