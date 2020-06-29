package biz;

import entity.BookInfo;

/**
 * ͼ��ҵ����Ľӿ�
 * ��ɾ�Ĳ�
 * @author С����
 *
 */

public interface BookInfoBiz extends Biz<BookInfo>{

	/**
	 * ����
	 * @param isbn	
	 * @param outCount	���������
	 * @return	�Ƿ����ɹ�
	 */
	public boolean outStore(String isbn, int outCount);
		
	/**
	 * ���
	 * @param isbn
	 * @param inCount
	 * @return
	 */
	public boolean inStroe(String isbn, int inCount);
	
	public BookInfo findIsbn(String isbn);
}
