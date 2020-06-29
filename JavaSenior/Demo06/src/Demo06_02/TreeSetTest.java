package Demo06_02;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetTest {


    /**
     * 1.在向treeSet中添加数据时需要添加相同类的对象
     * 2.也不能添加多余相同的数据
     * 3.在自然排序中：比较两个对象是否相同的标准为：compareTo()返回为0； 不在是使用equals()
     *
     */

    @Test
    public void test01(){
        TreeSet set = new TreeSet();
        //案例一：添加int型数据
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(1);

        //案例二：添加User类对象:注意：这是需要重写comparable中的方法
        set.add(new User("Tom",12));
        set.add(new User("Aom",12));
        set.add(new User("Com",12));
        set.add(new User("Yom",22));
        set.add(new User("Oom",12));
        set.add(new User("Oom",13));


        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /**
     * 使用定制排序:比较两个对象是否相同的标准为：compareTo()返回为0； 不在是使用equals()
     *
     */
    @Test
    public void test02(){
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return u1.getName().compareTo(u2.getName());
                }
                return 0;
            }

        };


        TreeSet set = new TreeSet(com);
        set.add(new User("Tom1",12));
        set.add(new User("Aom1",12));
        set.add(new User("Com1",12));
        set.add(new User("Yom1",22));
        set.add(new User("Oom1",12));
        set.add(new User("Oom1",13));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
