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
 * ����ͼ�Ļ����÷�
 * @author С����
 *
 */
public class MapDemo {
	
	public static void main(String[] args) {
		//BaseKill();	
		KeyWorldNun();
	}
	
	public static void KeyWorldNun() {
		final String fileName = "D:\\java\\javaScore\\Demo\\src\\Demo8\\MapDemo.java";
		/** �ؼ��ּ��� */
		final String KeyWords = "package, import,final, class, void, static, new, while, if, for, try, catch, public, return";
		
		
		//����ͳ��javaԴ�ļ��У�ÿ���ؼ��ֳ��ֵĴ���
		//1.���JavaԴ�ļ����ַ�����
		
		List<String> contentList = ReadSourceFile(fileName);
		//�ؼ������鴫����set����
		Set<String> KeyWordsSet = new HashSet<>();
		KeyWordsSet.addAll(Arrays.asList(KeyWords.split(",")));				//���ݡ��������зָ�
		
//		for(String str : contentList) {
//			System.out.println(str);
//		}
		//2.�����ؼ��ּ��ϣ�ͳ��ÿһ���ؼ�����Դ�ļ��г��ֵĴ��������ؼ��֣��ʹ��������Map���ϵ���
		
		Map<String, Integer> keyWordsMap = new HashMap<>();
		for(String keyword : KeyWordsSet) {	//��ѭ��Ϊ�ؼ��ּ���
			keyword = keyword.trim();
			
			for(String line: contentList) {									//��ѭ��Ϊÿ���ؼ��ֶ�����һ��Դ���������
				int count = getLineKeyWordCount(line, keyword);  
				if(count == 0) continue;
				//�ؼ����ٴγ��ֵ������
				if(keyWordsMap.containsKey(keyword)) {
					int oldCount = keyWordsMap.get(keyword).intValue();
					keyWordsMap.put(keyword, new Integer(count + oldCount));
				}else {
					keyWordsMap.put(keyword, count);						//�ؼ��ֵ�һ�γ���
				}
			}
		}
		
		//3������Map���ϣ��Թؼ��ֳ��ֵĴ�����������
		for(Entry<String, Integer> entry : keyWordsMap.entrySet()) {
			System.out.println(entry.getKey() + " ���ִ�����" + entry.getValue());
		}
		System.out.println();
		//4.������ʾ
		System.out.println("-------------------------------------------------");
		Map<String, Integer> treeMap = new TreeMap<>(new MyTreeComparator(keyWordsMap));
		treeMap.putAll(keyWordsMap);
		for(Entry<String, Integer> entry : treeMap.entrySet()){
			System.out.println(entry.getKey() + " ���ֵĴ�����" + entry.getValue());
		}
	}
	
	private static int getLineKeyWordCount(String line, String keyword) {
		if(line == null || keyword == null) return 0;
		//������������������߼��жϣ�����ע����
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
	 * ��ȡ����·����JavaԴ�ļ������ַ����ķ�ʽ����Դ�ļ�����������
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
				contentList.add(line.trim());				//list�����Line������
			}
		
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		return contentList;
	}
	
	
	
	public static void BaseKill() {
		Map< String, Integer> hashMap = new HashMap<>();
		hashMap.put("����1", 12);
		hashMap.put("����2", 14);
		hashMap.put("����3", 22);
		hashMap.put("����4", 52);
		hashMap.put("����5", 32);
		
		System.out.println("hashMap:" + hashMap);
		
		Map< String, Integer> LinkedHashMap = new LinkedHashMap<>();
		LinkedHashMap.put("����1", 12);
		LinkedHashMap.put("����2", 14);
		LinkedHashMap.put("����3", 22);
		LinkedHashMap.put("����4", 52);
		LinkedHashMap.put("����5", 32);
		
		System.out.println("LinkedHashMap:" + LinkedHashMap);
		
		Map< String, Integer> treeMap = new TreeMap<>( );
		treeMap.put("����1", 12);
		treeMap.put("����2", 14);
		treeMap.put("����3", 22);
		treeMap.put("����4", 52);
		treeMap.put("����5", 32);
		
		System.out.println("treeMap:" + treeMap);
		
		//ͼ�ı���
		System.out.println("��һ�ֱ�����ʽ��ͨ��Map>keySet����Key��ͨ��Keyȥ����Ӧ��Valueֵ��");
		for(String key : treeMap.keySet()) {
			System.out.print(key  +"����"  + treeMap.get(key));
		}
		System.out.println();
		
		//ʹ��Map.entrySetʹ�õ���������
		System.out.println("ͨ��Map.entrySetʹ�õ���������Key��value");
		Set<Map.Entry<String, Integer>> entrySet = treeMap.entrySet();
		Iterator<Map.Entry<String, Integer>> it = entrySet.iterator();
		while(it.hasNext()) {
			Map.Entry<String, Integer> entry = it.next();
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	
		
		//�����ֱ�����ʽ
		System.out.println("ֱ��ͨ��Map.entrySet���ϣ�(�������ʱ���Ƽ�ʹ�ô˷���)");
		for(Entry<String, Integer> entry : treeMap.entrySet()) {
			System.out.println(entry.getKey() + "-" + entry.getValue());
		}
	}
	
}

/**
 *�Լ�����ıȽ���
 *ע�⣺��Ĭ�ϵ�����£�Mapֻ�ܶ�key��������
 * @author С����
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
		//����valueֵ���бȽ�
		if(map.get(key1).intValue() < map.get(key2).intValue()){
			return 1;
		}
		if(map.get(key1).intValue() > map.get(key2).intValue()){
			return -1;
		}
		return 0;
	}
	
}
















