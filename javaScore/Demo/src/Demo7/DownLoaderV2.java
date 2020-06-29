package Demo7;
//https://d2.xia12345.com/down/87/2020/03/rpsBCXGs.mp4   例子下载地址
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class DownLoaderV2 {

private static final int MAX_BUFFER_SIZE = 102400;			//设置下载的大小为10M
	
	public static void main(String[] args) {
		
		//1.打开http连接，获得要下载的内容的长度（格式是比较固定）
		//2.创建RandomAccessFile对象
		//3.将下载的内容缓存到字节数组当中
		//4.将缓存字节数组通过RandomAccessFile对象写入到文件当中（涉及到文件指针的操作）
		/** 要下载的文件网址 */
		Scanner input = new Scanner(System.in);
		System.out.println("请你输入要下载文件的地址：");
		final String StrUrl = input.next();
		HttpURLConnection connection = null;
		URL url;

		InputStream inStream = null;
		
		try {
				url = new URL(StrUrl);   	 //创建url对象，获得文件流
				connection = (HttpURLConnection) url.openConnection();
		//设置链接属性 -- Range指从服务器请求下载文件的字节数范围
				connection.setRequestProperty("Range",	"bytes = 0 -");				
				connection.connect();   		//链接到服务器
		//判断是否链接成功
		//100:指示信息，表示请求已被接受，继续操作
		//200.链接成功，
		//300.重定向，要请必须进行进一步的操作
		//400.客户端错误
		//500.服务器错误
			if(connection.getResponseCode() / 100 != 2) {
				System.out.println("链接的响应状态不在200范围之类，链接错误，请重试！");
				return;
			}
			
		int fileSize = connection.getContentLength();			//获得要下载的文件大小（字节数）
		inStream = connection.getInputStream();
		int downLoaded = 0;										//已下载的字节数 - 用来计算当前下载的百分比
		String  fileName = url.getFile();						//获得下载的文件名
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);//截取字符串，从最后一个 / 加1处开始截取
		@SuppressWarnings("resource")
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");//创建下载内容输入的文件
		file.setLength(0); 										//文件清零，及清空文件
		file.seek(0);											//将文件指针置零
		while(downLoaded < fileSize) {							//当前下载的字节数小于文件总大小，继续下载
			byte[]  buffer = null;								//下载缓存字节数组
			//判断未下载的大小是否超过最大的缓存数
			if(fileSize - downLoaded > MAX_BUFFER_SIZE)
			{
				buffer = new byte[MAX_BUFFER_SIZE];
			}else {
				buffer = new byte[fileSize - downLoaded];
			}
			//将缓存的内容读出来
			int currDownload = 0;
			int read = -1;										//实际的下载数
			long startTime = System.currentTimeMillis();		//计算下载速度
			while(currDownload < buffer.length) {
				read = inStream.read();							//一个一个读取字节
				if(read == -1) {
					break;										//已经下载完毕
				}
				buffer[currDownload] = (byte)read;				//当前下载的字节数放到缓存中
				currDownload++;
			}
			long endTime = System.currentTimeMillis();
		
			if(read == -1) break;
			double speed = 0;
			if(endTime - startTime >0) {
				speed = currDownload / 1024.0 /((double)(endTime -startTime) / 1000);
			}
			
			//将当前下载的缓存写入到文件中
			file.seek(downLoaded);								//设置文件指针
			file.write(buffer);
			downLoaded += currDownload;
//			System.out.println("当前的下载进度：" + downLoaded * 1.0  / fileSize * 10000 / 100 + "%" );
			System.out.printf("当前下载速度：%.1f k/s(%.1f M/s) \t当前下载进度：%.f%%\n", speed,speed / 1024,downLoaded);
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
