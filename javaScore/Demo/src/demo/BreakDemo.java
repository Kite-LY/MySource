package demo;

import java.util.Scanner;

public class BreakDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int exp = 0, sum = 0;
		for(;;) {  		//��ѭ��
			System.out.println("��������ľ���ֵ��");
			exp = input.nextInt();
			if(exp < 0)
			{
				System.out.println("����ֵ����Ϊ��ֵ�������˳���");
				break;				//����forѭ�� 
			}
			sum += exp;
		}
		System.out.println("�ܾ���ֵΪ��" + sum);
		
		input.close();
	}

}
