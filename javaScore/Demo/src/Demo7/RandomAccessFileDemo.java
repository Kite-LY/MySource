package Demo7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	
	private static final String FilePath = "src/Demo7/Lyrice.sav";
	private static final String FilePath1 = "src/Demo7/LyriceCopy.txt";
	
	
	/**
	 * 使用RandomAccessFile实现文件的复制
	 */
	public static void CopyFile() {
		try(
			RandomAccessFile srcFile = new RandomAccessFile(new File(FilePath), "r");   //复制的文件
			RandomAccessFile newFile = new RandomAccessFile(new File(FilePath1), "rw");
			){
			//复制文件之前需要清空newFile
			newFile.setLength(0);
			//获得要复制文件的字节大小
			long srcLeng = srcFile.length();
			//构建自己数组，将文件放入 所窦建德数组
			byte[] bytes = new byte[(int)srcLeng];
			srcFile.read(bytes);
			//将字节数组写入新文件中
			newFile.write(bytes);
			System.out.println("文件复制成功");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) throws IOException {

		CopyFile();
		
		
		
//		File file = new File(FilePath);
//		if(! file.exists()) {
//			file.createNewFile();			//如果文件不存在创建新的文件
//		}
//		try(RandomAccessFile rFlie = new RandomAccessFile(file, "rw")){
//			rFlie.setLength(0);					//强制让文件大小清零 - 等价于删除文件中的所有内容
//			//写入20000个整型数据
//			for(int i =0; i < 2000; i++) {
//				rFlie.write(i);
//			}
//			//读取
//			System.out.println("当前文件大小：" + rFlie.length());
//			//移动问价指针
//			rFlie.seek( 4 * 8);
//			System.out.println("移动8个整型（32的字节)的值后：" + rFlie.readInt());
//			
//		}
//				
		
	}

}
