package BookDemo1;

import java.util.Date;

/**
 * 图书的业务类
 * 包含对图书及图书数组的基本操作
 * @author 小风筝
 *
 */
public class BookBiz {
	
	private static final boolean Book = false;

	//图书的基本业务：增加图书，出库，入库，查询。排序
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
	 * 添加图书
	 * @param book
	 * @return
	 */
	public boolean addBook(Book book) {
		int bookCount = getBookCount();
		if(Dates.BookStore.length == bookCount) {
			return false;
		}
		//如果仓库不满的话，就将传入的图书对象放在数组的最后一个位置
		Dates.BookStore[bookCount] = book;
		return true; 
	}
	
	/**
	 * 删除传入的图书对象
	 * @param book
	 * @return
	 */
	public boolean delBook(Book book) {
		int bookCount = getBookCount();
		int delIndex = -1;						//要删除元素的下标
		for(int i = 0; i < bookCount; i++) {
			if(book.equals(Dates.BookStore[i])) {
				delIndex = i;					//获得要删除元素的下标
				break;
			}
		}
		if(delIndex == -1) {
			return false;						//没有找到要删除的元素时，直接结束方法
		}
		
		//执行数组的删除套路
		for(int i = delIndex; i < bookCount - 1; i++) {
			Dates.BookStore[i] = Dates.BookStore[i+1];
		}
		//将最后一个元素置为null
		Dates.BookStore[bookCount -1] = null;
		return true;		
	}
	
	/**
	 * 通过图书id查找对应的图书对象
	 * @param bookId
	 * @return  如果没有找到则返回null
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
	 * 入库：为仓库中现有的图书增加库存
	 * @param bookId	图书id
	 * @param count		数量
	 * @return			如果id不存在，入库失败
	 */
	public boolean inStroe(String bookId, int count) {
		Book book = findById(bookId);
		if(null == book) {
			return false;			//仓库中不存在此书
		}
		//增加库存
		book.setCount(book.getCount() + count);
		return true;
	}
	
	/**
	 * 出库操作
	 * @param bookId
	 * @param count
	 * @return
	 */
	public boolean OutStroe(String bookId,int count) {
		Book book = findById(bookId);
		if(null == book) {
			return false;
		}
		if(book.getCount() < count) {			//库存不够
			return false;
		}
		//减少库存
		book.setCount(book.getCount() - count);
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
