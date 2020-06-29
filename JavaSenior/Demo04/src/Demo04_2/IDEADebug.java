package Demo04_2;

import org.junit.Test;

public class IDEADebug {

    @Test
    public void IDEADubug(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());//4   拼接了4个字符

        System.out.println(sb);//“null”

        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }
}
