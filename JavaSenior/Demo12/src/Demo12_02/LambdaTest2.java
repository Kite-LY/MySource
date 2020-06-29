package Demo12_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Java8中内置的4大和行函数接口：
 * 消费者接口：Consumer<T>      void accept(T t)
 * 供给型接口：Supplier<T>      T get()
 * 函数型接口：Function<T R>    R apply(T t)
 * 断定型接口：Predicate<T>     boolean test(T t)
 *
 */
public class LambdaTest2 {

    @Test
    public void test01(){
        happTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("消费：" + aDouble);
            }
        });

        //使用Lambda表达式
        happTime(200, money-> System.out.println("花费：" + money));

    }

    public void happTime(double money, Consumer<Double> consumer){
        consumer.accept(money);
    }

    @Test
    public void test02(){

        List<String> list = Arrays.asList("北京", "广州", "上海", "南京", "北极");
        List<String> stringList = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(stringList);


        //使用Lambda表达式
        List<String> list1 = Arrays.asList("hei京", "广州", "上海", "南京", "北极");
        List<String> stringList1t = filterString(list1, s -> s.contains("京"));
        System.out.println(stringList1t);
    }

    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        //将List 中符合test要求的数据添加到filterList中
        for (String s : list) {
            if(pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }
}



















