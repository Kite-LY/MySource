package thread.t1;

public class Demo1 extends Thread{
	
	public Demo1(String name) {
		super(name);
	}
	
	public void run() {
		System.out.println(getName() +"线程执行了...");
	}
	public static void main(String[] args) {
		
		Demo1 demo1 = new Demo1("1");
		Demo1 demo2 = new Demo1("2");
		
		demo1.setDaemon(true);
		
		demo1.start();
		demo2.start();
	}
}
