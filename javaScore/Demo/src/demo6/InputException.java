package demo6;

import java.util.Scanner;

public class InputException {

	public static void main(String[] args) {
		
		Scanner	input = new Scanner(System.in);
		System.out.println("���������䣺���������˵���ͣ�");
		int age = -1;
		try {
			age = input.nextInt();
		} catch (Exception e) {
			
			//e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		System.out.println("����������ǣ�" + age);
	}

}
