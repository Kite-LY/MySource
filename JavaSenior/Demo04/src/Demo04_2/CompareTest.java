package Demo04_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 一、说明：java对象中比较大小使用两个接口中的任何一个：Comparable或者Comparator
 * 二、Comparable接口与Comparator的使用的对比
 *      Comparable接口的方式一旦一起，在其实现类的对象在任何位置都可以进行比较大小
 *      Comparator接口属于一种临时性比较大小的
 *
 */
public class CompareTest {

    /**
     * Comparable接口的使用举例
     *  1.String,和其他的一些包装类都重写了CompareTo（obj）方法，给了两个比较对象大小的额方式
     *  2.重写compareTo(obj)的规则：
     *      如果当前对象this大于形参对象obj，则返回正整数
     *      如果当前对象this小于形参对象obj，则返回负整数
     *      如果当前对象this等于形参对象obj，则返回0
     *  3.自己定义的类，如果需要进行比较，则需要自己定义compareTo(obj)方法
     */

    @Test
    public void test01(){
        String[] arr = new String[]{"aa","cc","yy","dd","bb","hh"};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test02(){
        Goods[] arr1 = new Goods[4];
        arr1[0] = new Goods("Dell",32);
        arr1[1] = new Goods("XiaoMi",3);
        arr1[2] = new Goods("HuaWei",12);
        arr1[3] = new Goods("Log",22);

        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

    }

    /**
     * Comparator接口的使用：定制排序
     *  1. 重写compare（Object o1，Object o2）方法，比较o1,o2的大小
     *          如果当前对象o1大于形参对象o2，则返回正整数
     *          如果当前对象o1小于形参对象o2，则返回负整数
     *          如果当前对象o1等于形参对象o3，则返回0
     */

    @Test
     public void test03(){
        String[] arr = new String[]{"aa","cc","yy","dd","bb","hh"};
        Arrays.sort(arr, new Comparator<String>() {
            //从大到小进行排序
            @Override
            public int compare(String o1, String o2) {
                return -o1.compareTo(o2);
            }
        });
        System.out.println(Arrays.toString(arr));
     }

     @Test
     public void test04(){
         Goods[] arr1 = new Goods[4];
         arr1[0] = new Goods("Dell",32);
         arr1[1] = new Goods("XiaoMi",3);
         arr1[2] = new Goods("HuaWei",12);
         arr1[3] = new Goods("Log",22);

         Arrays.sort(arr1, new Comparator() {

             @Override
             public int compare(Object o1, Object o2) {
                 if(o1 instanceof Goods && o2 instanceof  Goods){
                     Goods g1 = (Goods)o1;
                     Goods g2 = (Goods)o2;
                     if(g1.getName().equals(g2.getName())){
                         return -Double.compare(g1.getPrice(),g2.getPrice());
                     }else{
                         return g1.getName().compareTo(g2.getName());
                     }
                 }
                 throw new RuntimeException("你输入数据错误！");
             }
         });
         System.out.println(Arrays.toString(arr1));
     }

}
