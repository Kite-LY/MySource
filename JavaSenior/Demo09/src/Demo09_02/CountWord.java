package Demo09_02;

import org.junit.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 统计一个文档中的所有字符出现的次数
 *
 */
public class CountWord {

    @Test
    public void test01(){
        FileReader fileReader = null;

        BufferedWriter bufferedWriter = null;
        try {
            //读取文件中的字符
            Map<Character,Integer> map = new HashMap<>();
            fileReader = new FileReader(new File("C:\\Users\\小风筝\\Desktop\\u.doc"));

            int c;
            while((c = fileReader.read()) != -1){
                char ch = (char)c;
                if(map.get(ch) == null){
                    map.put(ch,1);
                }else {
                    map.put(ch, map.get(ch)+1);
                }
                //System.out.println(ch);
            }
            System.out.println("从文件中提取成功！");

            //遍历map，统计数据
            bufferedWriter = new BufferedWriter(new FileWriter("count.txt"));
            Set<Map.Entry<Character,Integer>> entries = map.entrySet();
            for(Map.Entry<Character,Integer> entry : entries){
                switch (entry.getKey()){
                    case ' ':
                        bufferedWriter.write("空格出现次数：" + entry.getValue());
                        break;
                    default:
                        bufferedWriter.write(entry.getKey() + "出现次数：" + entry.getValue());
                        break;
                }

                bufferedWriter.newLine();
            }
            System.out.println("数据写入成功！");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if(bufferedWriter != null){
                    bufferedWriter.close();
                }
                if(fileReader != null){
                    fileReader.close();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }






    }

}
