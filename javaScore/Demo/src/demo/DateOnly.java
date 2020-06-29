package demo;

import java.time.LocalDateTime;
import java.util.Date;

public class DateOnly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Only q = new Only();
		
		System.out.println(q.test());
		
		Only q1= new Only();
		
		System.out.println(q1.test());
		Only q2= new Only();
		
		System.out.println(q2.test());
			
//		System.getProperties().list(System.out);
//		System.out.println(System.getProperty("user name"));
//		System.out.println(
//				System.getProperty("java.library.path")
//				);
		//System.out.println(new LocalDateTime(new Date(), null));
		
		Only q3 = new Only();
		q3.j = 11;
		q3.i = q3.j;
		System.out.println(q3.i);
		
	}

}


class Only{
	int i = 1;
	int j = -1;
	
	public int test() {
		return i++;
	}
}