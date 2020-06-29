package Demo7;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.Scanner;

/**下载的原理
*当前的案例中实现早http协议中下载文件
*1.将文件流以缓冲流的方式读取到内存当中
*2.将缓存中的数据分块写入到硬盘上面（使用RandomAccessFile）
*
*注意（缓存等价于字节数组）
*/ 
public class Downloader_RandomAccerssFile {
	
	
	/** 初始化要下载文件的大小  - 1M/10K大小*/
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
		BufferedInputStream bInpt = null;			//缓存读入文件流
		
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
		bInpt = new BufferedInputStream(connection.getInputStream(),MAX_BUFFER_SIZE);
		int downLoaded = 0;										//已下载的字节数 - 用来计算当前下载的百分比
		String  fileName = url.getFile();						//获得下载的文件名
		fileName = fileName.substring(fileName.lastIndexOf("/") + 1);//截取字符串，从最后一个 / 加1处开始截取
		RandomAccessFile file = new RandomAccessFile(fileName, "rw");//创建下载内容输入的文件
		file.setLength(0); 										//文件清零，及清空文件
		file.seek(0);											//将文件指针置零
		while(downLoaded < fileSize) {							//当前下载的字节数小于文件总大小，继续下载
			byte[]  buffer = null;								//下载缓存字节数组
			//判断未下载的大小石佛超过最大的缓存数
			if(fileSize - downLoaded > MAX_BUFFER_SIZE)
			{
				buffer = new byte[MAX_BUFFER_SIZE];
			}else {
				buffer = new byte[fileSize - downLoaded];
			}
			//将缓存的内容读出来
			int read = bInpt.read(buffer);						//读取下载的文件
			if(read == -1) {
				//下载完成
				break;
			}
			//将当前下载的缓存写入到文件中
			file.seek(downLoaded);								//设置文件指针
			file.write(buffer, 0, read);
			downLoaded += read;
			System.out.println("当前的下载进度：" + downLoaded * 1.0  / fileSize * 10000 / 100 + "%" );
			
		}
		
		
		
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
		catch (IOException e) {
			e.printStackTrace();
		}finally {
			connection.disconnect(); 
			try {
				bInpt.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
