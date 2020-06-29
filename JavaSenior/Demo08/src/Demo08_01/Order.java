package Demo08_01;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义泛型类
 *
 */
public class Order<T> {
    String name;
    int orderId;
    //类的内部可以直接使用泛型
    T orderT;

    public Order() {
    }

    public Order(String name, int orderId, T orderT) {
        this.name = name;
        this.orderId = orderId;
        this.orderT = orderT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public T getOrderT() {
        return orderT;
    }

    public void setOrderT(T orderT) {
        this.orderT = orderT;
    }

    @Override
    public String toString() {
        return "Order{" +
                "name='" + name + '\'' +
                ", orderId=" + orderId +
                ", orderT=" + orderT +
                '}';
    }

    //泛型方法：在方法中出现了泛型结构，泛型参数与类的泛型参数没有任何关系
    //泛型方法：可以声明为静态的。原因：泛型类的参数是在调用方法时确定的，并非是在实例化类时确定的
    public <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e :arr){
            list.add(e);
        }
        return list;
    }
}
