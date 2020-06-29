package Demo06_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1.使用两个方法hasNext（），next（）；先调用hasNext
 * 2.Iterator可以删除集合的元素，但是是遍历过程中通过迭代器对象的remove()方法，不是集合对象的remove()方法
 */

public class IteratorTest {

    @Test
    public void test01(){
        ArrayList coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("tom",12));
        coll.add(new String("Hello"));

        Iterator iterator = coll.iterator();

        //iterator的遍历方式
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //测试迭代器中的remove()方法
    @Test
    public void test02(){
        ArrayList coll = new ArrayList();
        coll.add("abc");
        coll.add(123);
        coll.add(new Person("12",12));
        coll.add(new String("Hello"));
        Iterator iterator = coll.iterator();
        //删除其中的一个元素
        while(iterator.hasNext()){
            Object next = iterator.next();
            if(Integer.valueOf(123).equals(next)){
                iterator.remove();
            }
        }
        //注意：经过上面的遍历，指针已经移到了最下面，所以需要重新的创建iterator
        Iterator iterator1 = coll.iterator();
        while(iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }

}





























