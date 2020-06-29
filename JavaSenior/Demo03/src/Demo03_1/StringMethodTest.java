package Demo03_1;


import org.junit.Test;

public class StringMethodTest {
    /**
     * int length(): 返回字符串的长度：return value.ength
     * char charAt(int index):返回某个索引处的字符return value[index]
     * boolean isEmpty(): 判断是否是空字符：return value.length == 0;
     * String toLowerCase(): 使用默认语言环境，将String 中的所用字符转换为小写
     * String toUpperCase():使用默认的语言环境，将String 中所用的字符转换为大写
     * String trim(): 返回字符串的副本，忽略前面和后面的空白
     * boolean equals(Object obj): 比较自负床的内容是否相同
     * boolean equalsIgnoreCase(String anotherString): 和wquals方法类似，但是忽略大小写
     * String concat(String str): 将指定的字符串连接到此字符串的结尾，等价于“+”
     * int compareTo(String anotherString): 比较两个字符的大小
     * String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取
     * String substring(int beginIndex, int endIndex):返回一个新的字符串，是从beginIndex到endINdex截取的内容
     *
     */
    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1);
        System.out.println(s1.trim());

        System.out.println(s1.length());
        System.out.println(s1.charAt(2));
        System.out.println(s1.isEmpty());
        System.out.println(s1.toLowerCase());
        System.out.println(s1.toUpperCase());


    }


    /**
     * boolean endWith(String suffix):测试字符串是否以指定的后缀结束
     * boolean startsWith(String prefix):测试此字符串是否以指定的前缀开始
     * boolean startsWith(String prefix, int toffset):测试此字符串从指定的索引开始的字符串是否以指定的前缀开始
     *
     */

    @Test
    public void test2(){
        String s2 = "HelloWorld";

        boolean b1 = s2.endsWith("ld");
        System.out.println(b1);

        boolean b2 = s2.startsWith("ld");
        System.out.println(b2);

        boolean b3 = s2.startsWith("ll",2);
        System.out.println(b3);

        boolean b4 = s2.contains("He");
        System.out.println(b4);
    }

}
