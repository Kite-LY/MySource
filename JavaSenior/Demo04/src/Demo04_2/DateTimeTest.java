package Demo04_2;


import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * jdk 8之前的日期时间的API测试
 * 1.systrm类中的currentTimeNillis（）
 * 2.java.util.Date和java.sql.Date
 * 3.SimpleDateFormat
 * 4.Calendar
 *
 */
public class DateTimeTest {

    /**
     *SimpleDateFormat的使用：SimpleDataFormat对日期Data类的格式化和解析
     * 1.两个操作：
     *   1.1格式化：日期——>字符串
     *   1.2解析：字符串 ---> 日期
     *
     *   编码：字符串 --》字节
     *   解码：字节 --> 字符串
     */

    @Test
    public void testSimpleDate () throws ParseException {

        //实例化SimpleDateFormat：使用默认的构造器
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化：日期————》字符串
        Date date = new Date();
        System.out.println(date);
        String format = sdf.format(date);
        System.out.println(format);//20-4-20 下午4:53


        //字符串 --> 日期
        String format1 = "20-4-20 下午4:53";
        Date date1 = sdf.parse(format1);
        System.out.println(date1);

        //自定义SimpleDateFormat中的格式
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(sdf1.format(date));



    }
    /**
     * 练习一：字符串“2020-09-08”转换为java.sql.Date
     *
     */
    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date = sdf.parse(birth);
        System.out.println(date);
        java.sql.Date sDate = new java.sql.Date(date.getTime());
        System.out.println(sDate);

    }

    /**
     * 练习二：“三天打鱼两天晒网” 从1990-01-01 开始
     * 则2020-09-08是在打鱼还是在筛网
     * 总天数的计算
     *
     */

    @Test
    public void countDay() throws ParseException {
        String sd = "2017-11-26";
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        Date date1 = sdf.parse(sd);//解析
        Date date2 = new Date();

        System.out.println(date1);
        System.out.println(date2);


        long countDay = (date2.getTime() - date1.getTime()) / ((1000 * 60 * 60 * 24) +1);
        System.out.println(countDay);
    }

    /**
     * Calendar日历类(抽象类)的使用
     *
     */

    @Test
    public void testCalendar(){
        //1.实例化
        //方式一：创建其子类的对象
        //方式二：调用其静态方法
        Calendar calendar = Calendar.getInstance();//使用静态方法

        //2.常用的方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);
        //set()
        calendar.set(Calendar.DAY_OF_YEAR,222);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_YEAR,22);
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

        //getTime() : 日历类 -->Date
        Date date = calendar.getTime();
        System.out.println(date);


        //setTime() :Date -->日历类
        Date date1 = new Date();
        calendar.setTime(date1);                  //没有返回值的
        days = calendar.get(Calendar.DAY_OF_YEAR);
        System.out.println(days);

    }

}
