package com.kite.test;

import com.kite.dao.OrderItemDao;
import com.kite.dao.impl.OrderItemDaoImpl;
import com.kite.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class OrderItemDaoImplTest {

    @Test
    public void saveOrderItem() {
        OrderItemDao orderItemDao = new OrderItemDaoImpl();
        //注意在插入信息的时候注意orderId 在 t_order中存在
        orderItemDao.saveOrderItem(new OrderItem(null,"西游记",12,new BigDecimal(10), new BigDecimal(100),"12336"));
        orderItemDao.saveOrderItem(new OrderItem(null,"水浒传",12,new BigDecimal(10), new BigDecimal(100),"12336"));
        orderItemDao.saveOrderItem(new OrderItem(null,"三国演义",12,new BigDecimal(10), new BigDecimal(100),"12336"));
    }
}