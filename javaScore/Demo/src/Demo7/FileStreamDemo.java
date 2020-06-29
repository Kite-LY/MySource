package Demo7;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileStreamDemo {

	private static String filePath = "src/Demo7/FileDemo.java";
	static File file = new File(filePath);
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//ReadFile();
		writeFile();
		
		File file1 = new File("src/Demo7/FileDemo.txt");
		System.out.println("文件是否存在：" + file1.exists());
		System.out.println("文件的绝对路径：" + file1.getAbsolutePath());
		InputStream in = new FileInputStream(file1);
		byte[] bytes1 = new byte[20000];
		in.read(bytes1);
		String con = new String(bytes1);
		System.out.println(con);
		
		in.close();
	}
	
	//文件的写入
	public static void writeFile() throws IOException {
		//注意：文件并不存在
		final String wFilePath = "src/Demo7/FileDemo.txt";
		OutputStream outStream = new FileOutputStream(wFilePath,true);
		String content = "今天也要加油偶" ;
		outStream.write(content.getBytes());
		
		outStream.close();
	}
	
	
	public static void ReadFile() throws IOException {
		InputStream inputStream =  new FileInputStream(file);
		//inputStream.available()  获取输入流可以读取的文件大小（字节大小）
		//读取文件操作
		byte[] bytes = new byte[2000];
		inputStream.read(bytes);
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1) {
//			count++;
//		}
		String content = new String(bytes);		//将读取的字节数组转换为字符串类型，以便打印
		System.out.println(content);
		inputStream.close();
	}

}
