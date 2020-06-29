package Demo8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListDemo {

	/**
	 * linkedList 插入删除的效率比较高
	 * ArrayList遍历，随机访问元素的效率比较高了
	 * @param args
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ArrayList耗时：" + CostTime(new ArrayList<>()));
		System.out.println("LinkedList耗时：" + CostTime(new LinkedList<>()));   
	}

	
	
	public static long CostTime(List<Object> list) {
		Object obj = new Object();
		final int N = 15000;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			//list.add(0, obj);		//在指定位置添加
			list.add(obj);			//在最后位置添加
			
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
}
