package biz.impl;

import java.util.Map;

import biz.BookInfoBiz;
import entity.BookInfo;
import util.FileUtil;

/**
 * BookInfoBiz�ĵ�һ��ʵ����
 * @author С����
 *
 */

public class BookInfoBizImplV1 implements BookInfoBiz{


	private static final long serialVersionUID = 3518698939150334313L;			//������������� д���ļ������紫��

	@Override
	public boolean add(BookInfo bookInfo) {
		//1.������е�BookInfoMap

		if(null == bookInfo) {
			return false;
		}
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return false;			//���������ͬ��isbn
		}
		//2.��map����Ӵ����BookInfo����
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		//3.��map��������д�뵽�ļ���
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
		
	
	}

	@Override
	public boolean del(BookInfo bookInfo) {
		if(null == bookInfo) {
			return false;
		}
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return false;			
		}
		bookInfoMap.remove(bookInfo.getIsbn());
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public BookInfo update(BookInfo bookInfo) {
		if(null == bookInfo) {
			return null;
		}
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return null	;
		//�ж��Ƿ���ڱ���
		if(!(bookInfoMap.containsKey(bookInfo.getIsbn()))) {	//�����ڵ������
			return null;			
		}
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap); 
		return bookInfo;
	}

	@Override
	public BookInfo findById(String id) {
		
		//���һ��������������û�����壬�Ϳ����׳���
		throw new UnsupportedOperationException("BookInfo�в�֧�ָ���ID�Ĳ�ѯ������");
		
	}

	@Override
	public Map<String, BookInfo> findAll() {
		return FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount) {
		 //���Ҫ������鼮��Ϣ
		BookInfo bookInfo = findIsbn(isbn);
		if(null == bookInfo) return false;		//û���ҵ��鼮
		//��������鼮����Ϣ
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null) return false;
		//�����������ڿ��
		if(outCount > bookInfo.getInStroeCount()) {
			return false;
		}
		//ʵ�ֳ������
		bookInfo.setInStroeCount(bookInfo.getInStroeCount() - outCount);
		//���ĵ��鼮��Ϣ�Ż�map��
		bookInfoMap.put(isbn, bookInfo);
		//�ļ���Ϣ����
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean inStroe(String isbn, int inCount) {
		
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(!bookInfoMap.containsKey(isbn)) {
			//����ֿ��в����������isbn���������
			return false;
		}
		//���
		BookInfo bookInfo = bookInfoMap.get(isbn);
		bookInfo.setInStroeCount(bookInfo.getInStroeCount() + inCount);
		bookInfoMap.put(isbn, bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap );
		return true;
	}

	@Override
	public BookInfo findIsbn(String isbn) {
		if(null == isbn || "".equals(isbn)) return null;
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null)  return null;
		if(!bookInfoMap.containsKey(isbn)) {		//������isbn
			return null;
		}
		return bookInfoMap.get(isbn);
	}

}




















