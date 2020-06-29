package Demo8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsDemo {

	public static void main(String[] args) {

		List<Integer> list1 = new ArrayList<Integer>();
		
		list1.add(123);
		list1.add(127);
		list1.add(123);
		list1.add(125);
		list1.add(126);
		System.out.println("forEach遍历后的结果：");
		list1.forEach(Integer -> System.out.print(Integer + "-"));
		
		Collections.shuffle(list1, new Random(20));
		System.out.println("\n无序后的结果：");
		list1.forEach(Integer -> System.out.print(Integer + "-"));
		
		Collections.shuffle(list1, new Random(20));
		System.out.println("\n无序后的结果：");
		list1.forEach(Integer -> System.out.print(Integer + "-"));
		
		
	}

}
