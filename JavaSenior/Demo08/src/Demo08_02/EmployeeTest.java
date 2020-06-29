package Demo08_02;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 创建类的5个对象，并把这些对象放入TreeSet集合中，分别按以下两种方式对集合中的元素进行排序，并遍历输出：
 *
 * 1.使用employee实现Comparable接口，并且安装name进行排序
 * 2.传概念TreeSet时传入Comparable对象，安装生日日期进行排序
 */
public class EmployeeTest {

    //自然排序
    @Test
    public void test01(){
        TreeSet<Employee> set = new TreeSet<>();
        set.add(new Employee("qq",55, new MyDate(1990,12,2)));
        set.add(new Employee("aa",45, new MyDate(1940,2,2)));
        set.add(new Employee("cc",65, new MyDate(1790,1,22)));
        set.add(new Employee("tt",35, new MyDate(1992,12,2)));
        set.add(new Employee("yy",25, new MyDate(1998,7,23)));

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //按照生日进行排序
    @Test
    public void test02(){
        TreeSet<Employee> set = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //年比较
                int i = o1.getBirthday().getYaer() - o2.getBirthday().getYaer();
                if(i != 0){
                    return i;
                }
                int month = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
                if(month != 0){
                    return month;
                }
                return o1.getBirthday().getDay() - o2.getBirthday().getDay();
            }
        });



        //没有使用泛型
//        TreeSet set = new TreeSet(new Comparator() {
//            @Override
//            public int compare(Object o1, Object o2) {
//                if(o1 instanceof Employee && o2 instanceof Employee){
//                    Employee e1 =(Employee)o1;
//                    Employee e2 =(Employee)o2;
//                    //年比较
//                    int year = e1.getBirthday().getYaer() - e2.getBirthday().getYaer();
//                    if(year != 0){
//                        return year;
//                    }
//                    //月比较
//                    int month = e1.getBirthday().getMonth() - e2.getBirthday().getMonth();
//                    if(month != 0){
//                        return month;
//                    }
//                    //日比较
//                    int day = 0;
//                    return day = e1.getBirthday().getDay() - e2.getBirthday().getDay();
//
//                }
//                throw new RuntimeException("您输入的数据有错误！");
//            }
//        });


        set.add(new Employee("qq",55, new MyDate(1990,12,2)));
        set.add(new Employee("aa",45, new MyDate(1940,2,2)));
        set.add(new Employee("cc",65, new MyDate(1790,1,22)));
        set.add(new Employee("tt",35, new MyDate(1992,12,2)));
        set.add(new Employee("yy",25, new MyDate(1998,7,23)));

        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
