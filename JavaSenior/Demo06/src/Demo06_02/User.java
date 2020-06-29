package Demo06_02;

import java.util.Objects;

public class User implements Comparable{
    String name;
    int age;

    public User() {
    }

    public User(String name, int age) {
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
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        System.out.println("equals...");
        return Objects.hash(name, age);
    }


    @Override
    public int compareTo(Object o) {
        if(o instanceof User){
            User user = (User)o;
            int com = this.name.compareTo(user.name);
            if(com != 0){
                return com;
            }else{
                return Integer.compare(this.age, user.age);
            }
        }
        throw new RuntimeException("您数据的数据有误！");
    }
}
