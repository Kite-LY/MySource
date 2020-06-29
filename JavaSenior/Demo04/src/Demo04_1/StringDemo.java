package Demo04_1;

import org.junit.Test;

public class StringDemo {

    /**
     * 将一个字符串进行反转，将字符串指定的部分进行反转，比如abcdefg反转为abfedcg
     *
     */

    //方法一：转换为char【】 数组
    public String reverse(String str,int startIndex, int endIndex){
        if (str != null){
            char[] arr = str.toCharArray();
            for(int x = startIndex, y = endIndex; x < y; x++, y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }

        return null;
    }

    //使用String进行拼接
    public String reverse1(String str,int startIndex, int endIndex){
        if(str != null){
            //第一部分
            String reverseStr = str.substring(0,startIndex);
            //第二部分
            for(int i = endIndex; i >= startIndex; i--){
                reverseStr += str.charAt(i);
            }
            //第三部分
            reverseStr += str.substring(endIndex + 1);
            return reverseStr;
        }


        return null;
    }

    //方式三：使用StringBuffer或者StringBuilder替换String
    public String reverse2(String str,int startIndex, int endIndex){
        if(str != null){
            //第一部分
            StringBuilder sb = new StringBuilder(str.substring(0,startIndex));
            //第二部分
            for(int i = endIndex; i >= startIndex; i--){
                sb.append(str.charAt(i));
            }
            //第三部分
            sb.append(str.substring(endIndex + 1)) ;
            return sb.toString();
        }


        return null;
    }

    @Test
    public void test01(){
        String str = "adcdefg";
        String str1 = reverse(str,2,5);
        System.out.println(str1);

        String str2 = reverse1(str,2,5);
        System.out.println(str2);

        String str3 = reverse2(str,2,5);
        System.out.println(str3);
    }
}
