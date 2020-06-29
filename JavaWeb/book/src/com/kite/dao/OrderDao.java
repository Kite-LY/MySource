package com.kite.dao;

import com.kite.pojo.Order;
import com.kite.pojo.OrderItem;

public interface OrderDao {

    /**
     * 保存订单
     * @param order
     * @return
     */
    public int saveOrder(Order order);
}
