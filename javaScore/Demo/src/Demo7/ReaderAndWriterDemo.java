package Demo7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 使用字符流对文件进行基本的读写操作
 * @author 小风筝
 *
 */
public class ReaderAndWriterDemo {
	
	
	private final static String filePath1 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\FileDemo.java";
	private final static String filePath2 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\FileDemo2.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//固定的读操作
			BufferedReader bReader = new BufferedReader(new FileReader(filePath1));
			String line = null;
			while( (line = bReader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//写操作
		String content = "今天白色情人节";
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath2))) {
			//BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath2));
			bWriter.write(content);
			//bWriter.close();   //一定要关闭字符输入流，要不写入的文件还在缓冲区
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
