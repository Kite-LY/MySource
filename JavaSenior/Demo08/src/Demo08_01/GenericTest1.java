package Demo08_01;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 如何自定义泛型结构：泛型类，泛型接口，泛型方法
 *
 * 1.自定义泛型类、泛型接口：
 *
 */
public class GenericTest1 {

    @Test
    public void test01(){
        //如果定义了泛型，在实例化的时候最好要声明泛型
        Order<String> order1 = new Order<>("aa",12,"11");
        order1.setOrderT("BB");
        System.out.println(order1.toString());


    }

    @Test
    public void test02(){
        SubOrder sub = new SubOrder();
        //子类在继承泛型类的时候声明了泛型类，则实例化对象的时候，不再需要指明泛型
        sub.setOrderT(123);

        subOrder1<String> order1 = new subOrder1<>();
        order1.setOrderT("AA")  ;

    }

    //测试泛型方法
    @Test
    public void test03(){
        Order<String> order = new Order<>();
        String[] arr = new String[]{"AA","BB","BB"};
        List<String> list = order.copyFromArrayToList(arr);
        System.out.println(list);
    }
}

















