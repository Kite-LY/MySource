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
		queue.offer("刘备");
		queue.offer("张飞");
		queue.offer("关羽");
		queue.offer("赵云");
		queue.offer("马超");
		
		//System.out.println("出队的操作：" + queue.poll());				//删除了第一个元素
		System.out.println("出队操作peek（）：" + queue.peek());			//显示了都一个元素
		
		System.out.println("队列的遍历：");
		queue.forEach(str -> System.out.print(str + "-"));
	}
	
	public static void ArrayDequeDemo() {
		//ArrayDeque是一个基于数组实现的双队列 
	}
	
	
}























