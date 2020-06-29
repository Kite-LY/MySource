package Demo_DAO;

import Demo01.Demo01_bean.Customers;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

public class CustomerDAOImpl extends BaseDAO<Customers> implements CustomerDAO {
    @Override
    public int insert(Connection conn, Customers cust) {
        String sql ="insert into customers(id, name, email, birth) values(?,?,?,?)";
        return update(conn, sql, cust.getId(), cust.getName(), cust.getEmail(), cust.getBirth());

    }

    @Override
    public void deleteByID(Connection conn, Customers cust) {
        String sql = "delete from customers where id = ?";
        update(conn,sql, cust.getId());
    }

    @Override
    public int update(Connection conn, Customers cust ) {
        String sql = "update customers set name = ?, email = ?, birth = ? where id = ?";
        return update(conn, sql,  cust.getName(), cust.getEmail(), cust.getBirth(),cust.getId());
    }

    @Override
    public List<Customers> getAll(Connection conn) {
        String sql = "select id, name, email, birth from customers";
        return getInstance(conn, sql);
    }

    @Override
    public long getCount(Connection conn) {
        String sql = "select count(*) from customers";
        return getValue(conn,sql);
    }

    @Override
    public Date getMaxBirth(Connection conn) {
        String sql = "select max(birth) from customers";
        return getValue(conn, sql);
    }
}
