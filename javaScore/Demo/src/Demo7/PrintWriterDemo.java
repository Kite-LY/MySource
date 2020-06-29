package Demo7;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter和PrintStream
 * PrintWriter用来处理字符流，一次写入两个字节
 * printStram用来处理字节流一次写入一个字节
 * 建议：在处理文本的时候，使用PrintWriter
 * @author 小风筝
 *
 */
public class PrintWriterDemo {
	private final static String filePath2 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\FileDemo2.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintWriter writer1 = new PrintWriter(System.out);
		writer1.print("使用printWriter打印出来的内容");
		//writer1.close();
		writer1.flush();			//技术字符输入流
		
//		String separator = System.getProperty("line.separator ");
////		String content = "今天也要开开心偶" + separator;
////		content += "今天也要努力偶！";
////		
////		try( PrintWriter pWriter = new PrintWriter(new File(filePath2))) {
////			pWriter.write(content);
////			System.out.println("文件写入成功！");
////		} catch (Exception e) {
////			// TODO: handle exception
////		}
//		
//		try {
//			System.out.println("yu");
//			Scanner input = new Scanner(new File(filePath2));
//			StringBuffer value = new StringBuffer();
//			while(input.hasNextLine()) {
//				value.append(input.hasNextLine());
//				value.append(separator);
//			}
//			System.out.println("以下是读取的内容：");
//			System.out.println(value.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
