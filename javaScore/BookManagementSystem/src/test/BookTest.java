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
		//测试图书实体类的定义();
		//测试图书业务类();
		//测试图书的出库入库();
		//测试角色();
		测试用户类();
		
	}
	
	public static void 测试用户类() {
		User user = new User(new Role("齐天大圣", "administrator"));
		user.setUserName("孙悟空");
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
	
	
	public static void 测试角色() {
		Role role1 = new Role();
		System.out.println(role1.getName() + "\t" + role1.getKey());
		System.out.println("权限集合：" + role1.getPermisstions());
		System.out.println(role1.inStore("123", 12));
		
		
//		Role role2 = new Role("操作员", "oparator");
//		System.out.println(role2.getName() + "\t" + role2.getKey());
//		System.out.println("权限集合：" + role2.getPermisstions());
	}
	
	public static void 测试图书的出库入库() 
	{
		Scanner input = new Scanner(System.in);
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		
		//随机添加5本isbn相同的书
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("天龙八部");
		for(int i = 0; i < 5; i++) {
			Book book = new Book();
			book.setIsbn("123-456");//同一本书的isbn一致
			book.setBookId((i + 1) + "");
			bookInfo.addBook(book);
		}
		Map<String, BookInfo> infoMap = new HashMap<>();
		//向集合中添加一种书籍
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		//将图书信息集合写入到文件当中
		FileUtil.SaveBookInfoMap(infoMap);
		
		//入库
		System.out.println("请输入图书的出版编号：");
		String isbn = input.next();
		boolean isInStroeSuccess = bookInfoBiz.inStroe(isbn, 15);
		System.out.println("是否入库成功：" + isInStroeSuccess);
		BookInfo currBookInfo = bookInfoBiz.findIsbn(isbn);
		System.out.println("当前库存：" + currBookInfo.getInStroeCount());
		
		//出库
		boolean isOutStroeSuccess = bookInfoBiz.outStore(isbn, 9);
		//重新赋值currBookInfo中的isbn对应的库存
		currBookInfo = bookInfoBiz.findIsbn(isbn);
		System.out.println("是否出库成功：" + isOutStroeSuccess);
		System.out.println("当前库存：" + currBookInfo.getInStroeCount());
		
		
	}
	
	public static void 测试图书实体类的定义() {
		BookInfo bookInfo = new BookInfo();
		bookInfo.setIsbn("123-456");
		bookInfo.setName("天龙八部");
		
		Book book = new Book();
		book.setIsbn("123-456");
		
		bookInfo.addBook(book);
		
		Map<String, BookInfo> infoMap = new HashMap<String, BookInfo>();
		infoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(infoMap);
		
		System.out.println(book.getBookInfo().getName());
		
		infoMap = FileUtil.ReadBookInfoMap();
		System.out.println("从文件中读取图书信息：");
		for(String isbn : infoMap.keySet()) {
			System.out.println(isbn);
		}
	}
	
	
	public static void 测试图书业务类(){
		BookInfoBiz bookInfoBiz = new BookInfoBizImplV1();
		bookInfoBiz.findById("123");
	}
	
}


