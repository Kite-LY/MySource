package com.kite.dao;

import com.kite.pojo.OrderItem;

public interface OrderItemDao {
    /**
     * 保存商品订单对象
     * @param orderItem
     * @return
     */
    public int saveOrderItem(OrderItem orderItem);
}
