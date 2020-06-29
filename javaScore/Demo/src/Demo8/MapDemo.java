package Demo8;
//package
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;
import java.util.TreeMap;

/**
 * 三种图的基本用法
 * @author 小风筝
 *
 */
public class MapDemo {
	
	public static void main(String[] args) {
		//BaseKill();	
		KeyWorldNun();
	}
	
	public static void KeyWorldNun() {
		final String fileName = "D:\\java\\javaScore\\Demo\\src\\Demo8\\MapDemo.java";
		/** 关键字集合 */
		final String KeyWords = "package, import,final, class, void, static, new, while, if, for, try, catch, public, return";
		
		
		//需求：统计java源文件中，每个关键字出现的次数
		//1.获得Java源文件的字符串，
		
		List<String> contentList = ReadSourceFile(fileName);
		//关键字数组传换成set集合
		Set<String> KeyWordsSet = new HashSet<>();
		KeyWordsSet.addAll(Arrays.asList(KeyWords.split(",")));				//根据“，”进行分割
		
//		for(String str : contentList) {
//			System.out.println(str);
//		}
		//2.遍历关键字集合，统计每一个关键字在源文件中出现的次数：将关键字，和次数存放在Map集合当中
		
		Map<String, Integer> keyWordsMap = new HashMap<>();
		for(String keyword : KeyWordsSet) {	//外循环为关键字集合
			keyword = keyword.trim();
			
			for(String line: contentList) {									//内循环为每个关键字都遍历一次源码的所有行
				int count = getLineKeyWordCount(line, keyword);  
				if(count == 0) continue;
				//关键字再次出现的情况下
				if(keyWordsMap.containsKey(keyword)) {
					int oldCount = keyWordsMap.get(keyword).intValue();
					keyWordsMap.put(keyword, new Integer(count + oldCount));
				}else {
					keyWordsMap.put(keyword, count);						//关键字第一次出现
				}
			}
		}
		
		//3，遍历Map集合（以关键字出现的次数进行排序）
		for(Entry<String, Integer> entry : keyWordsMap.entrySet()) {
			System.out.println(entry.getKey() + " 出现次数：" + entry.getValue());
		}
		System.out.println();
		//4.排序显示
		System.out.println("-------------------------------------------------");
		Map<String, Integer> treeMap = new TreeMap<>(new MyTreeComparator(keyWordsMap));
		treeMap.putAll(keyWordsMap);
		for(Entry<String, Integer> entry : treeMap.entrySet()){
			System.out.println(entry.getKey() + " 出现的次数：" + entry.getValue());
		}
	}
	
	private static int getLineKeyWordCount(String line, String keyword) {
		if(line == null || keyword == null) return 0;
		//可以在这里添加其他逻辑判断：跳过注释行
		if(line.startsWith("/*")  || line.startsWith("*/")|| line.startsWith("//") || line.startsWith("*")){
			return 0;
		}
		int count = 0;
		String strLine = new String(line);
		int index = -1;
		while( (index = strLine.indexOf(keyword)) != -1) {
			count++;
			strLine = strLine.substring(index + keyword.length() + 1);			
		}
		
		
		return count;
	}
	
	
	
	/**
	 * 读取传入路径的Java源文件，以字符串的方式返回源文件的所有类容
	 * @param fileName
	 * @return
	 */
	
	private static List<String> ReadSourceFile(String fileName) {
		List<String> contentList = new ArrayList<String>();
		try (
			FileReader fReader = new FileReader(fileName);
			BufferedReader bReader = new BufferedReader(fReader);
			){
			String line = null;
			while((line = bReader.readLine()) != null) {
				if(line.trim().length() == 1) {
					continue;
				}
				contentList.add(line.trim());				//list中添加Line的内容
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return contentList;
	}
	
	
	
	public static void BaseKill() {
		Map< String, Integer> hashMap = new HashMap<>();
		hashMap.put("刘备1", 12);
		hashMap.put("刘备2", 14);
		hashMap.put("刘备3", 22);
		hashMap.put("刘备4", 52);
		hashMap.put("刘备5", 32);
		
		System.out.println("hashMap:" + hashMap);
		
		Map< String, Integer> LinkedHashMap = new LinkedHashMap<>();
		LinkedHashMap.put("刘备1", 12);
		LinkedHashMap.put("刘备2", 14);
		LinkedHashMap.put("刘备3", 22);
		LinkedHashMap.put("刘备4", 52);
		LinkedHashMap.put("刘备5", 32);
		
		System.out.println("LinkedHashMap:" + LinkedHashMap);
		
		Map< String, Integer> treeMap = new TreeMap<>( );
		treeMap.put("刘备1", 12);
		treeMap.put("刘备2", 14);
		treeMap.put("刘备3", 22);
		treeMap.put("刘备4", 52);
		treeMap.put("刘备5", 32);
		
		System.out.println("treeMap:" + treeMap);
		
		//图的遍历
		System.out.println("第一种遍历方式：通过Map>keySet遍历Key，通过Key去除对应的Value值：");
		for(String key : treeMap.keySet()) {
			System.out.print(key  +"——"  + treeMap.get(key));
		}
		System.out.println();
		
		//使用Map.entrySet使用迭代器遍历
		System.out.println("通过Map.entrySet使用迭代器遍历Key和value");
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	
		
		//第三种遍历方式
		System.out.println("直接通过Map.entrySet集合：(容量大的时候推荐使用此方法)");
		for(Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
	
}

/**
 *自己定义的比较器
 *注意：在默认的情况下，Map只能对key进行排序
 * @author 小风筝
 *
 */


class MyTreeComparator implements Comparator<String>{
	private Map<String, Integer> map;
	public MyTreeComparator(Map<String, Integer> map) {
		this.map = map;
	}

	@Override
	public int compare(String key1, String key2) {
//		if(key1.compareTo(key2) > 0) return -1;
//		if(key1.compareTo(key2) < 0) return 1;
		//根据value值进行比较
		if(map.get(key1).intValue() < map.get(key2).intValue()){
			return 1;
		}
		if(map.get(key1).intValue() > map.get(key2).intValue()){
			return -1;
		}
		return 0;
	}
	
}
















