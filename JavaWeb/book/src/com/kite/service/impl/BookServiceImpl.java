package com.kite.service.impl;

import com.kite.dao.BookDao;
import com.kite.dao.impl.BookDaoImpl;
import com.kite.pojo.Book;
import com.kite.pojo.Page;
import com.kite.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    //依赖于BookDao进行操作
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();


        //2.设置每页显示的数量
        page.setPageSize(pageSize);
        //3.求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        //3.2设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        if (pageNo < 1){
            pageNo = 1;
        }else if(pageNo > pageTotal){
            pageNo = pageTotal;
        }

        //1.设置当前页码
        page.setPageNo(pageNo);

        Integer begin = (page.getPageNo() -1 ) * page.getPageSize();
        List<Book> items = bookDao.queryForPageItems(begin, page.getPageSize());
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int pageNo, int pageSize, int min, int max) {
        Page<Book> page = new Page<>();


        //2.设置每页显示的数量
        page.setPageSize(pageSize);
        //3.求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        //3.2设置总记录数
        page.setPageTotalCount(pageTotalCount);
        // 求总页码
        Integer pageTotal = pageTotalCount/pageSize;
        if(pageTotalCount % pageSize > 0){
            pageTotal+=1;
        }
        page.setPageTotal(pageTotal);

        if (pageNo < 1){
            pageNo = 1;
        }else if(pageNo > pageTotal){
            pageNo = pageTotal;
        }

        //1.设置当前页码
        page.setPageNo(pageNo);

        Integer begin = (page.getPageNo() -1 ) * page.getPageSize();
        List<Book> items = bookDao.queryForPageItemsByPrice(begin, pageSize, min, max);
        page.setItems(items);

        return page;

    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.upDateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
