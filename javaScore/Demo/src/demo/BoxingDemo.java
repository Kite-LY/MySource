package demo;

/**
 * 包装类	
 * */
public class BoxingDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer num1 = Integer.valueOf(2);    //在-128 到 127之间的值是一样的地址空间
		Integer num2 = 20;
		System.out.println(num1 == num2);
		System.out.println(num1.equals(num2));
		
		
		
		
		
		
		
		
		
//		double num1 = 3.14;				
//		Double dNum1_2 = 3.14;   	//自动装箱
//		Double dNum1 = new Double(num1);
//		Double dNum1_1 = Double.valueOf(num1);
//		
//		System.out.println(dNum1_1);
//		System.out.println(dNum1);
//		System.out.println(dNum1.toHexString(num1));
//		
//		
//		num1 = dNum1;			//自动拆箱
//		num1 = dNum1.doubleValue();
	}

}
