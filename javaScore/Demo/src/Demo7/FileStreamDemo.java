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
		System.out.println("�ļ��Ƿ���ڣ�" + file1.exists());
		System.out.println("�ļ��ľ���·����" + file1.getAbsolutePath());
		InputStream in = new FileInputStream(file1);
		byte[] bytes1 = new byte[20000];
		in.read(bytes1);
		String con = new String(bytes1);
		System.out.println(con);
		
		in.close();
	}
	
	//�ļ���д��
	public static void writeFile() throws IOException {
		//ע�⣺�ļ���������
		final String wFilePath = "src/Demo7/FileDemo.txt";
		OutputStream outStream = new FileOutputStream(wFilePath,true);
		String content = "����ҲҪ����ż" ;
		outStream.write(content.getBytes());
		
		outStream.close();
	}
	
	
	public static void ReadFile() throws IOException {
		InputStream inputStream =  new FileInputStream(file);
		//inputStream.available()  ��ȡ���������Զ�ȡ���ļ���С���ֽڴ�С��
		//��ȡ�ļ�����
		byte[] bytes = new byte[2000];
		inputStream.read(bytes);
//		int count = 0;
//		while((bytes[count] = (byte)inputStream.read()) != -1) {
//			count++;
//		}
		String content = new String(bytes);		//����ȡ���ֽ�����ת��Ϊ�ַ������ͣ��Ա��ӡ
		System.out.println(content);
		inputStream.close();
	}

}
