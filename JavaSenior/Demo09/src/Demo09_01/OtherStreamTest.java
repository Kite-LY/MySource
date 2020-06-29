package Demo09_01;

import org.junit.Test;

import java.io.*;

public class OtherStreamTest {
    public static void main(String[] args) {
        /**
         * 从键盘输入字符串，要求读取到的整行数据转换为大写进行输出，输入e 或者 exit 时 退出程序
         *
         */
        BufferedReader br = null;
        try {
            InputStreamReader  isr = new InputStreamReader(System.in);   //字节流转换为字符流
            br = new BufferedReader(isr);

            while(true){
                System.out.println("请输入转换的字符串：");
                String date = br.readLine();
                if("e".equals(date) || "exit".equals(date)){
                    System.out.println("程序运行结束！");
                    break;
                }
                String s = date.toUpperCase();
                System.out.println("转换后的字符：\n" + s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /**
     * 数据流DateOutputStream..
     */
    @Test
    public void test02() throws IOException {
        DataOutputStream da = new DataOutputStream(new FileOutputStream("data.txt"));
        da.writeUTF("刘备");
        da.flush();//刷新
        da.writeInt(12);
        da.flush();
        da.writeBoolean(true);
        da.flush();
        da.close();
    }

    /**
     * 注意读取文件的时候，顺序应该跟存入的顺序相同
     *
     * @throws IOException
     */
    @Test
    public void test03() throws IOException {
        DataInputStream di = new DataInputStream(new FileInputStream("data.txt"));

        //将打印在控制台上的数据System.out.println（）存储在了数据文件中
        PrintStream printStream = new PrintStream(new FileOutputStream("data1.txt"));
        if(printStream != null){
            System.setOut(printStream);
        }


        String s = di.readUTF();
        int i = di.readInt();
        boolean b = di.readBoolean();
        System.out.println("name: " + s);
        System.out.println("age: " + i);
        System.out.println("isMale: " + b);

    }

    @Test
    public void test04(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("ai.jpeg"));
            bos = new BufferedOutputStream(new FileOutputStream("aitest.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while((len = bis.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }
            System.out.println("文件复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
