package kite.utils;

import javax.servlet.http.Cookie;

public class CookieUtils {

    /**
     * 查找对应的cookie数据
     * @param name
     * @param cookies
     * @return
     */
    public static Cookie findCookie(String name, Cookie[] cookies){
        if(name == null|| cookies == null || cookies.length == 0){
            return null;
        }else{
            for (Cookie cookie : cookies) {
                if(name.equals(cookie.getName())){
                    return cookie;
                }
            }
        }
        return null;
    }
}
