package entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 以图书的ISBN为唯一的标识的图书类信息
 * 摸一个ISBN，会对应很多本真实存在的图书对象
 * @author 小风筝
 *
 */

//以为要使用对象流，所以要进行虚拟化


public class BookInfo implements Serializable {
	

	private static final long serialVersionUID = -5243941971146803241L;
	private String isbn;
	private String name;
	private String type;		//可以以在配置文件中获得
	private String author;
	private String publicsher;
	private int inStroeCount;
	private Date publishDate;	//出版日期
	private double price;
	//通过分析：BookInfo和Book之间关系是一对多关系
	private List<Book> bookList;
	
	
	//还可以重写构造方法toString,equals等操作 - 需要时进行完成
	
	public void addBook(Book book) {
		if(null == bookList) {
			bookList = new ArrayList<>();
		}
		if(book == null) return;
		if(!isbn.equals(book.getIsbn())) return ;
		//如果是同一本书就需要重复田间
		if(bookList.contains(book)) return;
		//在位已添加的图书设置图书信息
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
