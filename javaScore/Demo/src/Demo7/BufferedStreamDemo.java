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
	static final String FilePath2 = "D:/ss/复制文件.mp4";
	
	public static void main(String[] args) {
//		BufferedInputStream inStream = new BufferedInputStream(System.in);
//		byte[]	bytes = new byte[200];
//		System.out.println("请输入字符串：");
//		inStream.read(bytes);
//		System.out.println("用户输入的内容：" + new String(bytes));
//	
		
		
		long time = CopyFileBufferedStrean();
		System.out.println("文件拷贝时间：" + time + "毫秒");
	}
	
	private static long CopyFileBufferedStrean() {
		
		File file1 = new File(FilePath1);
		if(!file1.exists()) {
			System.out.println("文件不存在！复制失败！");
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
			int i = -1;	//定义临时变量
			while( (i = bInput.read()) != -1) {    //当i = -1 的时候执行下面的语句，当i = -1 时退出程序，则不满足条件
				bOutput.write(i);			//读取文件只写到了缓存中！需要在最后，将缓存内容写到文件中 方法： flush
			}
			System.out.println("文件复制成功！");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				//bOutput.flush();   //在colse方法中已经实现
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
