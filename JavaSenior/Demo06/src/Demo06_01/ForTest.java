package Demo06_01;

import org.junit.Test;

import java.util.ArrayList;

/**
 * jdk 5.0 新增了foreach循环，用于遍历集合，数组
 *
 */
public class ForTest {

    @Test
    public void test01(){
        ArrayList coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("12",12));
        coll.add(new String("Hello"));

        //for(集合元素的类型 局部变量：集合对象)：内部仍然调用了迭代器
        for(Object obj : coll){
            System.out.println(obj);
        }
    }

    @Test
    public void test02(){
        int [] arr = new int[]{12,34,56,66};
        for(int i :arr){
            System.out.println(i);
        }
    }

    @Test
    public void test03(){
        String[] arr = new String[]{"AA","AA","AA","AA"};
        //方式一：进行重新赋值
//        for (int i = 0; i <arr.length; i++) {
//            arr[i] = "bb";
//        }
        //方式二：进行重新赋值

        for(String s : arr){
            s = "aa";
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }
}
















