package Demo01.Demo01_bean;

import java.sql.Date;

/**
 * ORM的编程思想（Object relational mapping）：
 * 一个数据表对应一个数据类
 * 表中的一条记录对应表中的一个对象
 * 表中的一个字段对象表中的一个属性
 *
 */
public class Customers {
    public int id;
    public String name;
    public  String email;
    public  Date birth;

    public Customers() {
    }

    public Customers(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }
}
