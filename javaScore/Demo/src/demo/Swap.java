package demo;



public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		demo1 d = new demo1();
		swap1(d);
		System.out.println( d.a + "\t" + d.b);
		
	
	}

	public static void swap1(demo1 d) {
		// TODO Auto-generated method stub
		//d = new demo1();    //加了这句元素的位置没有交换
		int temp = d.a;
		d.a = d.b;
		d.b = temp;
	}
	
//	public  void swap1(int num1, int num2) {
//		int temp = num1;
//		num1 =num2;
//		num2 = temp;
//	}
}



	
	
class demo1{
	int a =1;
	int b =2;
	demo1(){}
	}	
	

