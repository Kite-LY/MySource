package biz;

import entity.BookInfo;

/**
 * 图书业务类的接口
 * 增删改查
 * @author 小风筝
 *
 */

public interface BookInfoBiz extends Biz<BookInfo>{

	/**
	 * 出库
	 * @param isbn	
	 * @param outCount	出库的数量
	 * @return	是否出库成功
	 */
	public boolean outStore(String isbn, int outCount);
		
	/**
	 * 入库
	 * @param isbn
	 * @param inCount
	 * @return
	 */
	public boolean inStroe(String isbn, int inCount);
	
	public BookInfo findIsbn(String isbn);
}
