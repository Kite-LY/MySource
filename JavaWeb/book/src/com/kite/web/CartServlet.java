package com.kite.web;

import com.google.gson.Gson;
import com.kite.pojo.Book;
import com.kite.pojo.Cart;
import com.kite.pojo.CartItem;
import com.kite.service.BookService;
import com.kite.service.impl.BookServiceImpl;
import com.kite.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CartServlet extends BaseServlet {


    BookService bookService = new BookServiceImpl();



    /**
     * 添加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void addItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("添加商品！" + "    商品编号：" + req.getParameter("id"));
        //获取请求参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("Id"), 0);
        //调用bookServlet.queryBookById()获取book信息
        Book book = bookService.queryBookById(id);
        //把图书信息装欢为CartBook商品项
        CartItem cartItem = new CartItem(id,book.getName(),1,book.getPrice(),book.getPrice());
        //调用cart.addItem(cartItem)；添加商品信息
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        //将最后一本书的信息保存到session域中
        req.getSession().setAttribute("lastName",cartItem.getName());
//        System.out.println(cart);
        //重定向到商品列表
        //req.getHeader("Referer"):获取的为请求头中请求操作发起的地址
        //注意：重定向操作:不共享request域中的数据的
        resp.sendRedirect(req.getHeader("Referer"));
    }


    /**
     * 添加图书
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void ajaxAddItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("添加商品！" + "    商品编号：" + req.getParameter("id"));
        //获取请求参数 商品编号
        int id = WebUtils.parseInt(req.getParameter("Id"), 0);
        //调用bookServlet.queryBookById()获取book信息
        Book book = bookService.queryBookById(id);
        //把图书信息装欢为CartBook商品项
        CartItem cartItem = new CartItem(id,book.getName(),1,book.getPrice(),book.getPrice());
        //调用cart.addItem(cartItem)；添加商品信息
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart == null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
        }

        cart.addItem(cartItem);
        //将最后一本书的信息保存到session域中
        req.getSession().setAttribute("lastName",cartItem.getName());
        //返回商品的总数，和最后一个添加商品的名称
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("totalCount",cart.getTotalCount());
        resultMap.put("lastName", cartItem.getName());
        //转换为json对象
        Gson gson = new Gson();
        String json = gson.toJson(resultMap);
        //返回给客户端
        resp.getWriter().write(json);

    }

    /**
     * 删除商品项
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void deleteItem(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取商品的编号
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        //获取购车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //判断session是否为空，通过id进行删除
        if(cart != null){
            cart.deleteItem(id);
            //跳回原来的页面
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }

    /**
     * 清空购物车操作
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void clear(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.clear();
            //req.getHeader("Referer"):获取的为请求头中请求操作发起的地址
            resp.sendRedirect(req.getHeader("Referer"));
        }
    }


    protected void updateCount(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = WebUtils.parseInt(req.getParameter("count"),0);
        int id = WebUtils.parseInt(req.getParameter("id"),0);
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if(cart != null){
            cart.updateCount(id,count);

            resp.sendRedirect(req.getHeader("Referer"));
        }

    }













}
