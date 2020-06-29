package Demo06_02;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Set接口框架：
 * hashSet:作为set接口的主要实现类;线程是不安全的；可以存放null值，添加元素的时是无顺序添加的，根据hash值进行天机的
 * LinkedHashSet：作为hashSet的子类，添加的顺序就是排序的顺序
 * TreeSet：可以按转添加对象指定的属性，进行排序
 *
 */
public class SetTest {

    /*
    1.存储的时候是无序的
    2.不可重复性性：按照equals方法进行判断
     */

    /**
     *添加元素的过程：以hashSet为列：
     *      我们想HashSet中添加元素a，首先调用元素a所在类的hashCode()方法，计算元素a的哈希值
     *      此哈希值接着通过某种算法计算出hashSet底层数组种存放位置（索引位置），判断数组此位置
     *      上是否已经有元素：
     *             如果此位置上其他元素，则元素a添加成功    -->情况一
     *             如果位置上其他元素b（或以链表形式存在的多个元素），则比较元素a与元素b的hash值：
     *                  如果hash值不相同则添加元素a成功   -->情况2
     *                  如果hash值相同，进而需要调用元素a所在类的equals（）方法：
     *                      equals（）返回为true，元素a添加失败
     *                      equals（）返回false，则元素a添加成功  -->情况2
     *
     *  HashSet的底层：数组 + 链表结构
     *
     *
     */
    @Test
    public void test01(){
        Set set = new HashSet();
        set.add(123);
        set.add(123);
        set.add("aaa");
        set.add(new User("t",12));
        set.add(new User("t",12));

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    /**
     * LinkedHashSet:在原用的HashSet的基础上加上了两个引用，在使用LinkedHashSet时进行遍历的时候效率比较高
     *
     */
    @Test
    public void test02(){
        Set set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add("aaa");
        set.add(new User("t",12));
        set.add(new User("t",12));

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
