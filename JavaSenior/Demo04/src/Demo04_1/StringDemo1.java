package Demo04_1;

import org.junit.Test;

public class StringDemo1 {
    /**
     *获取一个字符串在另一个字符串出现的次数
     * 例如：获取ab 在abkkcadkabkbfkabkskab中出现的次数
     */

    /**
     * 获取subStr在mainStr中出现的次数
     * @param mainStr
     * @param subStr
     * @return
     */
    //方式一：
    public int getCount(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index;
        if(mainLength >= subLength){
            while((index = mainStr.indexOf(subStr)) != -1){ //注释：indexOf() 方法对大小写敏感！如果要检索的字符串值没有出现，则该方法返回 -1。 检测submain在main中出现没
                count++;
                mainStr = mainStr.substring(index + subStr.length());
            }
            return count;
        }
        else{
            return -1;
        }

    }
    //方式二
    public int getCount1(String mainStr, String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){
            while((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }

            return count;
        }
        else{
            return -1;
        }

    }
    @Test
    public void test01(){
        String mainString = "abkkcadkabkbfkabkskab";
        String subString = "ab";
        int count = getCount(mainString,subString);
        System.out.println(count);

        int count1 = getCount1(mainString,subString);
        System.out.println(count1);
    }
}
