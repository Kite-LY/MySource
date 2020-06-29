package com.kite.dao.impl;

import com.kite.dao.BookDao;
import com.kite.pojo.Book;

import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    /**
     * 添加书本信息
     * @param book
     * @return
     */
    @Override
    public int addBook(Book book) {
        String sql = "insert into t_book(`id` , `name` , `author` , `price` , `sales` , `stock` , `img_path`) value(?,?,?,?,?,?,?) ";
        return upDate(sql,book.getId(),book.getName(),book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),book.getImgPath());
    }

    /**
     * 通过id进行文件的删除
     * @param id
     * @return
     */
    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from t_book where id = ?";
        return upDate(sql,id);
    }

    /**
     * 通过id定位进行数据的更改
     * @param book
     * @return
     */
    @Override
    public int upDateBook(Book book) {
        System.out.println("BookDaoImpl程序在【"+Thread.currentThread().getName()+"】中");

        String sql = "update t_book set `name` = ? , `author` = ?  , `price` = ?  , `sales` = ?  , `stock` = ?  , `img_path` = ?  where `id` = ?" ;
        return upDate(sql,book.getName(), book.getAuthor(), book.getPrice(), book.getSales(), book.getStock(),book.getImgPath(), book.getId());
    }

    /**
     * 通过id查询一个书本的信息
     * @param id
     * @return
     */
    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from t_book where `id` = ?";
        return queryForOne(Book.class, sql, id);
    }

    /**
     * 查询全部书本的全部信息
     * @return
     */
    @Override
    public List<Book> queryBooks() {
        String sql = "select * from t_book";
        return queryForList(Book.class,sql);
    }

    @Override
    public Integer queryForPageTotalCount() {
        String sql = "select count(*) from t_book";
        Number number  = (Number) queryForSingValue(sql);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItems(Integer begin, Integer pageSize) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book limit ?,?";
        return queryForList(Book.class,sql,begin,pageSize);

    }

    @Override
    public Integer queryForPageTotalCountByPrice(int min, int max) {
        String sql = "select count(*) from t_book where price between ? and ?";
        Number number  = (Number) queryForSingValue(sql,min,max);
        return number.intValue();
    }

    @Override
    public List<Book> queryForPageItemsByPrice(Integer begin, int pageSize, int min, int max) {
        String sql = "select `id` , `name` , `author` , `price` , `sales` , `stock` , `img_path` from t_book where  price between ? and ? order by price limit ?,?";
        return queryForList(Book.class,sql,min,max,begin,pageSize);
    }
}
























