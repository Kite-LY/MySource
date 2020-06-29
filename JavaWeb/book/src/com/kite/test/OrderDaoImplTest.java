package com.kite.test;

import com.kite.dao.OrderDao;
import com.kite.dao.impl.OrderDaoImpl;
import com.kite.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class OrderDaoImplTest {

    @Test
    public void saveOrder() {
        OrderDao orderDao = new OrderDaoImpl();
        //再添加的时候注意 userId 一定要包含在t_user表中
        orderDao.saveOrder(new Order("12111",new Date(),new BigDecimal(133), 0, 4));
    }
}