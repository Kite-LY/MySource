package Demo04_2;

import org.junit.Test;

/**
 * 其他类的使用
 * 1.system
 * 2.math
 * 3.BigInteger和BigDecimal
 */

public class OtherClassTest {

    @Test
    public void test1(){
        String property = System.getProperty("java.version");
        System.out.println("java的version：" + property);

        String property1 = System.getProperty("java.home");
        System.out.println("java的home：" + property1);

        String property2 = System.getProperty("os.name");
        System.out.println("os.name：" + property2);

        String property3 = System.getProperty("os.version");
        System.out.println("os.version：" + property3);

        String property4 = System.getProperty("user.name");
        System.out.println("user.name：" + property4);

        String property5 = System.getProperty("user.home");
        System.out.println("user.home：" + property5);

        String property6 = System.getProperty("user.dir");
        System.out.println("user.dir：" + property6);
    }
}



















