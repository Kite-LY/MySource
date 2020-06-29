package demo;

import java.util.Scanner;

public class BreakDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int exp = 0, sum = 0;
		for(;;) {  		//死循环
			System.out.println("请输入你的经验值：");
			exp = input.nextInt();
			if(exp < 0)
			{
				System.out.println("经验值不能为负值，程序退出！");
				break;				//跳出for循环 
			}
			sum += exp;
		}
		System.out.println("总经验值为：" + sum);
		
		input.close();
	}

}
