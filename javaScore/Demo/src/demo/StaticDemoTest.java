package demo;

public class StaticDemoTest {

	public static void main(String[] args) {
		
		StaticDemo d = StaticDemo.getInstance();
		System.out.println(d.normal_number);
		
		StaticDemo d1 = StaticDemo.getInstance();
		d1.normal_number = 1024;
		
		StaticDemo d2 = StaticDemo.getInstance();
		System.out.println(d2.normal_number);
		
		System.out.println(d2 == d);
		
		StaticDemo d3 = StaticDemo.getInstance();
		System.out.println(d3.static_number);
		
		System.out.println(d3 == d);
	}

}
