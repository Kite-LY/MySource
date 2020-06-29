package com.kite.test;

import java.lang.reflect.Method;

public class UserServletTest {

    public void login(){
        System.out.println("调用login()方法！");
    }

    public void regist(){
        System.out.println("调用regist()方法！");
    }
    public void uDdate(){
        System.out.println("调用uDdate()方法！");
    }
    public void upDateUser(){
        System.out.println("调用upDateUser()方法！");
    }
    public void upDateUserPassword(){
        System.out.println("调用upDateUserPassword()方法！");
    }

    public static void main(String[] args) {
        String action = "login";

        try {
            Method method = UserServletTest.class.getDeclaredMethod(action);
            System.out.println(method);
            method.invoke(new UserServletTest());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
