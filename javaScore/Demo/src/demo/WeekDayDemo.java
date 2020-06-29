package demo;

import java.util.Scanner;

public class WeekDayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入今天星期几：");
		int WeekDay = new Scanner(System.in).nextInt();
		//判断
		if(!isRight(WeekDay)) {
			System.out.println("请输入正确的日期！");
		}else
		{
			//中文
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
	 * @param WeekDay       1~7表示星期几
	 */
	
	public static void ShowWeekDayByCh(int WeekDay) {
		String[] _WeekDay = {"星期一","星期二","星期三","星期四","星期五","星期六","星期天"};
		System.out.println(_WeekDay[WeekDay]);
		
	}
	
	static void ShowWeekOfDayByJp(int WeekDay) {
		String[] _WeekDay = {"月曜日","火曜日","水曜日","木曜日","金曜日","土曜日","日曜日"};
		System.out.println(_WeekDay[WeekDay]);
	}
	static void ShowWeekOfDayByEn(int WeekDay) {
		String[] _WeekDay = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturd","Sunday"};
		System.out.println(_WeekDay[WeekDay]);
	}

}

