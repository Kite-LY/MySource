package Demo07_02;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Collections工具类，是操作Mao，collection的一些静态方法
 *
 * 面试题：Collections 和 collection的 区别？
 *
 */
public class CollectionsTest {

    /**
     * collections的方法：
     *  reverse(List):反转List中的元素顺序
     *  shuffle（List）：对List中的元素进行随机排序
     *  sort（List）：根据元素的自然顺序对指定的List集合进行升序的排序
     *  sort（List,Comparator）：根据指定的Comparator产生的顺序对List集合元素进行排序
     *  swap(List, int , int):将指定List集合中的i处的元素和j处的元素进行交换
     *
     *  Object max(Collection):根据元素的自然顺序，返回给定集合中的最大的元素
     *  Object max(Collection, Comparator):根据Comparator指定的顺序，返回最大的元素
     *  同上还用 Object min(Collection):
     *  int frequency(Collection, Object):表示集合中指定元素的出现的次数
     *  void copy(List dest, List src):将src中的内容复制到dest中
     *  boolea replaceAll（List List，Object oldVal， Object newVal）：让新值替换旧值的内容
     *
     */
    @Test
    public void test01(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(23);
        list.add(23);
        list.add(-23);
        list.add(0);
        System.out.println(list);
        System.out.println();

        //反转
        Collections.reverse(list);
        System.out.println(list);

        Collections.sort(list);
        System.out.println(list);

    }


}














