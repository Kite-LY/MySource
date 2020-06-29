package Demo08_04;


import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;

public class GenericTest3 {
    //通配符的使用:?

    @Test
    public void test01(){
        List<Object> list1 = null;
        List<String> list2 = null;

        List<?> list = null;
        list = list1;
        list = list2;

    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);

        }
    }

    /**
     * 3.有限制条件的通配符的使用
     *  ？ extends Person
     *  ？ super Person
     */

    @Test
    public void test02(){

        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = null;
        List<Person> list4 = null;
        List<Object> list5 = null;

    }

}




















