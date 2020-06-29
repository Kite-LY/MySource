package test05;

//静态语句块
//static语句块在类加载时执行，并且只执行一次
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
	
	//实例语句块
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
		System.out.println("程序开始执行！");
		
		new Statictest05();
		
		new Statictest05();
	}
}
