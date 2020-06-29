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
 * �ļ�������
 * @author С����
 *
 */


public class FileUtil {
	
	//�������У�Ϊ�˲������㣬���ǰ�ͼ����Ϣ�Զ������ķ�ʽ������ļ���
	private static final String BookInfoFilePath = "BookInfo.dat";		//��Եı�����Ĺ��̸�Ŀ¼
	
	private static final String UserInfoFilePath = "UserInfo.dat";
	/**
	 * ��������û�setд�뵽�ļ���
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
	 * �������BookInfo��map��Ϣ��ŵ���Ӧ���ļ����� - ע�⣺��дʱ�����ݽṹһ��Ҫ���ֶ�Ӧ
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
	 * ͨ�õı������ķ���
	 * @param object		Ҫд����ļ������л�����
	 * @param filePath		�ļ�·��
	 */
	
	public static void SaveObject(Object object, String filePath) {
		try (
				FileOutputStream fout = new FileOutputStream(filePath, false);			//false������׷��
				ObjectOutputStream out = new ObjectOutputStream(fout);
			){
				out.writeObject(object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	/**
	 * ���ļ��ж�ȡ���� - ͨ�÷���
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






























