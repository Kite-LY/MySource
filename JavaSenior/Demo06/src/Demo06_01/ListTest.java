package Demo06_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *     Collection接口：单例集合，用来存储一个一个的对象
 *        list接口：存储有序的，可重复的数据 （动态数组）
 *               ArrayList：作为主要的实现类；线程不安全，效率高，底层object【】 存储
 *               LinkedList：对于平凡的使用插入，删除操作，使用此类的效率比ArrayList高，底层是使用双向链表
 *               Vector:在jdk 1.0的时候就出现；线程安全的，效率低，底层object【】 存储
 */
public class ListTest  {

    /**
     * List接口中常用的方法
     *   1.void add(int index, object obj):在index位置插入obj元素
     *   2.Boolean addAll(int index, collection obj):在index位置插入obj中所用的元素
     *   3.int indexOf(int index, object obj):返回obj元素首次出现的位置
     *   4.void LastIndexOf(int index, object obj):返回obj元素最后一次出现的位置
     *   5.Object remove(int index):指定移除对应位置的元素
     *   6.Object set(int index, Object ele):设置对应位置的元素值
     *   7.List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合
     *
     *   总结：常用的方法：
     *   增：add()
     *   删：remove()
     *   改：set()
     *   查：get()
     *   长度：size()
     *   遍历：iterator迭代器方式
     *         foreach
     *         普通循环
     */
    @Test
    public void test01(){
        ArrayList list = new ArrayList();
        list.add("中国");
        list.add(123);
        list.add(123);
        list.add(123);
        list.add(new Person("Tom",12));
        list.add("中国");
        list.add("中国");

        System.out.println(list);
        int i = list.indexOf("123");
        System.out.println(i);
        System.out.println(list.lastIndexOf("123"));
        //移除index位置的元素
        list.remove(2);
        Iterator it = list.iterator();

        Object set = list.set(2, 33);
        System.out.println("set:" + set);
        while(it.hasNext()){
            System.out.print(it.next() +"\t");
        }
        List list1 = list.subList(2,3);
        System.out.println(list1);

    }
    //一个小面试题
    @Test
    public void test02(){
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);
    }

    private  void updateList(List list){
        list.remove(2);  //移除的是3
        list.remove(Integer.valueOf(2));
        list.remove(new Integer(2));

    }


}










