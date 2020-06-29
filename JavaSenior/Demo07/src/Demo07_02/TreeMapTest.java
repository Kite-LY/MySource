package Demo07_02;

import org.junit.jupiter.api.Test;

import java.util.*;

public class TreeMapTest {

    /**
     * 向TreeTest中添加key-value,要求key必须是由同一个类创建的对象
     * 因为要按照key进行排序：自然排序，定制排序
     *
     */
    //自然排序
    @Test
    public void test01(){
        Map map = new TreeMap();
        map.put(new User("AA",11),323 );
        map.put(new User("nn",13),333 );
        map.put(new User("mm",66),335 );
        map.put(new User("dd",45),336 );
        map.put(new User("uu",12),339 );

        Set set = map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }
    }

    //定制排序
    @Test
    public void test02(){
        Map map1 = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof  User){
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());

                }
                throw new RuntimeException("输入的数据不匹配！");
            }
        });
        map1.put(new User("AA",11),323 );
        map1.put(new User("nn",13),333 );
        map1.put(new User("mm",66),335 );
        map1.put(new User("dd",45),336 );
        map1.put(new User("uu",12),339 );

        Set set = map1.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            //System.out.println(iterator.next());
            Map.Entry entry = (Map.Entry)iterator.next();
            System.out.println(entry.getKey() + "----" + entry.getValue());
        }

    }
}
