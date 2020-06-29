package demo;

import java.util.Scanner;

/**
 * 计算玩家平均战斗力
 * */


public class AvgPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	input = new Scanner(System.in);
		int power = 0, sum = 0;
		double avgPower = 0;
		for(int i = 0; i < 3; i++) {
			System.out.print("请输入第 " + (i + 1)+"位玩家的战斗力：" );
			power = input.nextInt();
			sum += power;
		}
		avgPower = sum / 3;
		System.out.printf("平均战斗力为：%.2f\n", avgPower);
		
			
		input.close();
	}

}
