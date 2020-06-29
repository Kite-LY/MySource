package com.kite.service;

import com.kite.pojo.Cart;

public interface OrderService {
    /**
     * 生成订单！
     * @param cart 传入购物车
     * @param userId 传入用户的id
     * @return
     */
    public String createOrder(Cart cart, Integer userId);
}
