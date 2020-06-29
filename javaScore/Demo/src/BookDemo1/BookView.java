package BookDemo1;
/**
 * ͼ��ϵͳ����ͼ
 * @author С����
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
		System.out.println("\t��ӭʹ��Kiteͼ�����ϵͳ");
		System.out.println("\t1.��¼\t\t 2.�˳�ϵͳ");
		System.out.println("***************************************");
		System.out.print("���������ѡ��");
		String choice= input.next();
		if("1".equals(choice)) {
			//ִ�е�¼����
			System.out.println("Ĭ���Ѿ���¼��");
			showMainView();
		}
		System.out.println("ϵͳ�˳���");
		
	}
	
	/**
	 * �ж��Ƿ��˳�
	 * @return
	 * ����true ����ִ��
	 * ����false ϵͳ�˳�
	 */
	public void showMainView() {
		System.out.println("\nKiteͼ�����ϵͳ�������˵�");
		System.out.println("1.����ͼ��\t2.ɾ��ͼ��\t3.�鿴����ͼ��\t4.����Ų�ѯ\t5.ͼ�����\t6.ͼ�����\t7.ϵͳ�˳�");
		System.out.print("���������ѡ��");
		String choice = input.next();
		switch (choice) {
		case "1":	//���ͼ��
			showAddNewBookView();
			showBooks(Dates.BookStore);
			break;
		case "2":	//ɾ��ͼ��
			showDelBookView();
			break;

		case "3":  //�鿴����ͼ��
			showBooks(null);
			break;

		case "4": 	//����Ų�ѯ
			showFindById(); 
			break;

		case "5":	//ͼ�����
			showInStroe();
			break;

		case "6":	//ͼ�����
			showOutStroe();
			break;

		case "7":
			
			return;		//ϵͳ�˳�

		default:
			break;

		}
		
		showMainView();
	}
	
	/**
	 * ͼ�����
	 */
	public void showOutStroe() {
		//��Ҫ��������������ͼ��Id�����ͼ������
		System.out.println("\nKiteͼ�����ϵͳ�������˵� ����ͼ�����");
		System.out.print("������ͼ���ţ�");
		String outId = input.next();
		System.out.print("������ͼ��������");
		int outCount = input.nextInt();
		if(bookBiz.OutStroe(outId, outCount)) {
			System.out.println("����ɹ���");
			showBooks(null);
		}
		else {
			System.out.println("����ʧ�ܣ�");
		}
	}
	
	/**
	 * ͼ����⣨ֻ������ֿ��е�ͼ�飩
	 */
	
	public void showInStroe() {
		//��Ҫ��������������ͼ��Id�����ͼ������
		System.out.println("\nKiteͼ�����ϵͳ�������˵� ����ͼ�����");
		System.out.print("������ͼ���ţ�");
		String inId = input.next();
		System.out.print("������ͼ��������");
		int inCount = input.nextInt();
		if(bookBiz.inStroe(inId, inCount)) {
			System.out.println("���ɹ���");
			showBooks(null);
		}
		else {
			System.out.println("���ʧ�ܣ�");
		}
		
	}
	
	/**
	 * ����Ų���ͼ��
	 */
	public void showFindById() {
		System.out.println("\nKiteͼ�����ϵͳ�������˵� ��������Ų�ѯ");
		System.out.print("������Ҫɾ����ͼ���ţ�");
		String findId = input.next();
		Book findBook = bookBiz.findById(findId);			//findById�ķ���ֵΪBook
		if(findBook == null) {
			System.out.println("δ�ҵ���Ҫ���ҵ��鼮��");
			return;
		}
		showBooks(findBook);
		
	}
	
	/**
	 * ɾ��ͼ�����
	 */
	public void showDelBookView() {
		System.out.println("\nKiteͼ�����ϵͳ�������˵� ���� ɾ��ͼ��");
		//��ʱֻ�ܸ��������Id����ͼ���ɾ��
		System.out.print("������Ҫɾ����ͼ���ţ�");
		String delID = input.next();
		Book delBook = new Book();
		delBook.setBookId(delID);
		if(bookBiz.delBook(delBook)) {
			System.out.println("ɾ���ɹ���");
			showBooks(null);		//��ӡĬ�ϲֿ�
			
		}else {
			System.out.println("ɾ��ʧ�ܣ�");
		}
	}
	
	
	public Book  showAddNewBookView() {
		System.out.println("\nKiteͼ�����ϵͳ�������˵� ���� ����ͼ��");
		System.out.print("��֤�ֿ��Ƿ���ڴ�ͼ���ţ�");
		String bookId = input.next();
		//��֤�ֿ��Ƿ����
		Book newBook = bookBiz.findById(bookId);
		if(newBook == null) {
			//������
			newBook = new Book();
//			private String bookId;			//ͼ����ڲ����
//			private String bookName;		//ͼ������
//			private String sibn;			//�����
//			private String type;			//ͼ�������
//			private String author;			//���� - ��ʱ������ʹ��
//			private String publisher;		//������- ��ʱ������ʹ��
//			private int count;				//��ǰ�鼮�Ŀ����
//			private double price;			//ͼ��ĵ���
			System.out.println("��ͼ��ֿⲻ���ڣ����������ͼ����Ϣ");
			newBook.setBookId(bookId);
			
			System.out.print("ͼ�����ƣ�");
			newBook.setBookName(input.next());
			
			System.out.print("ͼ�����ţ�");
			newBook.setSibn(input.next());
			
			
			System.out.print("ͼ��������");
			newBook.setCount(input.nextInt());
//			
			System.out.print("ͼ�鵥�ۣ�");
	        newBook.setPrice(input.nextDouble());
	        
			bookBiz.addBook(newBook);		//����ͼ��ҵ��������ͼ��
		}else {
			System.out.print("ͼ���Ѿ����ڣ�����������");
			newBook = showAddNewBookView();				//���µ��ñ����� - - �ݹ����
		}
		return newBook;
			
	}
	
	public void showBooks(Book ...BookArray) {
		 System.out.println("ͼ����\t\tͼ������\t\tͼ������\t\tͼ������\t\tͼ�鵥��");
		 if(BookArray == null) {
			 BookArray = Dates.BookStore;			//��ʾĬ�ϵ�ͼ��ֿ�
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
