package com.kite.service.impl;

import com.kite.dao.OrderDao;
import com.kite.dao.OrderItemDao;
import com.kite.dao.impl.OrderDaoImpl;
import com.kite.dao.impl.OrderItemDaoImpl;
import com.kite.pojo.*;
import com.kite.service.BookService;
import com.kite.service.OrderService;

import java.util.Date;
import java.util.Map;

public class OrderServiceImpl  implements OrderService {
    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookService bookService = new BookServiceImpl();
    @Override
    public String createOrder(Cart cart, Integer userId) {

        System.out.println("OrderServiceImpl程序在【"+Thread.currentThread().getName()+"】中");

        //生成订单号===唯一性
        String orderId = System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order = new Order(orderId,new Date(),cart.getTotalPrice(),0,userId);
        //保存订单
        orderDao.saveOrder(order);
//
//        //手动创建异常
//        int i = 12/0;


        //遍历购物车中的每一个商品项转换为订单项保存到数据库中
        for(Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()){
            //获取购车中的每一个商品项
            CartItem item = entry.getValue();
            OrderItem orderItem = new OrderItem(null,item.getName(),item.getCount(),item.getPrice(),item.getTotalPrice(),orderId);
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookService.queryBookById(item.getId());
            book.setSales(book.getSales() + item.getCount());
            book.setStock(book.getStock() - item.getCount());
            //存储数据
            bookService.updateBook(book);
        }
        //下单后，清空购物车
        cart.clear();
        //返回商品编号
        return orderId;
    }
}

















