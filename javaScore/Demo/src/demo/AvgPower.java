package demo;

import java.util.Scanner;

/**
 * �������ƽ��ս����
 * */


public class AvgPower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	input = new Scanner(System.in);
		int power = 0, sum = 0;
		double avgPower = 0;
		for(int i = 0; i < 3; i++) {
			System.out.print("������� " + (i + 1)+"λ��ҵ�ս������" );
			power = input.nextInt();
			sum += power;
		}
		avgPower = sum / 3;
		System.out.printf("ƽ��ս����Ϊ��%.2f\n", avgPower);
		
			
		input.close();
	}

}
