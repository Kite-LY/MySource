package Demo8;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
public class SetDemo {

	public static void main(String[] args) {
		//HashSetDemo();
		//LinkHashSetDemo();
		TreeSet();
	}
	
	public static void TreeSet() {
		Set<String> citySet = new TreeSet<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.compareTo(o2) > 0) return -1;
				if(o1.compareTo(o2) < 0) return 1;
				return 0;
			}
			
		} );
		citySet.add("bLonden");
		citySet.add("aLonden");
		citySet.add("wLonden1");
		citySet.add("fLonden3");
		citySet.add("nLonden4");
		citySet.forEach(str -> System.out.print(str + "--"));
	}
	
	
	
	public static void HashSetDemo() {
		
		//set规则集：1。不允许有重复的元素，2.无序
		Set<String> citySet = new HashSet<>();
		citySet.add("Londen");
		citySet.add("Londen");
		citySet.add("Londen1");
		citySet.add("Londen3");
		citySet.add("Londen4");
		citySet.forEach(str -> System.out.print(str + "--"));
		
	} 
	
	public static void LinkHashSetDemo() {
		//遍历顺序与插入顺序相同
		Set<String> citySet = new LinkedHashSet<>();
		citySet.add("Londen");
		citySet.add("Londen");
		citySet.add("Londen1");
		citySet.add("Londen3");
		citySet.add("Londen4");
		
		citySet.remove("Londen");
		citySet.forEach(str -> System.out.print(str + "--"));
		
		
	}

}
