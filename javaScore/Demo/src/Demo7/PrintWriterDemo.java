package Demo7;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * PrintWriter��PrintStream
 * PrintWriter���������ַ�����һ��д�������ֽ�
 * printStram���������ֽ���һ��д��һ���ֽ�
 * ���飺�ڴ����ı���ʱ��ʹ��PrintWriter
 * @author С����
 *
 */
public class PrintWriterDemo {
	private final static String filePath2 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\FileDemo2.txt";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintWriter writer1 = new PrintWriter(System.out);
		writer1.print("ʹ��printWriter��ӡ����������");
		//writer1.close();
		writer1.flush();			//�����ַ�������
		
//		String separator = System.getProperty("line.separator ");
////		String content = "����ҲҪ������ż" + separator;
////		content += "����ҲҪŬ��ż��";
////		
////		try( PrintWriter pWriter = new PrintWriter(new File(filePath2))) {
////			pWriter.write(content);
////			System.out.println("�ļ�д��ɹ���");
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
//			System.out.println("�����Ƕ�ȡ�����ݣ�");
//			System.out.println(value.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
