package Demo8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListDemo {

	/**
	 * linkedList ����ɾ����Ч�ʱȽϸ�
	 * ArrayList�������������Ԫ�ص�Ч�ʱȽϸ���
	 * @param args
	 */ 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("ArrayList��ʱ��" + CostTime(new ArrayList<>()));
		System.out.println("LinkedList��ʱ��" + CostTime(new LinkedList<>()));   
	}

	
	
	public static long CostTime(List<Object> list) {
		Object obj = new Object();
		final int N = 15000;
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < N; i++) {
			//list.add(0, obj);		//��ָ��λ�����
			list.add(obj);			//�����λ�����
			
		}
		long endTime = System.currentTimeMillis();
		return endTime - startTime;
	}
	
}
