package com.kite.pojo;

import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车对象
 */
public class Cart {
//    /** 总数量 */
//    private Integer totalCount;
//    /** 总价格 */
//    private BigDecimal totalPrice;
    /** 购物车中的商品对象 */
    /**
     * key：表示是商品的编号（唯一值）
     * value: 表示商品信息
     */
    private Map<Integer,CartItem> items = new LinkedHashMap<>();


    /**
     * 添加商品项
     * @param cartItem
     */
    public void addItem(CartItem cartItem){
        //首相查找购物车中有无该商品，有的话是数量的加1，总价格进行更新，如果没有添加过，则直接存放到map中
        CartItem item = items.get(cartItem.getId());//get(存放的为key值)   item（value）为对应的key（商品编号的商品）
        if(item == null){
            //购物车中不存在该商品的情况
            items.put(cartItem.getId(),cartItem);
        }else {
            //购物车中存在该商品
            item.setCount(item.getCount()+ cartItem.getCount());//商品数量加一
            item.setTotalPrice(item.getPrice().multiply(new BigDecimal(item.getCount())));//更新商品的总价格（multiply:为乘法）
        }

    }

    /**
     * 删除商品
     * @param id
     */
    public void deleteItem(Integer id){
        items.remove(id);
    }

    /**
     * 清空所有的商品
     */
    public void clear(){
        //map的清空
        items.clear();
    }

    /**
     * 修改商品的数量
     * @param id
     * @param count
     */
    public void updateCount(Integer id, Integer count){
        //先查看购物车中是否存在改商品
        CartItem cartItem = items.get(id);
        if(cartItem != null){
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new BigDecimal(count)));
        }
    }



    public Cart() {
    }

    public Cart(Map<Integer, CartItem> items) {
        this.items = items;
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        //总数量获取：遍历map集合中的totalCount添加
        for(Map.Entry<Integer,CartItem>entry:items.entrySet()){
            totalCount += entry.getValue().getCount();
        }

        return totalCount;
    }



    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (CartItem value : items.values()) {
            //add:是BigDecimal:中的加法
            totalPrice = totalPrice.add(value.getTotalPrice());
        }
        return totalPrice;
    }



    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}
