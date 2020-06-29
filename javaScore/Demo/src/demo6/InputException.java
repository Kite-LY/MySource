package demo6;

import java.util.Scanner;

public class InputException {

	public static void main(String[] args) {
		
		Scanner	input = new Scanner(System.in);
		System.out.println("请输入年龄：（年龄必须说整型）");
		int age = -1;
		try {
			age = input.nextInt();
		} catch (Exception e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		System.out.println("输入的年龄是：" + age);
	}

}
