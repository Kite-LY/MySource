package Demo04_1;

import org.junit.Test;

public class StringDemo2 {
    /**
     * 获取两个字符串中虽大的相同字符串。比如：str1 = “adcwerthelloyuiddef” str2 = “cvhellobnm”
     *提示：将端的那个串进行长度依次递减的字串与较长的串比较
     *
     */
    public String getMaxSameString(String str,String str1){
        String maxStr = (str.length() >= str1.length())? str:str1;
        String minStr = (str.length() < str1.length())? str:str1;
        int length = minStr.length();
        for(int i = 0; i < length; i++){
            for(int x = 0, y =length - i; y <= length; x++, y++){
                String subStr = minStr.substring(x,y);
                if(maxStr.contains(subStr)){
                    return subStr;
                }
            }
        }


        return null;
    }
    @Test
    public void test(){
        String str1 = "adcwerthelloyuiddef";
        String str2 = "cvhellobnm";
        String maxSameString = getMaxSameString(str1,str2);
        System.out.println(maxSameString);
    }
}
