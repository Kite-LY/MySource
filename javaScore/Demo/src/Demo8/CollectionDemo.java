package Demo8;

import java.util.List;
import java.util.ListIterator;

import org.omg.CosNaming.IstringHelper;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {				//collection����

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> list1 = new ArrayList<>();
		
		list1.add("����");
		list1.add("����");
		list1.add("�ŷ�");
		list1.add("����");
		System.out.println(list1);
		list1.add(1, "�ܲ�");
		System.out.println(list1);
		list1.set(1, "��ֲ");
		System.out.println(list1);
		
		List<String> list2 = new ArrayList<>();
		list2.add("��Ȩ");
		list2.add("���");
		list1.addAll(list2);
		System.out.println(list1);
		
		
		//1.list�ı���
		System.out.println("���ϵ�forѭ��������");
		for (int i = 0; i < list1.size(); i++) {
			System.out.print(list1.get(i) + "-");
		}
		System.out.println();
		
		//2.ʹ��for eachѭ��
		for(String str : list1) {
			System.out.print(str + "-");
		}
		System.out.println();
		
		//3.ʹ�õ���������
		Iterator<String> it = list1.iterator();
		while(it.hasNext()) {				//it.hasNext�ķ���ֵΪtrue ���� false
			System.out.print(it.next() + "-"); 
		}
		//System.out.println(it.hasNext());
		System.out.println();
		
		//4.ʹ��ListIterator����������
		ListIterator<String> ListIt = list1.listIterator();
		while(ListIt.hasNext()) {
			System.out.print(ListIt.next() + "-");
		}
		System.out.println();
		
		//ʹ��ListIterator�봫ͳ������������
		//1.ListIterator�������������ʣ���������ǰ����
		//2.ListIterator�����޸ļ����е�Ԫ��
		System.out.println("ʹ��ListIterator�Ӻ���ǰ������");
		ListIterator<String> listIt2= list1.listIterator(list1.size());
		while(listIt2.hasPrevious()) {				//hasPrevious ��ʾ�����һ����ǰ�����
			System.out.print(listIt2.previous() + "-");
		}
		System.out.println();
		
		//listɾ��Ԫ��
		System.out.println("ɾ��Ԫ�أ�");
		list1.remove(1);
		list1.remove("���");
		System.out.println(list1);
		
		System.out.println("subList(3,5):" + list1.subList(3, 5));

		
		
		
	}
	//ʹ�õ�������ӡʱ����Ҫ֪����������
	/**
	 * �ڱ�������ʱ������Ҫ�������ʵ�� 
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

































