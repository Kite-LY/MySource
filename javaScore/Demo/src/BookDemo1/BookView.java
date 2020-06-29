package BookDemo1;
/**
 * 图书系统的视图
 * @author 小风筝
 *
 */

import java.util.Scanner;

public class BookView {
	private Scanner input = null;
	private BookBiz bookBiz = null;
	
	public BookView() {
		input = new Scanner(System.in);
		bookBiz = new BookBiz();
		System.out.println("***************************************");
		System.out.println("\t欢迎使用Kite图书管理系统");
		System.out.println("\t1.登录\t\t 2.退出系统");
		System.out.println("***************************************");
		System.out.print("请输入你的选择：");
		String choice= input.next();
		if("1".equals(choice)) {
			//执行登录操作
			System.out.println("默认已经登录！");
			showMainView();
		}
		System.out.println("系统退出！");
		
	}
	
	/**
	 * 判断是否退出
	 * @return
	 * 返回true 继续执行
	 * 返回false 系统退出
	 */
	public void showMainView() {
		System.out.println("\nKite图书管理系统》》主菜单");
		System.out.println("1.新增图书\t2.删除图书\t3.查看所有图书\t4.按编号查询\t5.图书入库\t6.图书出库\t7.系统退出");
		System.out.print("请输入你的选择：");
		String choice = input.next();
		switch (choice) {
		case "1":	//添加图书
			showAddNewBookView();
			showBooks(Dates.BookStore);
			break;
		case "2":	//删除图书
			showDelBookView();
			break;

		case "3":  //查看所有图书
			showBooks(null);
			break;

		case "4": 	//按编号查询
			showFindById(); 
			break;

		case "5":	//图书入库
			showInStroe();
			break;

		case "6":	//图书出库
			showOutStroe();
			break;

		case "7":
			
			return;		//系统退出

		default:
			break;

		}
		
		showMainView();
	}
	
	/**
	 * 图书出库
	 */
	public void showOutStroe() {
		//需要输入两个参数：图书Id，入库图书数量
		System.out.println("\nKite图书管理系统》》主菜单 》》图书出库");
		System.out.print("请输入图书编号：");
		String outId = input.next();
		System.out.print("请输入图书数量：");
		int outCount = input.nextInt();
		if(bookBiz.OutStroe(outId, outCount)) {
			System.out.println("出库成功！");
			showBooks(null);
		}
		else {
			System.out.println("出库失败！");
		}
	}
	
	/**
	 * 图书入库（只能输入仓库有的图书）
	 */
	
	public void showInStroe() {
		//需要输入两个参数：图书Id，入库图书数量
		System.out.println("\nKite图书管理系统》》主菜单 》》图书入库");
		System.out.print("请输入图书编号：");
		String inId = input.next();
		System.out.print("请输入图书数量：");
		int inCount = input.nextInt();
		if(bookBiz.inStroe(inId, inCount)) {
			System.out.println("入库成功！");
			showBooks(null);
		}
		else {
			System.out.println("入库失败！");
		}
		
	}
	
	/**
	 * 按编号查找图书
	 */
	public void showFindById() {
		System.out.println("\nKite图书管理系统》》主菜单 》》按编号查询");
		System.out.print("请输入要删除的图书编号：");
		String findId = input.next();
		Book findBook = bookBiz.findById(findId);			//findById的返回值为Book
		if(findBook == null) {
			System.out.println("未找到你要查找的书籍！");
			return;
		}
		showBooks(findBook);
		
	}
	
	/**
	 * 删除图书界面
	 */
	public void showDelBookView() {
		System.out.println("\nKite图书管理系统》》主菜单 》》 删除图书");
		//暂时只能根据输入的Id进行图书的删除
		System.out.print("请输入要删除的图书编号：");
		String delID = input.next();
		Book delBook = new Book();
		delBook.setBookId(delID);
		if(bookBiz.delBook(delBook)) {
			System.out.println("删除成功！");
			showBooks(null);		//打印默认仓库
			
		}else {
			System.out.println("删除失败！");
		}
	}
	
	
	public Book  showAddNewBookView() {
		System.out.println("\nKite图书管理系统》》主菜单 》》 新增图书");
		System.out.print("查证仓库是否存在此图书编号：");
		String bookId = input.next();
		//验证仓库是否存在
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null) {
			//不存在
			newBook = new Book();
//			private String bookId;			//图书的内部编号
//			private String bookName;		//图书名称
//			private String sibn;			//出版号
//			private String type;			//图书的类型
//			private String author;			//作者 - 暂时不进行使用
//			private String publisher;		//出版社- 暂时不进行使用
//			private int count;				//当前书籍的库存量
//			private double price;			//图书的单价
			System.out.println("此图书仓库不存在，请继续输入图书信息");
			newBook.setBookId(bookId);
			
			System.out.print("图书名称：");
			newBook.setBookName(input.next());
			
			System.out.print("图书出版号：");
			newBook.setSibn(input.next());
			
			
			System.out.print("图书库存量：");
			newBook.setCount(input.nextInt());
//			
			System.out.print("图书单价：");
	        newBook.setPrice(input.nextDouble());
	        
			bookBiz.addBook(newBook);		//调用图书业务对象添加图书
		}else {
			System.out.print("图书已经存在，请重新输入");
			newBook = showAddNewBookView();				//重新调用本方法 - - 递归调用
		}
		return newBook;
			
	}
	
	public void showBooks(Book ...BookArray) {
		 System.out.println("图书编号\t\t图书名称\t\t图书出版号\t\t图书库存量\t\t图书单价");
		 if(BookArray == null) {
			 BookArray = Dates.BookStore;			//显示默认的图书仓库
		 }
		 int bookCount = bookBiz.getBookCount(BookArray);
		 for (int i = 0; i < bookCount; i++) {
			System.out.print(
					BookArray[i].getBookId() + "\t\t" +
					BookArray[i].getBookName() + "\t\t" +
					BookArray[i].getSibn() + "\t\t" +
					BookArray[i].getCount() + "\t\t" +
					BookArray[i].getPrice() + "\t\t" 
					);
			 System.out.println();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
