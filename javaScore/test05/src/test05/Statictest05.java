package test05;

//��̬����
//static�����������ʱִ�У�����ִֻ��һ��
public class Statictest05 {
	
	static {
		System.out.println("1");
	}
	static {
		System.out.println("2");
	}
	static {
		System.out.println("3");
	}
	static {
		System.out.println("4");
	}
	static {
		System.out.println("5");
	}
	
	//ʵ������
	{
		System.out.println("A");
	}
	
	{
		System.out.println("B");
	}
	
	{
		System.out.println("C");
	}
	
	public static void main(String[] args) {
		System.out.println("����ʼִ�У�");
		
		new Statictest05();
		
		new Statictest05();
	}
}
