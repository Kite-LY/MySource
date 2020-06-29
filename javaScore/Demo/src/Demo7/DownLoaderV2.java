package Demo7;
//https://d2.xia12345.com/down/87/2020/03/rpsBCXGs.mp4   �������ص�ַ
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DownLoaderV2 {

private static final int MAX_BUFFER_SIZE = 102400;			//�������صĴ�СΪ10M
	
	public static void main(String[] args) {
		
		//1.��http���ӣ����Ҫ���ص����ݵĳ��ȣ���ʽ�ǱȽϹ̶���
		//2.����RandomAccessFile����
		//3.�����ص����ݻ��浽�ֽ����鵱��
		//4.�������ֽ�����ͨ��RandomAccessFile����д�뵽�ļ����У��漰���ļ�ָ��Ĳ�����
		/** Ҫ���ص��ļ���ַ */
		Scanner input = new Scanner(System.in);
		System.out.println("��������Ҫ�����ļ��ĵ�ַ��");
		final String StrUrl = input.next();
		HttpURLConnection connection = null;
		URL url;

		InputStream inStream = null;
		
		try {
				url = new URL(StrUrl);   	 //����url���󣬻���ļ���
				connection = (HttpURLConnection) url.openConnection();
		//������������ -- Rangeָ�ӷ��������������ļ����ֽ�����Χ
				connection.setRequestProperty("Range",	"bytes = 0 -");				
				connection.connect();   		//���ӵ�������
		//�ж��Ƿ����ӳɹ�
		//100:ָʾ��Ϣ����ʾ�����ѱ����ܣ���������
		//200.���ӳɹ���
		//300.�ض���Ҫ�������н�һ���Ĳ���
		//400.�ͻ��˴���
		//500.����������
			if(connection.getResponseCode() / 100 != 2) {
				System.out.println("���ӵ���Ӧ״̬����200��Χ֮�࣬���Ӵ��������ԣ�");
				return;
			}
			
		int fileSize = connection.getContentLength();			//���Ҫ���ص��ļ���С���ֽ�����
		inStream = connection.getInputStream();
		int downLoaded = 0;										//�����ص��ֽ��� - �������㵱ǰ���صİٷֱ�
		String  fileName = url.getFile();						//������ص��ļ���
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);//��ȡ�ַ����������һ�� / ��1����ʼ��ȡ
		@SuppressWarnings("resource")
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");//������������������ļ�
		file.setLength(0); 										//�ļ����㣬������ļ�
		file.seek(0);											//���ļ�ָ������
		while(downLoaded < fileSize) {							//��ǰ���ص��ֽ���С���ļ��ܴ�С����������
			byte[]  buffer = null;								//���ػ����ֽ�����
			//�ж�δ���صĴ�С�Ƿ񳬹����Ļ�����
			if(fileSize - downLoaded > MAX_BUFFER_SIZE)
			{
				buffer = new byte[MAX_BUFFER_SIZE];
			}else {
				buffer = new byte[fileSize - downLoaded];
			}
			//����������ݶ�����
			int currDownload = 0;
			int read = -1;										//ʵ�ʵ�������
			long startTime = System.currentTimeMillis();		//���������ٶ�
			while(currDownload < buffer.length) {
				read = inStream.read();							//һ��һ����ȡ�ֽ�
				if(read == -1) {
					break;										//�Ѿ��������
				}
				buffer[currDownload] = (byte)read;				//��ǰ���ص��ֽ����ŵ�������
				currDownload++;
			}
			long endTime = System.currentTimeMillis();
		
			if(read == -1) break;
			double speed = 0;
			if(endTime - startTime >0) {
				speed = currDownload / 1024.0 /((double)(endTime -startTime) / 1000);
			}
			
			//����ǰ���صĻ���д�뵽�ļ���
			file.seek(downLoaded);								//�����ļ�ָ��
			file.write(buffer);
			downLoaded += currDownload;
//			System.out.println("��ǰ�����ؽ��ȣ�" + downLoaded * 1.0  / fileSize * 10000 / 100 + "%" );
			System.out.printf("��ǰ�����ٶȣ�%.1f k/s(%.1f M/s) \t��ǰ���ؽ��ȣ�%.f%%\n", speed,speed / 1024,downLoaded);
		}
		
		
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			connection.disconnect(); 
		
		}
	
	}
}
