package Demo8;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		//Vector在java1.0就开始存在了
		//使用场景：JavaMe等微小版本中都可以使用
		//Swing的数据模型都使用了Vector
		Vector<String> vec = new Vector<>();
		vec.add("刘备");				//会有boolean的返回值
		vec.addElement("刘备2");    //无返回值
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		vec.add("aa");
		
		
		
		System.out.println("size: " + vec.size());
		System.out.println("容量：" + vec.capacity());    //容量的增长成翻倍式的增长  
		
		vec.trimToSize();   							 //trimToSize()除去后面多的容量
		System.out.println("trim后的容量： " + vec.capacity());
		
		vec.ensureCapacity(300);
		System.out.println("ensureCapacity后的容量：" + vec.capacity());
		
		//Vector的遍历
		for (int i = 0; i < vec.size(); i++) {
			System.out.print(vec.get(i) + "-");
		}
		System.out.println();
		
		//Iterator迭代器的遍历
		System.out.println("使用迭代器遍历：");
		Iterator<String> it = vec.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "-");
		}
		System.out.println();
		
		//使用枚举遍历 -- 早期版本进行使用
		System.out.println("使用枚举进行遍历：");
		Enumeration<String> vecEnum = vec.elements();
		while(vecEnum.hasMoreElements()) {
			System.out.print(vecEnum.nextElement() + "-");
		}
		System.out.println();
		
		//使用Lambda表达式遍历
		System.out.println("使用Lambda表达式遍历:");
		vec.forEach(str -> System.out.print(str + "-"));
		System.out.println();
		
		//元素的查询
		System.out.println(vec.firstElement());
		System.out.println(vec.lastElement());
		System.out.println(vec.elementAt(1) + '\t' + vec.get(1));
		
	}
	
	
}



































