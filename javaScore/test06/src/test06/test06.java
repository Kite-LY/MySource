package test06;

public class test06 {
	public static void main(String[] args) {
		test006 s1 = test006.getInstance();
		test006 s2= test006.getInstance();
		
		System.out.println(s1 == s2);
	}
	
}
