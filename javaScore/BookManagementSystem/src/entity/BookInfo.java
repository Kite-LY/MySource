package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * ��ͼ���ISBNΪΨһ�ı�ʶ��ͼ������Ϣ
 * ��һ��ISBN�����Ӧ�ܶ౾��ʵ���ڵ�ͼ�����
 * @author С����
 *
 */

//��ΪҪʹ�ö�����������Ҫ�������⻯


public class BookInfo implements Serializable {
	

	private static final long serialVersionUID = -5243941971146803241L;
	private String isbn;
	private String name;
	private String type;		//�������������ļ��л��
	private String author;
	private String publicsher;
	private int inStroeCount;
	private Date publishDate;	//��������
	private double price;
	//ͨ��������BookInfo��Book֮���ϵ��һ�Զ��ϵ
	private List<Book> bookList;
	
	
	//��������д���췽��toString,equals�Ȳ��� - ��Ҫʱ�������
	
	public void addBook(Book book) {
		if(null == bookList) {
			bookList = new ArrayList<>();
		}
		if(book == null) return;
		if(!isbn.equals(book.getIsbn())) return ;
		//�����ͬһ�������Ҫ�ظ����
		if(bookList.contains(book)) return;
		//��λ����ӵ�ͼ������ͼ����Ϣ
		book.setBookInfo(this);
		bookList.add(book);
	}
	
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublicsher() {
		return publicsher;
	}
	public void setPublicsher(String publicsher) {
		this.publicsher = publicsher;
	}
	public int getInStroeCount() {
		return inStroeCount;
	}
	public void setInStroeCount(int inStroeCount) {
		this.inStroeCount = inStroeCount;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
