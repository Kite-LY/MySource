package com.kite.test;

import com.kite.dao.impl.BookDaoImpl;
import com.kite.pojo.Book;
import com.kite.pojo.Page;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookDaoTest {

    private BookDaoImpl bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null,"刘备简介1", "kite",new BigDecimal(999), 1000,1,null));
    }

    @Test
    public void deleteBook() {
        bookDao.deleteBookById(39);

    }

    @Test
    public void upDateBook() {
        bookDao.upDateBook(new Book(46,"刘备简介", "kite",new BigDecimal(999), 1000,30,"static/img/default.jpg"));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(39));
    }

    @Test
    public void queryBooks() {
        for (Book book : bookDao.queryBooks()) {
            System.out.println(book);
        }
    }

    @Test
    public void queryForPageTotalCount() {
        System.out.println(bookDao.queryForPageTotalCount());
    }

    @Test
    public void queryForPageTotalCountByPrice() {
        System.out.println(bookDao.queryForPageTotalCountByPrice(10,50));
    }

    @Test
    public void queryForPageItems() {
        for (Book queryForPageItem : bookDao.queryForPageItems(34, Page.PAGE_SIZE)) {
            System.out.println(queryForPageItem);
        }
    }
    @Test
    public void queryForPageItemByPrice() {
        for (Book queryForPageItem : bookDao.queryForPageItemsByPrice(1, Page.PAGE_SIZE,10,50)) {
            System.out.println(queryForPageItem);
        }
    }

}