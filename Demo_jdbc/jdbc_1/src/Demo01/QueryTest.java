package Demo01;

import Demo01.Demo01_bean.Student;
import demoUtils.JDBCUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class QueryTest {


    /**
     * 根据身份证号码或者准考证号码查询学生信息
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("请选择你要查询的数据类型：a.准考证号   b.身份证号");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        if("a".equalsIgnoreCase(choice)){
            System.out.print("请输入准考证号：");
            String examCard = scanner.next();
            String sql = "select FlowID flowId, Type type, IDcard, ExamCard examCard, StudentName name, Location location, Grade grade from examstudent where ExamCard = ?";

            List<Student> students = QueryForList(Student.class, sql, examCard);
            if(students != null){
                for (Student student : students) {
                    System.out.println(student);
                }
            }
                System.out.println("没有查询到相应数据！");



        }else if("b".equalsIgnoreCase(choice)){
            System.out.print("请输入身份证号：");
            String IDCard = scanner.next();
        }else{
            System.out.println("您的输入有误！");
        }
    }

    /**
     * 通用的查询方法
     *
     */
    public static <T> List<T> QueryForList(Class<T> clazz, String sql, Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //建立连接
            InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
            Properties properties = new Properties();
            //加载配置文件
            properties.load(is);
            //读取配置文件
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            String url = properties.getProperty("url");
            String driverClass = properties.getProperty("driverClass");
            //加载驱动
            Class.forName(driverClass);
            //连接建立
            connection = DriverManager.getConnection(url, user, password);

            ps = connection.prepareStatement(sql);
            //填充占位符
            for(int i = 0; i < args.length; i++){
                ps.setObject(i +1, args[i]);
            }
            //得到查询结果
            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<T> list = new ArrayList<>();
            while(rs.next()){
                T t = clazz.newInstance();  //创建空参构造器
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = metaData.getColumnLabel(i + 1);
                    //利用反射接受数据
                    Field df = clazz.getDeclaredField(columnLabel);
                    df.setAccessible(true);
                    df.set(t, columnValue);
                }
                list.add(t);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            //资源的关闭
            JDBCUtils.closeResource(connection, ps, rs);
        }

        return null;



    }

}
