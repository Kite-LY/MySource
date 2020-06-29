package BookDemo1;
/**
 * 模拟的数据仓科
 * @author 小风筝
 *
 */
public class Dates {
	/** 用来保存所用图书信息的数组 - 图书的仓库  */
	public static Book[] BookStore = new Book[999];
	
	//使用静态块添加信息
	static {
		Book book1 = new Book();
		book1.setBookId( "001");
		book1.setBookName("天龙八部1");
		book1.setSibn("12345 - 1");
		book1.setCount(100);
		book1.setPrice(60.1);
		BookStore[0] = book1;
		
		Book book2 = new Book();
		book2.setBookId( "002");
		book2.setBookName("天龙八部2");
		book2.setSibn("12345 - 2");
		book2.setCount(100);
		book2.setPrice(60.1);
		BookStore[1] = book2;
		
		Book book3 = new Book();
		book3.setBookId( "003");
		book3.setBookName("天龙八部3");
		book3.setSibn("12345 - 3");
		book3.setCount(100);
		book3.setPrice(60.1);
		BookStore[2] = book3;
		
		Book book4 = new Book();
		book4.setBookId( "004");
		book4.setBookName("天龙八部4");
		book4.setSibn("12345 - 4");
		book4.setCount(100);
		book4.setPrice(60.1);
		BookStore[3] = book4;
		
		Book book5 = new Book();
		book5.setBookId( "005");
		book5.setBookName("天龙八部5");
		book5.setSibn("12345 - 5");
		book5.setCount(100);
		book5.setPrice(60.1);
		BookStore[4] = book5;
	}
}
