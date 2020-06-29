package cn.kitey.domain;

import java.io.Serializable;    //序列化接口

public class Account implements Serializable {
    private String username;
    private String password;
    private double money;
    private User user;

    public Account() {
    }

    public Account(String username, String password, double money, User user) {
        this.username = username;
        this.password = password;
        this.money = money;
        this.user = user;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
