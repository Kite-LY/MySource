package KingOfFighter;

import java.util.Scanner;

/**
 * ���Ƽ�̼�����
 * 
 * */

public class MyCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double num1, num2, result = 0;			//����
		String op = "";
		String choice = null;

		do {
			System.out.println("������Ҫ�������������");
			num1 = input.nextDouble();
			num2 = input.nextDouble();
			System.out.println("�������������");
			op = input.next();
			switch (op) {
			case "+":
				result = num1 + num2;
				break;
			case "-":
				result = num1 - num2;
				break;
				
			case "*":
				result = num1 * num2;
				break;
			case "/":
				if(num2 == 0) {
					System.out.println("��������Ϊ0��");
					result = 0;
				}
				result = num1 / num2;
				break;
			case "%":
				result = num1 % num2;
				break;
			default:
				System.out.println("����λ���������");
				break;
			}
			System.out.printf("%.2f %s %.2f = %.2f\n", num1, op, num2, result);
			
			System.out.println("�Ƿ���������м��㣺(y/n)" );
			choice = input.next();
		}while("y".equalsIgnoreCase(choice));
		
		
		
		
		
		
		
		
		
		
		
		
		input.close();
		
	}

}
