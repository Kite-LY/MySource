package com.kite.web;

import com.kite.pojo.Book;
import com.kite.pojo.Page;
import com.kite.service.BookService;
import com.kite.service.impl.BookServiceImpl;
import com.kite.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class BookServlet extends BaseServlet {
    //创建bookService对象
    BookService bookService = new BookServiceImpl();

    /**
     * page分页方法
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数pageNO,pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        //2.调用BookService.page(pageNo, pageSize)方法，进行具体分页获取Page对象
        Page<Book> page = bookService.page(pageNo, pageSize);
        page.setUrl("bookServlet?action=page");
        //3.保存Page对象保存到request域中
        req.setAttribute("page",page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.将book_edit中的Book属性内容进行获取，封装成为Book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(),new Book());
        //2.调用BookService.addBook()保存图书信息
        bookService.addBook(book);
        //3.跳转到图书列表页面（/bookServlet?action=list）

        //这里不能使用请求转发，这样可能会出先表单的重复提交
//      req.getRequestDispatcher("/book_manager.jsp?action=list").forward(req,resp);

        resp.sendRedirect(req.getContextPath() + "/bookServlet?action=page?" );
    }


    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数的id，图书编程
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.deleteBookById():删除图书
        bookService.deleteBookById(id);
        //3.使用重定向操作回到列表管理页面
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=page");
    }

    /**
     * 接收通过getBook()方法查找到的图书，修改后的信息
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取request域中的数据，封装成为book对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2.调用BookService.updateBook()方法修改数据库中的图书信息
        bookService.updateBook(book);
        //重定向回到图书管理界面地址/bookServlet?action=list
        resp.sendRedirect(req.getContextPath()+"/bookServlet?action=page");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数的图书编号
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2.调用bookService.queryBookById查询图书
        Book book = bookService.queryBookById(id);
            //将得到的book的属性内容存到request域中
        req.setAttribute("book",book);
        //3.请求转发到pages/manager/book_edit.jsp页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }



    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.通过BookServlet查询全部图书
        List<Book> books = bookService.queryBooks();
        //2.把全部图书保存到request域中
        req.setAttribute("books", books);
        //3.请求转发到/page/manager/book_manager.jsp
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
