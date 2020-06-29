package BookDemo1;

import java.util.Date;

/**
 * ͼ���ҵ����
 * ������ͼ�鼰ͼ������Ļ�������
 * @author С����
 *
 */
public class BookBiz {
	
	private static final boolean Book = false;

	//ͼ��Ļ���ҵ������ͼ�飬���⣬��⣬��ѯ������
	public int getBookCount() {
		int count = 0;
		for(Book book : Dates.BookStore) {
			if(book == null) {
				break;
			}
			count++;
		}
		return count;
	}
	
	public int getBookCount(Book ...books) {
		int count = 0;
		for(Book book : books) {
			if(book == null) {
				break;
			}
			count++;
		}
		return count;
	}
	
	
	/**
	 * ���ͼ��
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		int bookCount = getBookCount();
		if(Dates.BookStore.length == bookCount) {
			return false;
		}
		//����ֿⲻ���Ļ����ͽ������ͼ����������������һ��λ��
		Dates.BookStore[bookCount] = book;
		return true; 
	}
	
	/**
	 * ɾ�������ͼ�����
	 * @param book
	 * @return
	 */
	public boolean delBook(Book book) {
		int bookCount = getBookCount();
		int delIndex = -1;						//Ҫɾ��Ԫ�ص��±�
		for(int i = 0; i < bookCount; i++) {
			if(book.equals(Dates.BookStore[i])) {
				delIndex = i;					//���Ҫɾ��Ԫ�ص��±�
				break;
			}
		}
		if(delIndex == -1) {
			return false;						//û���ҵ�Ҫɾ����Ԫ��ʱ��ֱ�ӽ�������
		}
		
		//ִ�������ɾ����·
		for(int i = delIndex; i < bookCount - 1; i++) {
			Dates.BookStore[i] = Dates.BookStore[i+1];
		}
		//�����һ��Ԫ����Ϊnull
		Dates.BookStore[bookCount -1] = null;
		return true;		
	}
	
	/**
	 * ͨ��ͼ��id���Ҷ�Ӧ��ͼ�����
	 * @param bookId
	 * @return  ���û���ҵ��򷵻�null
	 */
	public Book findById(String bookId) {
		int bookCount = getBookCount();
		for (int i = 0; i <bookCount; i++) {
			if(bookId.equals(Dates.BookStore[i].getBookId())) {
				return Dates.BookStore[i];
			}
		}
		return null;
	}
	
	/**
	 * ��⣺Ϊ�ֿ������е�ͼ�����ӿ��
	 * @param bookId	ͼ��id
	 * @param count		����
	 * @return			���id�����ڣ����ʧ��
	 */
	public boolean inStroe(String bookId, int count) {
		Book book = findById(bookId);
		if(null == book) {
			return false;			//�ֿ��в����ڴ���
		}
		//���ӿ��
		book.setCount(book.getCount() + count);
		return true;
	}
	
	/**
	 * �������
	 * @param bookId
	 * @param count
	 * @return
	 */
	public boolean OutStroe(String bookId,int count) {
		Book book = findById(bookId);
		if(null == book) {
			return false;
		}
		if(book.getCount() < count) {			//��治��
			return false;
		}
		//���ٿ��
		book.setCount(book.getCount() - count);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
