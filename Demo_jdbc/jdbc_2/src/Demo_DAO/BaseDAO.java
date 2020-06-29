package Demo_DAO;

import demoUtils.JDBCUtils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDAO<T> {

    private Class<T> clazz = null;
    //使用代码块：获取当前BaseDAO的子类继承的父类中的泛型
    {
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType parameterizedType = (ParameterizedType) genericSuperclass;

        //获取父类的泛型参数集合
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        //泛型的第一个参数
        clazz = (Class<T>) actualTypeArguments[0];
    }
    /**
     * 用于查询特殊值的操作
     * @param conn
     * @param sql
     * @param argd
     * @param <E>
     * @return
     */
    public <E> E getValue(Connection conn, String sql, Object ...argd){
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for (int i = 0; i < argd.length; i++) {
                ps.setObject(i + 1, argd[i]);
            }
            rs = ps.executeQuery();
            if(rs.next()){
                return  (E) rs.getObject(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            JDBCUtils.closeResource(null,ps,rs);
        }


        return null;
    }

    /**
     * 通用的查询操作(考虑到了事务让链接从外面进行传入)
     */
    public int update(Connection conn, String sql, Object ...args)  {
        PreparedStatement ps = null;
        try {
            //预编译sql语句，返回实例
            ps = conn.prepareStatement(sql);
            //填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i +1, args[i]);
            }
            //执行
            int i = ps.executeUpdate();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //资源关闭
            JDBCUtils.closeResource(null,ps);
        }
        return 0;
    }


    /**
     * 通用的查询操作(考虑到事务)
     */
    public List<T> getInstance(Connection conn,  String sql, Object ...args)  {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(sql);
            for(int i = 0; i < 0; i ++){
                ps.setObject(i+1, args[i]);
            }
            rs = ps.executeQuery();
            ArrayList<T> list = new ArrayList<>();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            while(rs.next()){
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object columnValue = rs.getObject(i + 1);
                    String columnLabel = rsmd.getColumnLabel(i + 1);
                    //通过反射进行赋值
                    Field df = clazz.getDeclaredField(columnLabel);
                    df.set(t, columnValue);
                }
                list.add(t);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            JDBCUtils.closeResource(null,ps,rs);
        }


        return null;
    }

}
