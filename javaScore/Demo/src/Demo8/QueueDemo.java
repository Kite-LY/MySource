package Demo8;

import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedListDemo();
		
	}

	
	
	public static void LinkedListDemo() {
		
		Queue<String> queue = new LinkedList<>();
		queue.offer("����");
		queue.offer("�ŷ�");
		queue.offer("����");
		queue.offer("����");
		queue.offer("��");
		
		//System.out.println("���ӵĲ�����" + queue.poll());				//ɾ���˵�һ��Ԫ��
		System.out.println("���Ӳ���peek������" + queue.peek());			//��ʾ�˶�һ��Ԫ��
		
		System.out.println("���еı�����");
		queue.forEach(str -> System.out.print(str + "-"));
	}
	
	public static void ArrayDequeDemo() {
		//ArrayDeque��һ����������ʵ�ֵ�˫���� 
	}
	
	
}























