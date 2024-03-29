package cn.kitey.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户类实体类实现序列化接口
 */
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String sex;
    private String address;
    private Date birthday;

    public User() {
    }

    public User(Integer userId, String username, String sex, String address, Date birthday) {
        this.userId = userId;
        this.username = username;
        this.sex = sex;
        this.address = address;
        this.birthday = birthday;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
