package biz;
/**
 * 所用业务类的父接口
 * 定义了所用业务类的通用接口
 * @author 小风筝
 *
 */

import java.io.Serializable;
import java.util.Map;

public interface Biz<T> extends Serializable{			//泛型编程
	
	/** 通用的添加方法 */
	public boolean add(T t);
	
	public boolean del(T t);
	
	public T update(T t);
	
	public T findById(String id);
	
	public Map<String,  T> findAll();
}
