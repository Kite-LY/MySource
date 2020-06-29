package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import auth.Role;
import biz.BookInfoBiz;
import biz.impl.BookInfoBizImplV1;
import entity.Book;
import entity.BookInfo;
import entity.User;
import util.FileUtil;
import view.BookView;

public class BookTest {
	public static void main(String[] args) {
		//����ͼ��ʵ����Ķ���();
		//����ͼ��ҵ����();
		//����ͼ��ĳ������();
		//���Խ�ɫ();
		�����û���();
		
	}
	
	public static void �����û���() {
		User user = new User(new Role("�����ʥ", "administrator"));
		user.setUserName("�����");
		user.setPassword("123");
		Set<User> userSet = new HashSet<>();
		userSet.add(user);
		FileUtil.SaveUser(userSet);
		
		new BookView();
		
//		userSet = FileUtil.ReadUser();
//		for(User u : userSet) {
//			System.out.println(u.getUserName() + "," + u.getRole().getName());
//		}
//		
		
	}
	
	
	public static void ���Խ�ɫ() {
		Role role1 = new Role();
		System.out.println(role1.getName() + "\t" + role1.getKey());
		System.out.println("Ȩ�޼��ϣ�" + role1.getPermisstions());
		System.out.println(role1.inStore("123", 12));
		
		
//		Role role2 = new Role("����Ա", "oparator");
//		System.out.println(role2.getName() + "\t" + role2.getKey());
//		System.out.println("Ȩ�޼��ϣ�" + role2.getPermisstions());
	}
	
	public static void ����ͼ��ĳ������() 
	{
		Scanner input = new Scanner(System.in);
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		
		//������5��isbn��ͬ����
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("�����˲�");
		for(int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setIsbn("123-456");//ͬһ�����isbnһ��
			book.setBookId((i + 1) + "");
			bookInfo.addBook(book);
		}
		Map<String, BookInfo> infoMap = new HashMap<>();
		//�򼯺������һ���鼮
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		//��ͼ����Ϣ����д�뵽�ļ�����
		FileUtil.SaveBookInfoMap(infoMap);
		
		//���
		System.out.println("������ͼ��ĳ����ţ�");
		String isbn = input.next();
		boolean isInStroeSuccess = bookInfoBiz.inStroe(isbn, 15);
		System.out.println("�Ƿ����ɹ���" + isInStroeSuccess);
		BookInfo currBookInfo = bookInfoBiz.findIsbn(isbn);
		System.out.println("��ǰ��棺" + currBookInfo.getInStroeCount());
		
		//����
		boolean isOutStroeSuccess = bookInfoBiz.outStore(isbn, 9);
		//���¸�ֵcurrBookInfo�е�isbn��Ӧ�Ŀ��
		currBookInfo = bookInfoBiz.findIsbn(isbn);
		System.out.println("�Ƿ����ɹ���" + isOutStroeSuccess);
		System.out.println("��ǰ��棺" + currBookInfo.getInStroeCount());
		
		
	}
	
	public static void ����ͼ��ʵ����Ķ���() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("�����˲�");
		
		Book book = new Book();
		book.setIsbn("123-456");
		
		bookInfo.addBook(book);
		
		Map<String, BookInfo> infoMap = new HashMap<String, BookInfo>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		
		System.out.println(book.getBookInfo().getName());
		
		infoMap = FileUtil.ReadBookInfoMap();
		System.out.println("���ļ��ж�ȡͼ����Ϣ��");
		for(String isbn : infoMap.keySet()) {
			System.out.println(isbn);
		}
	}
	
	
	public static void ����ͼ��ҵ����(){
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		bookInfoBiz.findById("123");
	}
	
}


