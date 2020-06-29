package Demo07_02;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 一、Map的实现类结构：
 * Map：双列数据，存储key-value对的数据，
 *  1.HashMap:作为Map的主要实现类，线程是不安全的，效率高；可以存储null的key-value值
 *      1.1 LinkedHashMap：保证在遍历map元素的时候，可以按照添加的顺序执行遍历操作，可以实现的原因：以为在原来的基础上添加了 一对指针，
 *          可以指向前一个元素和后一个元素，对于频繁的遍历进行使用
 *  2.TreeMapTest：保证按照添加的key-value对进行排序实现排序遍历，底存使用的是红黑树
 *  3.Hashtable：作为古老的实现类；线程是安全的，效率比较低，不能存储null值
 *      2.1 Propertise：
 *
 * HashMao底层：数组+链表+红黑树
 *
 * 二、Map结构的理解
 *  key：不可重复的，无序的，使用set进行存储，   -->key所在的类要重写equals()和hashCode（）方法
 *  value：无序的，可重复的，类似于Colleaction存储的所用value   -->所在的类要重写equals（）
 *  entry：key-value无序的，不可重复的，使用Set进行存储所有的entry
 *
 *  三、HashMap的底层实现原理：jdk7为列说明
 *      HashMap map = new HashMap();
 *     jdk8.床架的数组是Node[] 非entry[]
 *
 *  五、Mao中常用的一些方法
 *      1.添加、删除、修改操作：
 *          Object put(Object key, Object value)：将指定key-value添加到当前的map对象中
 *          void putAll(Map m)：将m中的所有元素添加到当前的map中
 *          Object remove（Object key）:移除指定key的key-value，并返回value
 *          void clear（）:清空当前位置的所有数据
 *
 *      2.元素的查询条件：
 *          Object get(Object key):获取指定key对应的value值
 *          boolean containsKey（Object key）：是否包含指定的key
 *          boolean containsKey(Object value):是否包含指定的value值
 *          int size()：返回map中key——value对的个数
 *          boolean isEmpty（）：判断当前的ma是否为空
 *          boolean equals（object obj)：判断当前map对象和参数对象的 obj是否相等
 *
 *      3.元视图操作的方法：
 *          set keySet（）：返回所用key构成的Set集合
 *          Collection values（）：返回所有value构成的Collection集合
 *          Set entrySet()：返回所有key-value会构成的Set集合
 *
 */
public class MapTest {

    @Test
    public void test01(){

        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put("cc",123);
        map.put("dd",123);
        //修改
        map.put("AA",23);

        HashMap map1 = new HashMap();
        map1.put(1232,22);
        map1.put(12,1);

        map.putAll(map1);
        Object remove = map.remove("cc");
        System.out.println(remove);
        System.out.println(map.isEmpty());
        System.out.println("map.containsKey(123): " + map.containsKey(123));
        System.out.println("map.containsValue(123): " + map.containsValue(123));
        map.clear();

        System.out.println(map + " size: " + map.size());
        System.out.println(map.isEmpty());
    }

    /**
     *
     *  3.元视图操作的方法：
     *  *          set keySet（）：返回所用key构成的Set集合
     *  *          Collection values（）：返回所有value构成的Collection集合
     *  *          Set entrySet()：返回所有key-value会构成的Set集合
     */

    @Test
    public void test02(){

        Map map = new HashMap();
        //添加
        map.put("AA",123);
        map.put("cc",123);
        map.put("dd",123);
        map.put("dc",12);

        //遍历key集合KeySet
        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println();


        //遍历value集合Collections values()
        Collection values = map.values();
        for (Object obj : values){
            System.out.println(obj);
        }
        System.out.println();
        //Set entrySet()：返回所有key-value会构成的Set集合
        Set set1 = map.entrySet();
        Iterator iterator1 = set1.iterator();
        while (iterator1.hasNext()){
            //System.out.println(iterator1.next());
            Object obj1 = iterator1.next();
            Map.Entry entry = (Map.Entry)obj1;
            System.out.println(entry.getKey() + "________" + entry.getValue());
        }

        System.out.println();
        Set set2 = map.keySet();
        for(Object o : set2){
            Object o1 = map.get(o);
            System.out.println(o + "++" + o1);
        }
    }


}


















