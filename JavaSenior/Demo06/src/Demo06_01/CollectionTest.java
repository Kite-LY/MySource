package Demo06_01;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Collection接口中声明的方式的测试
 *
 */
public class CollectionTest {

    @Test
    public void test01(){
        ArrayList coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("12",12));
        coll.add(new String("Hello"));
        //1.contains（Object obj）：判断当前集合中是否包含obj
        System.out.println(coll.contains(123));
        System.out.println(coll.contains(new Person("12",12)) );
        System.out.println(coll.contains(2));

        //2.containsAll(Collection coll1)：判coll1中所用元素是否在coll中

        //3.remove（）：移除其中的元素
        Boolean remove;
        remove = coll.remove(new Integer(123));//remove中不能直接填写数字这样会移除位置上的元素
        System.out.println(remove);
        System.out.println(coll);

        //4.removeAll(Collection coll):从当前的集合中移除coll1中所有的元素

        //5.集合--> 数组
        Object[] objects = coll.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.println(objects[i]);
        }

        //拓展：数组 --> 集合
        List<String> list = Arrays.asList(new String[]{"c", "b", "a"});
        System.out.println(list);
    }

}
