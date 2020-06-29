package demo;

import java.util.Scanner;

/**
 * 判断天数：
 * */
public class SimpleCalen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.定义变量：年，月，日，天数
		Scanner input = new Scanner(System.in);
		int year = -1, month = -1, dayOfMonth = -1;
		System.out.println("请输入年份：");
		year = input.nextInt();
		System.out.println("请输入月份：");
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
			System.out.println("您输入的有误，请重新输入：");
			System.exit(0);
			break;
		}
		System.out.println(year+"年" + month + "月" + dayOfMonth +"日");
		
		//2.根据月份判断每个月的天数。2月默认28天
		//3.如果是闰年，天数+1
		
		
		
		
		
	}

}
