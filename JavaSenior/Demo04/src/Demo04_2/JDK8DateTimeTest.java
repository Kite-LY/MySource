package Demo04_2;

import org.junit.Test;

import java.time.*;

/**
 * jdk 8中的日期和时间API的测试
 *
 */

public class JDK8DateTimeTest<localeDate> {

    /**
     * LocalDate， LocalTime, LocalDateTime 的使用
     */

    @Test
    public void test01(){
        //now():获取当前的日期，时间，日期+时间
        LocalDate now = LocalDate.now();
        LocalTime now1 = LocalTime.now();
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println(now);
        System.out.println(now1);
        System.out.println(now2);

        //of():静态方法，根据指定日期/时间创建对象
        LocalDateTime localDateTime1 = LocalDateTime.of(2012,12,21,22,2,1,1);
        System.out.println(localDateTime1);

        //getXXX()
        System.out.println(localDateTime1.getDayOfMonth());
        System.out.println(localDateTime1.getDayOfWeek());
        System.out.println(localDateTime1.getDayOfYear());
        System.out.println(localDateTime1.getSecond());

        //体现了不可变性
        //withXXX():设置对应的属性
        LocalDateTime withDayOfYear = localDateTime1.withDayOfYear(22);
        System.out.println(localDateTime1);
        System.out.println(withDayOfYear);

    }
    /**
     * instant的使用
     *
     */
    @Test
    public void stest02(){
        Instant now = Instant.now();
        System.out.println(now);//2020-04-20T14:06:03.050Z

        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));//设置为东八区
        System.out.println(offsetDateTime);//2020-04-20T22:06:03.050+08:00

    }


}
















