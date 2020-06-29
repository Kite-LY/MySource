package KingOfFighter;

import java.util.Scanner;

/**
 * 自制简短计算器
 * 
 * */

public class MyCalc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		double num1, num2, result = 0;			//变量
		String op = "";
		String choice = null;

		do {
			System.out.println("请输入要计算的两个数：");
			num1 = input.nextDouble();
			num2 = input.nextDouble();
			System.out.println("请输入运算符：");
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
					System.out.println("除数不能为0！");
					result = 0;
				}
				result = num1 / num2;
				break;
			case "%":
				result = num1 % num2;
				break;
			default:
				System.out.println("出现位置运算符！");
				break;
			}
			System.out.printf("%.2f %s %.2f = %.2f\n", num1, op, num2, result);
			
			System.out.println("是否继续啊进行计算：(y/n)" );
			choice = input.next();
		}while("y".equalsIgnoreCase(choice));
		
		
		
		
		
		
		
		
		
		
		
		
		input.close();
		
	}

}
