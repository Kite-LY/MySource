package Demo03_1;


import org.junit.Test;

/**
 * 关于StringBufferg和StringBuilder的使用
 *
 */


public class StringBufferBuiderTest {
    /**
     * String,StringBuffer,StringBuilder三者的异同
     * String：不可变的字符序列，底层使用char[]存储
     * StringBuffer：可变的字符序列，线程是安全的，但是效率低，底层使用char[]存储
     * StringBuilder: 可变的字符数组，线程是不安全的，但是效率高，底层使用char[]存储
     *
     *
     * 源码分析：
     * String str = new String();  //char[] value = new char[0];
     * String str1 = new String("abc");//char[] value new char[]{"a","b","c"}
     *
     * StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个16为的char【】存贮
     * StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char['abc'.length + 16];
     *  StringBuffer的扩容问题：默认情况下原来的容量* 2 +  2；同时复制原来数组中的内容
     */

    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("adc");   //会额外的加16位
        sb1.append("zhoerwerwerwerwerwerwerwerewng");
        sb1.setCharAt(0, 'n');
        System.out.println(sb1);
        System.out.println(sb1.capacity());
        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.capacity());
    }
    /**
     * StringBuffer的常用方法：
     *  StringBuffer append（XXX）：提供了很多的append（）方法，用于字符串的拼接
     *               delete（int start， int end）：删除指定位置的内容
     *               replace（in start， int end）：把该区间的内容进行替换
     *               insert（int offset， XXX）：在指定的位置进行插入
     *               reverse（）：将当前的字符串进行序列逆转
     *  public int indexOf(String str)
     *  public String substring(int start, int end)
     *  public int Length()
     *  public char charAt(int n)
     *  public void SetCharAt(int n, char ch)
     *
     */

    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append("1");
        System.out.println(s1);
        //s1.delete(2,4);     //左闭又开
        s1.replace(2,4,"hello");
        s1.insert(2,"ww");
        s1.reverse();  //反转
        System.out.println(s1);
        System.out.println(s1.length());
        String substring = s1.substring(1, 2);
        System.out.println(substring);

    }














}
