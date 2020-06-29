package Demo7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferedStreamDemo {
	static final String FilePath1 = "D:/ss/oldqq.mp4";
	static final String FilePath2 = "D:/ss/�����ļ�.mp4";
	
	public static void main(String[] args) {
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[]	bytes = new byte[200];
//		System.out.println("�������ַ�����");
//		inStream.read(bytes);
//		System.out.println("�û���������ݣ�" + new String(bytes));
//	
		
		
		long time = CopyFileBufferedStrean();
		System.out.println("�ļ�����ʱ�䣺" + time + "����");
	}
	
	private static long CopyFileBufferedStrean() {
		
		File file1 = new File(FilePath1);
		if(!file1.exists()) {
			System.out.println("�ļ������ڣ�����ʧ�ܣ�");
			return 0;
		}
		long stratTime = System.currentTimeMillis();
		
		InputStream input = null;
		BufferedInputStream bInput = null;
		OutputStream outpout = null;
		BufferedOutputStream bOutput = null;
		
		try {
			input = new FileInputStream(file1);
			bInput = new BufferedInputStream(input);
			outpout = new FileOutputStream(FilePath2);
			bOutput = new BufferedOutputStream(outpout);
			int i = -1;	//������ʱ����
			while( (i = bInput.read()) != -1) {    //��i = -1 ��ʱ��ִ���������䣬��i = -1 ʱ�˳���������������
				bOutput.write(i);			//��ȡ�ļ�ֻд���˻����У���Ҫ����󣬽���������д���ļ��� ������ flush
			}
			System.out.println("�ļ����Ƴɹ���");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//bOutput.flush();   //��colse�������Ѿ�ʵ��
				bOutput.close();
				outpout.close();
				bInput.close();
				input.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		long endTime = System.currentTimeMillis();
		return endTime - stratTime;
		
	}
	
	
	
	
//	static final String filePath = "D:/java/javaScore\\Demo\\src\\Demo7\\FileDemo.txt";
//	static final String filePath1 = "D:/java/javaScore\\Demo\\src\\Demo7\\FileDemo2.txt";
//	public static void main(String[] args)  {
//		OutputStream outputStream = null;
//		try {
//			outputStream = new FileOutputStream(filePath1);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		BufferedOutputStream bOutStream = new BufferedOutputStream(outputStream,10234);
//		try {
//			bOutStream.write("123".getBytes());
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		
//	//BufferedInputStream bInputStream = null;
//		//FileInputStream inputStram = null;
//		try {
//			FileInputStream inputStram = new FileInputStream(filePath);
//			BufferedInputStream  bInputStream = new BufferedInputStream(inputStram);
//			byte[] bytes = new byte[bInputStream.available()];
//			bInputStream.read(bytes);
//			System.out.println(new String(bytes));
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//		}
//		
//		
//	}

}
