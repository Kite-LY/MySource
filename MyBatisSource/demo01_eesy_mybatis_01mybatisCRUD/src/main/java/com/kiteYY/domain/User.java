package com.kiteYY.domain;

import java.util.Date;

public class User {
    private Integer userId;
    private String userName;
    private String userAddress;
    private String userSex;
    private Date UserBirthday;

    public User() {
    }

    public User(Integer userId, String userName, String userAddress, String userSex, Date userBirthday) {
        this.userId = userId;
        this.userName = userName;
        this.userAddress = userAddress;
        this.userSex = userSex;
        UserBirthday = userBirthday;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Date getUserBrithday() {
        return UserBirthday;
    }

    public void setUserBrithday(Date userBirthday) {
        UserBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userSex='" + userSex + '\'' +
                ", UserBirthday=" + UserBirthday +
                '}';
    }
}
