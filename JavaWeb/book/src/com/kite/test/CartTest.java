package com.kite.test;

import com.kite.pojo.Cart;
import com.kite.pojo.CartItem;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class CartTest {

    @Test
    public void addItem() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"西游记",1,new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(2,"水浒传",1,new BigDecimal(100), new BigDecimal(100)));

        System.out.println(cart);
    }

    @Test
    public void deleteItem() {

        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"西游记",1,new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(2,"水浒传",1,new BigDecimal(100), new BigDecimal(100)));

        cart.deleteItem(1);
        System.out.println(cart);
    }

    @Test
    public void clear() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"西游记",1,new BigDecimal(100), new BigDecimal(100)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(1,"西游记",2,new BigDecimal(100), new BigDecimal(200)));
        cart.addItem(new CartItem(2,"水浒传",1,new BigDecimal(100), new BigDecimal(100)));

        cart.clear();
        System.out.println(cart);
    }

    @Test
    public void updateCount() {
        Cart cart = new Cart();
        cart.addItem(new CartItem(1,"西游记",1,new BigDecimal(100), new BigDecimal(100)));
  ;
        cart.addItem(new CartItem(2,"水浒传",1,new BigDecimal(100), new BigDecimal(100)));
        System.out.println(cart);
        cart.updateCount(1,10);
        System.out.println(cart);
    }
}