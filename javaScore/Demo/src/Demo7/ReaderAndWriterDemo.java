package Demo7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * ʹ���ַ������ļ����л����Ķ�д����
 * @author С����
 *
 */
public class ReaderAndWriterDemo {
	
	
	private final static String filePath1 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\FileDemo.java";
	private final static String filePath2 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\FileDemo2.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			
			//�̶��Ķ�����
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
		
		//д����
		String content = "�����ɫ���˽�";
		try(BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath2))) {
			//BufferedWriter bWriter = new BufferedWriter(new FileWriter(filePath2));
			bWriter.write(content);
			//bWriter.close();   //һ��Ҫ�ر��ַ���������Ҫ��д����ļ����ڻ�����
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
