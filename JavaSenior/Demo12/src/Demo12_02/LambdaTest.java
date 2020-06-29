package Demo12_02;


import org.junit.Test;

import java.util.Comparator;

/**
 * Lambda表达式使用举例
 *
 */
public class LambdaTest {
    @Test
    public void test01(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("我哎杨滩！");
            }
        };
        r1.run();

        System.out.println("---------------------");
        //使用Lambda表达式
        Runnable r2 = () -> System.out.println("我爱广德");
        r2.run();

    }

    @Test
    public void test02(){
        Comparator<Integer> comparator = new  Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        int compare = comparator.compare(12, 23);
        System.out.println(compare);

        System.out.println("--------------------");
        //使用Lambda表达式
        Comparator<Integer> com1 = (o1,o2) -> Integer.compare(o1,o2);
        System.out.println( " Lambda表达式:" + com1.compare(23, 12));

        System.out.println("----------------------");
        //方法引用
        Comparator<Integer> com2 = Integer::compare;
        System.out.println("方法引用：" + com2.compare(12, 23));
    }
}





















