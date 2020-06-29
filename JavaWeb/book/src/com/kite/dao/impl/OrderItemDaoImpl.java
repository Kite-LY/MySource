package com.kite.dao.impl;

import com.kite.dao.OrderItemDao;
import com.kite.pojo.OrderItem;

public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        System.out.println("OrderItemDaoImpl程序在【"+Thread.currentThread().getName()+"】中");

        String sql = "insert into t_order_item(`name`,`count`,`price`,`totalPrice`,`order_id`) value(?,?,?,?,?)";
        return upDate(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }
}
