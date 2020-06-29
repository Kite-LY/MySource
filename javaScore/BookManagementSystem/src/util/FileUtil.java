package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;

import entity.BookInfo;
import entity.User;

/**
 * 文件工具类
 * @author 小风筝
 *
 */


public class FileUtil {
	
	//本程序中，为了操作方便，我们把图书信息以对象流的方式存放在文件中
	private static final String BookInfoFilePath = "BookInfo.dat";		//相对的本程序的工程根目录
	
	private static final String UserInfoFilePath = "UserInfo.dat";
	/**
	 * 将传入的用户set写入到文件中
	 * @param userSet
	 */
	public static void SaveUser(Set<User> userSet) {
		SaveObject(userSet, UserInfoFilePath);
	}
	 
	@SuppressWarnings("unchecked")
	public static Set<User> ReadUser(){
		return (Set<User>)ReadObject(UserInfoFilePath);
	}
	
	/**
	 * 将传入的BookInfo的map信息存放到对应的文件当中 - 注意：读写时的数据结构一定要保持对应
	 * @param bookInfoMap
	 */
	public static void SaveBookInfoMap(Map<String, BookInfo> bookInfoMap) {
		SaveObject(bookInfoMap, BookInfoFilePath);
	}
	
	@SuppressWarnings("unchecked")
	public static Map<String, BookInfo> ReadBookInfoMap(){
		Object obj =  ReadObject(BookInfoFilePath);
		
		return (Map<String, BookInfo>)obj;
	}
	
	
	
	/**
	 * 通用的保存对象的方法
	 * @param object		要写入的文件的序列化对象
	 * @param filePath		文件路径
	 */
	
	public static void SaveObject(Object object, String filePath) {
		try (
				FileOutputStream fout = new FileOutputStream(filePath, false);			//false不允许追加
				ObjectOutputStream out = new ObjectOutputStream(fout);
			){
				out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * 从文件中读取对象 - 通用方法
	 * @param filePath
	 * @return
	 */
	
	public static Object ReadObject(String filePath) {
		try (
				FileInputStream fin = new FileInputStream(filePath);
				ObjectInputStream in = new ObjectInputStream(fin);
		){
			return in.readObject();
		} catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}






























