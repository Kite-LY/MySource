package com.kite.dao.impl;

import com.kite.dao.OrderDao;
import com.kite.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    /**
     * 实现订单的创建
     * @param order
     * @return
     */
    @Override
    public int saveOrder(Order order) {
        System.out.println("OrderDaoImpl程序在【"+Thread.currentThread().getName()+"】中");

        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) value(?,?,?,?,?)";
        return upDate(sql,order.getOrder_id(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
