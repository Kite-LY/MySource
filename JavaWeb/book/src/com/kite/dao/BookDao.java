package com.kite.dao;

import com.kite.pojo.Book;

import java.util.List;

public interface BookDao {


    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int upDateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();


    List<Book> queryForPageItems(Integer begin, Integer pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(Integer begin, int pageSize, int min, int max);
}
