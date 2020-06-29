package com.kite.web;

import com.kite.pojo.Cart;
import com.kite.pojo.User;
import com.kite.service.OrderService;
import com.kite.service.impl.OrderServiceImpl;
import com.kite.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class OrderServlet extends  BaseServlet {

    OrderService orderService = new OrderServiceImpl();
    /**
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //先获取购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取用户的id
        //获取的为UserServlet中登录成功保存的
        //session  经常用于保存用户的登录信息
        //req.getSession().setAttribute("user",login);
        User loginUser = (User) req.getSession().getAttribute("user");
        //判断用户是否登录
        if(loginUser == null){
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
            //不执行下面的额代码
            return;
        }

        System.out.println("orderServlet程序在【"+Thread.currentThread().getName()+"】中");

        Integer userId = loginUser.getId();

        String orderId = orderService.createOrder(cart, userId);

//        req.setAttribute("orderId",orderId);
//        req.getRequestDispatcher("/pages/cart/checkout.jsp").forward(req,resp);
        //为了防止表单的重复提交（不能使用请求转发，应该使用重定向）,而且数据应该保存在session中（因为request域中不能共享）
        req.getSession().setAttribute("orderId",orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");

    }
}
