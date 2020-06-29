package biz.impl;

import java.util.Map;

import biz.BookInfoBiz;
import entity.BookInfo;
import util.FileUtil;

/**
 * BookInfoBiz的第一版实现类
 * @author 小风筝
 *
 */

public class BookInfoBizImplV1 implements BookInfoBiz{


	private static final long serialVersionUID = 3518698939150334313L;			//加了这个可用于 写入文件，网络传输

	@Override
	public boolean add(BookInfo bookInfo) {
		//1.获得所有的BookInfoMap

		if(null == bookInfo) {
			return false;
		}
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(bookInfoMap.containsKey(bookInfo.getIsbn())) {
			return false;			//不能添加相同的isbn
		}
		//2.向map中添加传入的BookInfo对象
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		//3.将map对象重新写入到文件中
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
		//判断是否存在本书
		if(!(bookInfoMap.containsKey(bookInfo.getIsbn()))) {	//不存在的情况下
			return null;			
		}
		bookInfoMap.put(bookInfo.getIsbn(), bookInfo);
		FileUtil.SaveBookInfoMap(bookInfoMap); 
		return bookInfo;
	}

	@Override
	public BookInfo findById(String id) {
		
		//如果一个方法在子类中没有意义，就可以抛出此
		throw new UnsupportedOperationException("BookInfo中不支持根据ID的查询操作！");
		
	}

	@Override
	public Map<String, BookInfo> findAll() {
		return FileUtil.ReadBookInfoMap();
	}

	@Override
	public boolean outStore(String isbn, int outCount) {
		 //获得要出库的书籍信息
		BookInfo bookInfo = findIsbn(isbn);
		if(null == bookInfo) return false;		//没有找到书籍
		//获得所有书籍的信息
		Map<String, BookInfo> bookInfoMap = findAll();
		if(bookInfoMap == null) return false;
		//出库数量大于库存
		if(outCount > bookInfo.getInStroeCount()) {
			return false;
		}
		//实现出库操作
		bookInfo.setInStroeCount(bookInfo.getInStroeCount() - outCount);
		//更改的书籍信息放回map中
		bookInfoMap.put(isbn, bookInfo);
		//文件信息更新
		FileUtil.SaveBookInfoMap(bookInfoMap);
		return true;
	}

	@Override
	public boolean inStroe(String isbn, int inCount) {
		
		Map<String, BookInfo> bookInfoMap = findAll();
		if(null == bookInfoMap) return false;
		if(!bookInfoMap.containsKey(isbn)) {
			//如果仓库中不包含该书的isbn则不能是入库
			return false;
		}
		//入库
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
		if(!bookInfoMap.containsKey(isbn)) {		//不包含isbn
			return null;
		}
		return bookInfoMap.get(isbn);
	}

}




















