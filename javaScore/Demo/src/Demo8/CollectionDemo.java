package Demo8;

import java.util.List;
import java.util.ListIterator;

import org.omg.CosNaming.IstringHelper;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {				//collection集合

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list1 = new ArrayList<>();
		
		list1.add("刘备");
		list1.add("关羽");
		list1.add("张飞");
		list1.add("赵云");
		System.out.println(list1);
		list1.add(1, "曹操");
		System.out.println(list1);
		list1.set(1, "曹植");
		System.out.println(list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("孙权");
		list2.add("周瑜");
		list1.addAll(list2);
		System.out.println(list1);
		
		
		//1.list的遍历
		System.out.println("集合的for循环遍历：");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + "-");
		}
		System.out.println();
		
		//2.使用for each循环
		for(String str : list1) {
			System.out.print(str + "-");
		}
		System.out.println();
		
		//3.使用迭代器遍历
		Iterator<String> it = list1.iterator();
		while(it.hasNext()) {				//it.hasNext的返回值为true 或者 false
			System.out.print(it.next() + "-"); 
		}
		//System.out.println(it.hasNext());
		System.out.println();
		
		//4.使用ListIterator迭代器遍历
		ListIterator<String> ListIt = list1.listIterator();
		while(ListIt.hasNext()) {
			System.out.print(ListIt.next() + "-");
		}
		System.out.println();
		
		//使用ListIterator与传统迭代器的区别
		//1.ListIterator不但可以向后访问，还可以向前访问
		//2.ListIterator可以修改集合中的元素
		System.out.println("使用ListIterator从后向前遍历：");
		ListIterator<String> listIt2= list1.listIterator(list1.size());
		while(listIt2.hasPrevious()) {				//hasPrevious 表示从最后一个向前面遍历
			System.out.print(listIt2.previous() + "-");
		}
		System.out.println();
		
		//list删除元素
		System.out.println("删除元素：");
		list1.remove(1);
		list1.remove("周瑜");
		System.out.println(list1);
		
		System.out.println("subList(3,5):" + list1.subList(3, 5));

		
		
		
	}
	//使用迭代器打印时不需要知道数据类型
	/**
	 * 在遍历集合时，不需要依赖类的实现 
	 * @param It
	 */
		public void show(Iterator<? extends Person> It) {
			
			while(It.hasNext()) {
				System.out.println(It.next());
			}
			
		}
	
		
		
}

class Person{
	
}

































