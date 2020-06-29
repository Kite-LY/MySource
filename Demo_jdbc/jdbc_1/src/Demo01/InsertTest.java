package Demo01;

import demoUtils.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class InsertTest {





    /**
     * 测试从键盘输入进行数据的插入
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入用户名：");
        String name = scanner.nextLine();
        System.out.print("请输入邮箱：");
        String email = scanner.nextLine();
        System.out.print("请输入生日：");
        String birth = scanner.nextLine();
        String sql = "insert into customers(name, email, birth) values(?,?,?) ";
        int i = upDate(sql, name, email, birth);
        if(i == 1){
            System.out.println("添加数据成功！");
        }else{
            System.out.println("添加数据失败！");
        }
    }



    /**
     * 通用怎删改操作
     *
     */
    public static int upDate(String sql, Object ...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            //填充占位符
            for(int i = 0; i < args.length; i++){
                ps.setObject(i+1, args[i]);
            }
            //boolean execute = ps.execute();   //返回值true,则执行了查询操作，有返回结果。false则没有返回结果，为增删改操作
            return ps.executeUpdate();  //返回值1 则为影响了多条数据，返回值0，则没有影响数据
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeResource(connection,ps);
        }

        return 0;

    }
}
