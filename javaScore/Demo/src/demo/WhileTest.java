package demo;

import java.util.Random;

public class WhileTest {
//	
//	static boolean condition() {
//		
//		boolean result = Math.random() < 0.91;
//		System.out.println(Math.random());
//		System.out.println(result);
//		
//		return result;
//	}
	
	public static void main(String[] args) {
		
		Random random = new Random(11);
		System.out.println(random);
		float[]  f = new float[10];
		for (int i = 0; i < f.length; i++) {
			f[i] = random.nextFloat();
		}
		for(float x : f) {
			System.out.println(x);
		}
//		int i = 1;
//		while(condition()) {
//			
//			System.out.println("程序执行次数："  + i);
//			i++;
//		}
//	}
//	
//	
//	 int[] random = new int[24];
		
//	 for (int i = 0; i < random.length; i++) {
//		random[i] = (int)(Math.random() * 1000)%10;
//	}
//	 for (int i = 0; i < random.length; i++) {
//		 System.out.print(random[i] + "\t");
//	}
//	 
//	 int value = (int)(Math.random() * 1000)%10;
//	 System.out.println("随机产生要比较的数字：");
//	 for (int i = 0; i < random.length; i++) {
//		if(random[i] < value) {
//			int j = 0;
//			System.out.println("小于" + value + "的数字有：" + random[i]);
//			j++;
//			System.out.println(j);
//		}
//	}
		
	 	
	}
}
