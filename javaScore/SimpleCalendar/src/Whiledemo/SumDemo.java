package Whiledemo;

import java.util.Scanner;

/**
 * 计算输入的一串数字中每一位数之和
 * 
 * */



public class SumDemo {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一串数字：");
		
		int num = input.nextInt();//一串数字
		int tempNum = num;
		int sum = 0;
		//循环计算
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		
		System.out.println(tempNum + "一串数字中每一位数之和:" + sum);
	}
}





/*
 *使用循环计算1~100 的累加和  
 * 




public class SumDemo {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while(i <= 100) {
			sum += i;
			i++;
		}
		
		System.out.println("1~100的累加和为："+ sum);
	}
}
 */