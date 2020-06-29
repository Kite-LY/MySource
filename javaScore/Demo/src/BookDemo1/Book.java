package BookDemo1;
/**
 * 图书实体类
 * @author 小风筝
 *MVC
 *m -Model - 模型层
 *V - View - 视图层（界面）
 *C - Controller - 控制层（业务）
 */
public class Book {
	
	private String bookId;			//图书的内部编号
	private String bookName;		//图书名称
	private String sibn;			//出版号
	private String type;			//图书的类型
	private String author;			//作者 - 暂时不进行使用
	private String publisher;		//出版社- 暂时不进行使用
	private int count;				//当前书籍的库存量
	private double price;			//图书的单价

	
	public Book(){
		
	}
	/**
	 * 重写了图书对象的equals方法，方便对象的比较
	 */
	@Override
	public boolean equals(Object obj) {
		
		//如果传入的参数为空，或者传入的类型不是Book的实例，则返回false
		if(null == obj || !(obj instanceof Book)){
			return false;
		}
		Book book = (Book)obj;
		
		return bookId.equals(book.getBookId());
	}
	
	
	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getSibn() {
		return sibn;
	}

	public void setSibn(String sibn) {
		this.sibn = sibn;
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

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
