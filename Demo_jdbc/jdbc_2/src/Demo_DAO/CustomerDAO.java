package Demo_DAO;

import Demo01.Demo01_bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

/**
 * 此接口用于规范针对于customer表的常用操作
 *
 */
public interface CustomerDAO {
    /**
     * 向数据表中插入数据
     * @param conn
     * @param cust
     */
    int insert(Connection conn, Customers cust);

    /**
     * 针对指定的ID，删除表中的数据
     * @param conn
     * @param cust
     */
    void deleteByID(Connection conn, Customers cust);

    /**
     * 针对Cust对象，去修改指定的记录
     * @param conn
     * @param cust
     */
    int update(Connection conn,Customers cust );

    /**
     * 查询表中的所有类容
     * @param conn
     * @return
     */
    List<Customers> getAll(Connection conn);

    /**
     * 查询表中的条目数
     *
     * @param conn
     * @return
     */
    long getCount(Connection conn);

    /**
     * 返回表中最大的生日
     * @param conn
     * @return
     */
    Date getMaxBirth(Connection conn);

}
