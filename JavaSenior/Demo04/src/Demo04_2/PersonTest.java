package Demo04_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class PersonTest {
    @Test
    public void test01(){
        Person[] arr = new Person[5];
        arr[0] = new Person("bb",11);
        arr[1] = new Person("cc",33);
        arr[2] = new Person("qq",11);
        arr[3] = new Person("bn",11);
        arr[4] = new Person("aa",22);
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 使用comparator疾控是Person按章年龄大小从大到小排序
     *
     */

    @Test
    public void test02(){
        Person[] arr = new Person[5];
        arr[0] = new Person("bb",11);
        arr[1] = new Person("cc",33);
        arr[2] = new Person("qq",11);
        arr[3] = new Person("bn",11);
        arr[4] = new Person("aa",22);
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return -Integer.compare(o1.getAge(),o2.getAge());
            }
        });
        System.out.println(Arrays.toString(arr));
    }

}
