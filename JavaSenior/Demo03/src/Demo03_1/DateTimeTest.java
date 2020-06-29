package Demo03_1;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前的日期和时间API测试
 *
 */

public class DateTimeTest {

    /**
     * 1.System类中的currentTimeMillis()
     */
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日到现在的时间差
        System.out.println(time);

    }
    /**
     * java.util.Date类
     * 1.两个构造器的使用
     *    new Date()
     *
     * 2.两个方法的使用
     *      toString:显示当前的日期
     *      getTime：获取的是毫秒数
     *
     * 2.java.util.Date转换为java.sql.Date
     */
    @Test
    public void test2(){
        Date date1 = new Date();  //创建的是当前的时间Date类
        System.out.println(date1.toString());  //Sun Apr 19 22:36:15 CST 2020
        System.out.println(date1.getTime());    //1587306975727

        java.sql.Date date2 = new java.sql.Date(date1.getTime());
        System.out.println(date2);
    }

}
