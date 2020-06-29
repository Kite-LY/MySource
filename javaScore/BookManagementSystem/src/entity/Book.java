package entity;

import java.io.Serializable;

/**
 * 真实的图书对象(读者在借书的时候，实际上借的是Book对象，同时Book对象包含了BookeInfo对象)
 * @author 小风筝
 *
 */

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6745469070396395104L;
	private String isbn;
	private String bookId;					//图书馆内部编号
	private BookState state;
	private BookInfo bookInfo;
	
	@Override
	public boolean equals(Object obj) {
		if(null == obj) return false;
		if(!(obj instanceof Book)) return false;
		Book book = (Book)obj;
 		
		return bookId.equals(book.getBookId());
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public BookState getState() {
		return state;
	}
	public void setState(BookState state) {
		this.state = state;
	}

	public BookInfo getBookInfo() {
		return bookInfo;
	}

	public void setBookInfo(BookInfo bookInfo) {
		this.bookInfo = bookInfo;
	}

	
	
}

/**
 * 图书的状态： 可借,不可借,缺货,损坏,维修中
 * @author 小风筝
 *
 */
enum BookState{
	 可借,不可借,缺货,损坏,维修中;
}
