package Demo08_02;

/**
 * 定义一个Employee类
 * 该类包含了：private 成员变量name， age，birthday为Mydate类的对象
 * 并为一个属性定义getter， setter方法：
 * 并重写toString方法输出name，age，birthday
 *
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    //使用了泛型
    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);

    }


    //没用使用泛型
//    @Override
//    public int compareTo(Object o) {
//        if(o instanceof Employee){
//            Employee e = (Employee)o;
//            return this.name.compareTo(e.name);
//        }
//        throw new RuntimeException("您输入的数据有误!");
//    }
}
