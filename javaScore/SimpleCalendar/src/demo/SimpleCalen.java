package demo;

import java.util.Scanner;

/**
 * �ж�������
 * */
public class SimpleCalen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.����������꣬�£��գ�����
		Scanner input = new Scanner(System.in);
		int year = -1, month = -1, dayOfMonth = -1;
		System.out.println("��������ݣ�");
		year = input.nextInt();
		System.out.println("�������·ݣ�");
		month = input.nextInt();
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			dayOfMonth = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			dayOfMonth = 30;
			break;
		case 2:
			dayOfMonth = 28;
			boolean isLeapYear = year % 4 == 0 && year % 100 != 0 && year % 400 == 0;
			if(isLeapYear == true) {
				dayOfMonth ++;
			}
			break;
			
		default:
			System.out.println("��������������������룺");
			System.exit(0);
			break;
		}
		System.out.println(year+"��" + month + "��" + dayOfMonth +"��");
		
		//2.�����·��ж�ÿ���µ�������2��Ĭ��28��
		//3.��������꣬����+1
		
		
		
		
		
	}

}
