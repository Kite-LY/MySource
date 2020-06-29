package com.kite.test;

import com.kite.pojo.Book;
import com.kite.pojo.Page;
import com.kite.service.BookService;
import com.kite.service.impl.BookServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {

    private BookService bookService = new BookServiceImpl();

    @Test
    public void addBook() {
        bookService.addBook(new Book(null,"刘备简介1", "kite",new BigDecimal(999), 1000,1,null));
    }

    @Test
    public void deleteBookById() {
        bookService.deleteBookById(41);

    }

    @Test
    public void updateBook() {
        bookService.updateBook(new Book(46,"张飞简介1", "kite",new BigDecimal(999), 1000,1,null));
    }

    @Test
    public void queryBookById() {
        Book book = bookService.queryBookById(22);
        System.out.println(book);
    }

    @Test
    public void queryBooks() {
        List<Book> books = bookService.queryBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void page(){
        System.out.println(bookService.page(1, Page.PAGE_SIZE));
    }

    @Test
    public void pageByPrice(){
        System.out.println(bookService.pageByPrice(0, Page.PAGE_SIZE, 10, 50));
    }
}