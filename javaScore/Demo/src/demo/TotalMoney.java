package demo;

import java.util.Scanner;

public class TotalMoney {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.ѭ��¼��5����ҵ����ѽ��
		int count = 0;
		for(int i = 0; i < 5; i++)
		{
			System.out.println("�������"+ (i + 1) +"���ѽ�");
			int money = new Scanner(System.in).nextInt();
//			if(money < 500) {
//				count++;
//			}
			if(money >= 500)
			{
				continue;
			}
			count++;
		}
		System.out.println("С��500������Ϊ��" + count);
		//2.¼��������жϽ���Ƿ�С��500
		//3.�ۼ�С��500�Ĵ���
		
		
		
		
	}

}
