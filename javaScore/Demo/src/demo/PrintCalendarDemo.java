package demo;

import java.util.Scanner;

/**
 * ʹ�÷�����ӡ���� 
 * 
 * */
public class PrintCalendarDemo {
	//����ȫ�ֵľ�̬����
	public static int year = Integer.MIN_VALUE;
	public static int month = Integer.MIN_VALUE;
	public static int[] datOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintCalendar();
	}
	public static void PrintCalendar() {
		//1.���û� ������ݣ��·�
		inputYearMoth();
		//2.����������
		int sum = getSumOfYears();
		sum += getSumOfMonth();
		sum++;
		System.out.println(sum);
		//3.��ӡ�·�
		PrintMonthTitle();
		//4.��ӡ�·ݵı���
		//5.����һ�������ڼ���ӡ����������
		//System.out.println(sum % 7);
		PrintCalendarContent(sum % 7); 
	}
	
	private static void inputYearMoth() {
		Scanner input = new  Scanner(System.in);
		System.out.print("��������ݣ�");
		year = input.nextInt(); 
		System.out.print("�������·ݣ�");
		month = input.nextInt();
		input.close();
		input = null;
	}
	
	private static int getSumOfYears() {
		if( year == Integer.MIN_VALUE) {
			System.out.println("�������ݲ��ԣ����������룡");
			inputYearMoth();
		}
		int sum = 0;
		for(int i = 1900; i < year; i++) {
			sum += 365;
			if(isLeapYear(i)) {
				sum++;
			}
		}
		return sum;
	}
	
	private static int getSumOfMonth() {
		int sum = 0;
		for(int i = 0; i < month -1; i++) {
			sum += datOfMonth[i];
		}
		if(isLeapYear(year) && month >= 3) {
			sum++;
		}
		return sum;
	}
	
	//�ж��Ƿ�Ϊ����
	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 !=0;
	}

	private static void PrintMonthTitle() {
		String[] monthNames = {"1��", "2��","3��", "4��","5��","6��","7��","8��","9��","10��","11��","12��"};
		System.out.println("\t\t" +year + "��-" + monthNames[month - 1] );
		String[] weekDays = {"����һ", "���ڶ�", "������", "������", "������", "������", "������"};

		for(int i = 0; i < weekDays.length; i++) {
			System.out.print(weekDays[i] + "\t");
		}
		System.out.println();
	}
	
	private static void PrintCalendarContent(int dayOfWeek) {
		int sepCount = 0;
		if(dayOfWeek == 0) {
			sepCount = 6;
		}else {
			sepCount = dayOfWeek - 1;
		}
		for(int i = 0; i < sepCount; i++) {
			System.out.print("\t");
		}
			
		for(int i = 0; i < datOfMonth[month  - 1]; i++) {
			System.out.print(i + 1);
			if((dayOfWeek + i) % 7 == 0)
			{
				System.out.println();
			}else {
				System.out.print("\t");
			}
		}
		//System.out.println(dayOfWeek);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
