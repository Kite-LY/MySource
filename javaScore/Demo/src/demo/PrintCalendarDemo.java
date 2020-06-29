package demo;

import java.util.Scanner;

/**
 * 使用方法打印日历 
 * 
 * */
public class PrintCalendarDemo {
	//创建全局的静态变量
	public static int year = Integer.MIN_VALUE;
	public static int month = Integer.MIN_VALUE;
	public static int[] datOfMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrintCalendar();
	}
	public static void PrintCalendar() {
		//1.让用户 输入年份，月份
		inputYearMoth();
		//2.计算总天数
		int sum = getSumOfYears();
		sum += getSumOfMonth();
		sum++;
		System.out.println(sum);
		//3.打印月份
		PrintMonthTitle();
		//4.打印月份的标题
		//5.根据一号是星期几打印月历的类容
		//System.out.println(sum % 7);
		PrintCalendarContent(sum % 7); 
	}
	
	private static void inputYearMoth() {
		Scanner input = new  Scanner(System.in);
		System.out.print("请输入年份：");
		year = input.nextInt(); 
		System.out.print("请输入月份：");
		month = input.nextInt();
		input.close();
		input = null;
	}
	
	private static int getSumOfYears() {
		if( year == Integer.MIN_VALUE) {
			System.out.println("输入的年份不对，请重新输入！");
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
	
	//判断是否为闰年
	private static boolean isLeapYear(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 !=0;
	}

	private static void PrintMonthTitle() {
		String[] monthNames = {"1月", "2月","3月", "4月","5月","6月","7月","8月","9月","10月","11月","12月"};
		System.out.println("\t\t" +year + "年-" + monthNames[month - 1] );
		String[] weekDays = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};

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
