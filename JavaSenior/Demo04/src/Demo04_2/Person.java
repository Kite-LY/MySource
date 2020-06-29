package Demo04_2;

/**
 * 自定义个person类如何实现其自然排序（按照姓名从小到大进行排序）
 *
 */
public class Person implements Comparable{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Person){
            Person p = (Person)o;
            if(this.name.equals(p.name)){
                return Integer.compare(this.age,p.age);
            }else{
                return this.name.compareTo(p.name);
            }
        }
        throw new RuntimeException("你输入的数据有错误！");
    }


}
