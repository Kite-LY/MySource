package demo;

import java.util.Scanner;

public class WeekDayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("������������ڼ���");
		int WeekDay = new Scanner(System.in).nextInt();
		//�ж�
		if(!isRight(WeekDay)) {
			System.out.println("��������ȷ�����ڣ�");
		}else
		{
			//����
			ShowWeekDayByCh(WeekDay - 1);
			ShowWeekOfDayByJp(WeekDay - 1);
			ShowWeekOfDayByEn(WeekDay - 1);
		}
		

		
	}
	
	private static boolean isRight(int WeekDay) {
		if(WeekDay < 1 || WeekDay > 7) {
			return false;
		}
		return true;
	}
	
	
	/**
	 * 
	 * @param WeekDay       1~7��ʾ���ڼ�
	 */
	
	public static void ShowWeekDayByCh(int WeekDay) {
		String[] _WeekDay = {"����һ","���ڶ�","������","������","������","������","������"};
		System.out.println(_WeekDay[WeekDay]);
		
	}
	
	static void ShowWeekOfDayByJp(int WeekDay) {
		String[] _WeekDay = {"������","������","ˮ����","ľ����","������","������","������"};
		System.out.println(_WeekDay[WeekDay]);
	}
	static void ShowWeekOfDayByEn(int WeekDay) {
		String[] _WeekDay = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturd","Sunday"};
		System.out.println(_WeekDay[WeekDay]);
	}

}

