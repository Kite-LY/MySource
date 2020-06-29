package com.kite.test;

import com.kite.pojo.Cart;
import com.kite.pojo.CartItem;
import com.kite.service.OrderService;
import com.kite.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderServiceImplTest {

    @Test
    public void createOrder() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"西游记",1,new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(2,"水浒传",1,new BigDecimal(100), new BigDecimal(100)));

        OrderService orderService = new OrderServiceImpl();
        System.out.println("商品的订单号：" + orderService.createOrder(cart, 1));
    }
}