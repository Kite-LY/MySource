package cn.kitey.domain;

import java.io.Serializable;

/**
 * 账户信息实体类
 *
 * 为啥要实现序列化：序列化就是对实例对象的状态(State 对象属性而不包括对象方法)进行通用编码
 * （如格式化的字节码）并保存，以保证对象的完整性和可传递性。
 * 简而言之：序列化，就是为了在不同时间或不同平台的JVM之间共享实例对象
 */
public class Account implements Serializable {
    private Integer id;
    private String name;
    private Double money;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
