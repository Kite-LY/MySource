package Whiledemo;

import java.util.Scanner;

/**
 * ���������һ��������ÿһλ��֮��
 * 
 * */



public class SumDemo {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("������һ�����֣�");
		
		int num = input.nextInt();//һ������
		int tempNum = num;
		int sum = 0;
		//ѭ������
		while(num != 0) {
			sum += num % 10;
			num /= 10;
		}
		
		System.out.println(tempNum + "һ��������ÿһλ��֮��:" + sum);
	}
}





/*
 *ʹ��ѭ������1~100 ���ۼӺ�  
 * 




public class SumDemo {
	public static void main(String[] args) {
		int sum = 0;
		int i = 1;
		while(i <= 100) {
			sum += i;
			i++;
		}
		
		System.out.println("1~100���ۼӺ�Ϊ��"+ sum);
	}
}
 */