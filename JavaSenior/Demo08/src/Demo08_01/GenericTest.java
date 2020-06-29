package Demo08_01;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 泛型的使用：
 *
 * 1.如何自定义泛型结构：泛型类，泛型的接口，泛型方法
 * 2.泛型的引用不能相互赋值
 * 3.静态方法中不能使用泛型类
 * 4.异常类不能申明泛型类
 */
public class GenericTest {

    //在集合中使用泛型:List中使用
    @Test
    public void test01(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(82);
        list.add(72);
        list.add(16);
        list.add(14);
        list.add(13);
        for(Integer score :list){
            System.out.println(score);
        }
    }

    //在hashMap中的应用场景
    @Test
    public void test02(){
        Map<String, Integer> map = new HashMap<>();
        map.put("Tom",12);
        map.put("Tom2",12);
        map.put("To3",12);
        map.put("Tom4",12);
        map.put("Tom5",12);

        Set<Map.Entry<String, Integer>> entry = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = entry.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey() + "----" + next.getValue());
        }
    }
}
