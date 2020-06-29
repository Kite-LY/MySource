package Demo_Blob;

import Demo01.Demo01_bean.Customers;
import demoUtils.JDBCUtils;
import org.junit.Test;

import java.io.*;
import java.sql.*;

public class BlobTest {

    //执行查询操作
    @Test
    public void QueryBlob(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "SELECT id, name, email, birth, photo from customers where id = ?";
            ps = connection.prepareStatement(sql);
            //填充占位符
            ps.setObject(1,16);
            rs = ps.executeQuery();
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                Date birth = rs.getDate("birth");
                Customers customers = new Customers(id, name, email, birth);
                System.out.println(customers);
                Blob photo = rs.getBlob("photo");
                //blob字段下载并且进行保存
                InputStream binaryStream = photo.getBinaryStream();
                FileOutputStream fos = new FileOutputStream(new File("Blob2.jpg"));
                byte[] buffer = new byte[1024];
                int len;
                while((len = binaryStream.read(buffer)) != -1){
                    fos.write(buffer,0, len);
                }fos.close();
                binaryStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {


            JDBCUtils.closeResource(connection,ps,rs);

        }

    }

    //向customers中插入类型字段Blob
    @Test
    public void testInsert(){
        Connection connection = null;
        PreparedStatement ps = null;
        FileInputStream fis = null;
        try {
            connection = JDBCUtils.getConnection();
            String sql = "insert into customers(name, email, birth, photo) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,"赵云");
            ps.setObject(2,"222@163.com");
            ps.setObject(3,"1778-11-22");
            fis = new FileInputStream(new File("Blob1.jpg"));
            ps.setBlob(4, fis);

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            JDBCUtils.closeResource(connection,ps);
        }

    }
}
