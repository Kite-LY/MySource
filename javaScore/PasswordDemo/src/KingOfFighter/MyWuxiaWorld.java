package KingOfFighter;

import java.util.Scanner;

/**
 * ģ�����������紴������
 * 
 * */


public class MyWuxiaWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner	input = new Scanner(System.in);
		String answer = "y";
		String name = null;
		
		do {
			System.out.println("��ӭ�����������磬����Լ���һ�����䣺"); 
			name = input.nextLine();
			System.out.println("�������ţ� " + name);
			
			System.out.println(name + "�Ƿ���Լ�����������(y/n)");
			answer = input.nextLine();
		}while(! "y".equalsIgnoreCase(answer));
			
		System.out.println(name + "���뽭��������ָ�̣�" );
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		input.close();
	}

}
