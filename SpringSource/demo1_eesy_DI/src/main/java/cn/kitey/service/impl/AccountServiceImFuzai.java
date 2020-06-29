package cn.kitey.service.impl;


import cn.kitey.service.IAccountService;

import java.util.*;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImFuzai implements IAccountService {

    private String[] myStr;
    private List<String>myList;
    private Set<String> mySet;
    private Map<String, String> myMap;
    private Properties myPro;

    public void setMyStr(String[] myStr) {
        this.myStr = myStr;
    }

    public void setMyList(List<String> myList) {
        this.myList = myList;
    }

    public void setMySet(Set<String> mySet) {
        this.mySet = mySet;
    }

    public void setMyMap(Map<String, String> myMap) {
        this.myMap = myMap;
    }

    public void setMyPro(Properties myPro) {
        this.myPro = myPro;
    }

    public void  saveAccount(){
        System.out.println(
                "AccountServiceImFuzai{" +
                        "myStr=" + Arrays.toString(myStr) +
                        ", myList=" + myList +
                        ", mySet=" + mySet +
                        ", myMap=" + myMap +
                        ", myPro=" + myPro +
                        '}');
    }


}
