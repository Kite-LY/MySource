package Demo8;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

public class VectorDemo {

	public static void main(String[] args) {
		//Vector��java1.0�Ϳ�ʼ������
		//ʹ�ó�����JavaMe��΢С�汾�ж�����ʹ��
		//Swing������ģ�Ͷ�ʹ����Vector
		Vector<String> vec = new Vector<>();
		vec.add("����");				//����boolean�ķ���ֵ
		vec.addElement("����2");    //�޷���ֵ
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
		System.out.println("������" + vec.capacity());    //�����������ɷ���ʽ������  
		
		vec.trimToSize();   							 //trimToSize()��ȥ����������
		System.out.println("trim��������� " + vec.capacity());
		
		vec.ensureCapacity(300);
		System.out.println("ensureCapacity���������" + vec.capacity());
		
		//Vector�ı���
		for (int i = 0; i < vec.size(); i++) {
			System.out.print(vec.get(i) + "-");
		}
		System.out.println();
		
		//Iterator�������ı���
		System.out.println("ʹ�õ�����������");
		Iterator<String> it = vec.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + "-");
		}
		System.out.println();
		
		//ʹ��ö�ٱ��� -- ���ڰ汾����ʹ��
		System.out.println("ʹ��ö�ٽ��б�����");
		Enumeration<String> vecEnum = vec.elements();
		while(vecEnum.hasMoreElements()) {
			System.out.print(vecEnum.nextElement() + "-");
		}
		System.out.println();
		
		//ʹ��Lambda���ʽ����
		System.out.println("ʹ��Lambda���ʽ����:");
		vec.forEach(str -> System.out.print(str + "-"));
		System.out.println();
		
		//Ԫ�صĲ�ѯ
		System.out.println(vec.firstElement());
		System.out.println(vec.lastElement());
		System.out.println(vec.elementAt(1) + '\t' + vec.get(1));
		
	}
	
	
}



































