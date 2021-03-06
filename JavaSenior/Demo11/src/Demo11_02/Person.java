package Demo11_02;

@MyAnnotation(value = "hi")
public class Person extends Creature<String> implements Comparable<String>, MyInterface {

    private String name;
    int age;
    public int id;

    public Person(){}
    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    private String showNation(String nation){
        System.out.println("我的国籍是：" + nation);
        return nation;
    }
    public String disPlay(String interstes){
        return interstes;
    }


    @Override
    public void info() {
        System.out.println("我是一个人！");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
