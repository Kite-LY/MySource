package demo;

import java.util.Scanner;

public class ArrayDemo {

	public static void main(String[] args) {

		
		
		//手动记录5位学生的成绩
		Scanner input = new Scanner(System.in);
		final int N = 5;
		double sum1 = 0;
		double[] score = new double[N];
		for(int i = 0; i < score.length; i++)
		{
			System.out.print("请输入第 " +(i + 1)+ " 位学生的成绩：");
			score[i] = input.nextDouble();
		}
		System.out.println("-------------");
		//打印
//		for(int i = 0; i < score.length; i++)
//		{
//			System.out.print("第 " +(i + 1)+ " 位学生的成绩：");
//			System.out.println(score[i]);
//		}
		//计算总成绩
		for(int i = 0; i < score.length; i++)
		{
			sum1 += score[i];
		}
		System.out.println("学生的总成绩为：" + sum1);
		
		
//		int[] nums = new int[5];			//数组名为分配空间的首地址
//		System.out.println(nums);
//		
	}

}
