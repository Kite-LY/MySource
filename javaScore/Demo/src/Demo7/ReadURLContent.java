package Demo7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * ��URL�϶�ȡ�ļ� - ��ʱֻ֧��HttoЭ��
 * @author С����
 *
 */
public class ReadURLContent {
	private final static String filePath1 = "D:\\java\\javaScore\\Demo\\src\\Demo7\\163.html";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL("http://www.163.com/index.html");
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()))){
			String line = null;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath1));
			bw.write(line);
			bw.close();
			System.out.println("�ļ�д����ɣ�");
		}
	}

}
