package Demo12_02;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * lambda的使用
 *   1.举例：(o1,o2) -> Integer.compare(o1,o2):
 *   2.格式：
 *          —>：Lambda操作符
 *          ->左边：Lambda形参列表（其实就是就空i中的抽象方法）
 *          ->右边：Lambda体(其实就是重修的抽象方法的方法体 )
 *
 *   3.lambda表达式的使用：（6种情况）
 *
 *   4.lambda表达式的本质：作为接口的实例
 *
 *   3.如果一个接口中，只申明了一个抽象方法，此接口就称为函数接口
 */
public class LambdaTest1 {

    //格式一：无参，无返回值的
    @Test
    public void test01(){
        Runnable r3 = () -> System.out.println("格式一：无参，无返回值的");
        r3.run();

    }

    /**
     * 格式二：Lambda需要一个参数，但是没用返回值
     *
     */
    @Test
    public void test02(){
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("函数重写！");

        System.out.println("-------------------------");

        Consumer<String> con1 = (String s) -> System.out.println(s);
        con1.accept("Lambda表达式有参数，无返回值！");
    }

    /**
     * 格式三：类型推断，而且小括号还可以进行省略
     *
     */
    @Test
    public void test03(){
        Consumer<String> con1 = s -> System.out.println(s);
        con1.accept("Lambda表达式有参数(类型推断)，无返回值！");
    }

    //格式5：Lambda 需要；i昂贵或者以上的参数，多条执行语句，并且可以有返回值
    public void test04(){
        Comparator<Integer> com = (o1,o2) ->{
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        };

    }
}

















