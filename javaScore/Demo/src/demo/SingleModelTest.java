package demo;

public class SingleModelTest {

	public static void main(String[] args) {
		
		SingleModel s1 = SingleModel.getInstance();
		System.out.println(s1.count);
		s1.count++;
		SingleModel s2 = SingleModel.getInstance();
		System.out.println(s2.count);
		
		System.out.println(s1 == s2);
	}

}
