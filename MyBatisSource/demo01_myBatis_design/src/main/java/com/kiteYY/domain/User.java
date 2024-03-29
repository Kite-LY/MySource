package com.kiteYY.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 创建数据库文件对应的实体类
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private Date brithday;
    private String sex;
    private String address;

    public User() {
    }

    public User(Integer id, String username, Date brithday, String sex, String address) {
        this.id = id;
        this.username = username;
        this.brithday = brithday;
        this.sex = sex;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", brithday=" + brithday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
