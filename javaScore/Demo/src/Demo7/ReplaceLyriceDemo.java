package Demo7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 * �޸��ļ��е�����
 * @author С����
 *
 */
public class ReplaceLyriceDemo {
	
	static final String  FilePath = "src/Demo7/Lyrice.sav";
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		//ʹ���ַ������в��� 
//		Reader reader = null;
//		BufferedReader bReader = null;
//		StringBuffer lyrice = new StringBuffer();
//		Writer writer = null;
//		BufferedWriter	bWriter = null;
//		String separator = System.getProperty("line.separator");
//		try {
//			reader = new FileReader(FilePath);
//			bReader = new BufferedReader(reader);
//			String line = null;
//			while((line = bReader.readLine()) != null)
//			{
//				lyrice.append(line);
//				lyrice.append(separator);			//ƴ��һ��ϵͳĬ�ϵķָ������ο�ƽ̨�Ͻ���ʹ�� separator
//			}
//			String newLyrice = lyrice.toString().replace("����", "�ܲ�");
//			//���޸ĺ���ļ�д��
//			writer = new FileWriter(FilePath);
//			bWriter	= new BufferedWriter(writer);
//			bWriter.write(newLyrice);
//			
//			
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			try {
//				bReader.close();
//				reader.close();
//				bWriter.close();
//				writer.close();
//				System.out.println("�ļ��޸���ɣ�");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
	}

}
