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

public class ClientBookServlet extends BaseServlet {
    private BookService bookService = new BookServiceImpl();
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


        page.setUrl("client/clientBookServlet?action=page");
        //3.保存Page对象保存到request域中
        req.setAttribute("page",page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取请求参数pageNO,pageSize
        int pageNo = WebUtils.parseInt(req.getParameter("pageNo"), 1);
        int pageSize = WebUtils.parseInt(req.getParameter("pageSize"), Page.PAGE_SIZE);
        int min = WebUtils.parseInt(req.getParameter("min"),0);
        int max = WebUtils.parseInt(req.getParameter("max"),Integer.MAX_VALUE);

        //2.调用BookService.page(pageNo, pageSize)方法，进行具体分页获取Page对象
        Page<Book> page = bookService.pageByPrice(pageNo, pageSize, min, max);
        //StringBuilder是线程不安全的
        StringBuilder sb = new StringBuilder("client/clientBookServlet?action=pageByPrice");
        //如果有最小值就追加到分页条的地址上面
        if(req.getParameter("min") != null){
            sb.append("&min=").append(req.getParameter("min"));
        }
        //如果有最大值就追加到分页条的地址参数上面
        if(req.getParameter("min") != null){
            sb.append("&max=").append(req.getParameter("max"));
        }
        page.setUrl(sb.toString());
        //3.保存Page对象保存到request域中
        req.setAttribute("page",page);
        //4.请求转发到pages/manager/book_manager.jsp页面
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req,resp);
    }

}
