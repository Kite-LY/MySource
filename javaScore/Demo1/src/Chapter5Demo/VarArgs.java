package Chapter5Demo;

public class VarArgs {

	
	static void printArrgy(Object[] args) {
		for(Object obj : args) {
			System.out.print(obj + "\t" );
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printArrgy(new Object[]{
			new Integer(45),
			new Float(11.2),
			new Double(21.33)
		});
		printArrgy(new Object[] {
				"aa",
				"ÍõÀÚ",
				"aaa"
		});
		
		printArrgy(new Object[] {
			new A(),new A(), new A()
		});
		
		
	}

}

class A{}

