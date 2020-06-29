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
 * 修改文件中的内容
 * @author 小风筝
 *
 */
public class ReplaceLyriceDemo {
	
	static final String  FilePath = "src/Demo7/Lyrice.sav";
	public static void main(String[] args) {
		
		
		
		
		
		
		
		
		
		
		
		
		//使用字符流进行操作 
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
//				lyrice.append(separator);			//拼接一个系统默认的分隔符，课跨平台上进行使用 separator
//			}
//			String newLyrice = lyrice.toString().replace("刘备", "曹操");
//			//将修改后的文件写入
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
//				System.out.println("文件修改完成！");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
	}

}
