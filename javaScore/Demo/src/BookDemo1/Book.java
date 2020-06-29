package BookDemo1;
/**
 * ͼ��ʵ����
 * @author С����
 *MVC
 *m -Model - ģ�Ͳ�
 *V - View - ��ͼ�㣨���棩
 *C - Controller - ���Ʋ㣨ҵ��
 */
public class Book {
	
	private String bookId;			//ͼ����ڲ����
	private String bookName;		//ͼ������
	private String sibn;			//�����
	private String type;			//ͼ�������
	private String author;			//���� - ��ʱ������ʹ��
	private String publisher;		//������- ��ʱ������ʹ��
	private int count;				//��ǰ�鼮�Ŀ����
	private double price;			//ͼ��ĵ���

	
	public Book(){
		
	}
	/**
	 * ��д��ͼ������equals�������������ıȽ�
	 */
	@Override
	public boolean equals(Object obj) {
		
		//�������Ĳ���Ϊ�գ����ߴ�������Ͳ���Book��ʵ�����򷵻�false
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
