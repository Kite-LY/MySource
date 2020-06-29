package Demo08_05;

import java.util.List;

public class DAOTest {

    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        dao.save("1", new User(1,33,"aa"));
        dao.save("2", new User(2,33,"bb"));
        dao.save("3", new User(12,33,"cc"));

        User user = dao.get("1");
        System.out.println(user);
        dao.delete("2");

        List<User> list = dao.list();
        list.forEach(System.out::println);//jdk8:新特性
    }
}
