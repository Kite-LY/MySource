package BookDemo1;
/**
 * ģ������ݲֿ�
 * @author С����
 *
 */
public class Dates {
	/** ������������ͼ����Ϣ������ - ͼ��Ĳֿ�  */
	public static Book[] BookStore = new Book[999];
	
	//ʹ�þ�̬�������Ϣ
	static {
		Book book1 = new Book();
		book1.setBookId( "001");
		book1.setBookName("�����˲�1");
		book1.setSibn("12345 - 1");
		book1.setCount(100);
		book1.setPrice(60.1);
		BookStore[0] = book1;
		
		Book book2 = new Book();
		book2.setBookId( "002");
		book2.setBookName("�����˲�2");
		book2.setSibn("12345 - 2");
		book2.setCount(100);
		book2.setPrice(60.1);
		BookStore[1] = book2;
		
		Book book3 = new Book();
		book3.setBookId( "003");
		book3.setBookName("�����˲�3");
		book3.setSibn("12345 - 3");
		book3.setCount(100);
		book3.setPrice(60.1);
		BookStore[2] = book3;
		
		Book book4 = new Book();
		book4.setBookId( "004");
		book4.setBookName("�����˲�4");
		book4.setSibn("12345 - 4");
		book4.setCount(100);
		book4.setPrice(60.1);
		BookStore[3] = book4;
		
		Book book5 = new Book();
		book5.setBookId( "005");
		book5.setBookName("�����˲�5");
		book5.setSibn("12345 - 5");
		book5.setCount(100);
		book5.setPrice(60.1);
		BookStore[4] = book5;
	}
}
