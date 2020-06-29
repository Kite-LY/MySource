package Demo05_3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Throw:生成异常对象，并且进行抛出，使用在方法的内部，  自动的抛出异常对象
 * Throws：处理异常的方式，使用在方法声明的末尾   try-catch-finally
 *
 */

/**
 * 一、集合框架的概述
 * 1.集合、数组都是对多个数据进行存储操作的存储，简称Java容器
 *        说明：这个存储主要指内存层面的存储，不涉及到持久化的存储
 * 2.1：数组在存储多个数据方面的特点：
 *
 *
 *
 *二.集合框架
 *  *        Collection接口：单例集合，用来存储一个一个的对象
 *  *           list接口：存储有序的，可重复的数据 （动态数组）
 *  *             ArrayList，LinkedList， Vector
 *  *           Set接口：存储无序的，不可重复的数据 （集合）
 *  *              HashSet，LinkedSet, TreeSet
 *  *        Map接口：双例集合，用来存储一对（key - value）一对的数据
 *  *              HashMap, LinkedHashMap, TreeMap, HashTable, Properties
 *
 */

public class CollectionTest {

    @Test
    public void test01() {
        Collection coll = new ArrayList();

        //add():添加一个元素
        coll.add(123);
        coll.add("中国");
        coll.add(new Date());
        coll.add("awed");

        //size():集合中的个数
        System.out.println(coll.size());

        //addAll():可以将另一个集合的元素添加到本集合
        Collection coll2 = new ArrayList();
        coll2.add("wqe");
        coll2.add(1232);
        coll.addAll(coll2);
        System.out.println(coll.size());
        System.out.println(coll);

        //clear():清空元素
        coll.clear();

        //isEmpty（）:判断是否为空
        System.out.println(coll.isEmpty());
        System.out.println(coll);
    }
}



















