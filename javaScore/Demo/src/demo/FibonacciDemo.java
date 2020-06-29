package demo;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 斐波拉契数列
 * */

public class FibonacciDemo {
	public static void main(String[] args) {
		int[] nums = new int[20];
		nums[0] = 0;
		nums[1] = 1;
		for(int i = 2; i < nums.length; i++) {
			nums[i] = nums[i - 1] + nums[i - 2];
		}
		
		//打印
		System.out.print("数列打印结果：");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]+"\t");
		}
		System.out.println();
	
		
	}
}
