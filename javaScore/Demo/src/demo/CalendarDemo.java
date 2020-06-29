package demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarDemo {

	public static void main(String[] args) throws ParseException {
		//Calender ��һ�������࣬һ��������GregorianCalendarʵ��

		Calendar cal = Calendar.getInstance();
		//System.out.println(cal.getClass());
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int day = cal.get(Calendar.DATE);
		
		Calendar Oldcal = new GregorianCalendar(2017, 11-1, 26);
		
		long diff = Math.abs(cal.getTimeInMillis() - Oldcal.getTimeInMillis());
		int dayDiff = (int)(diff / 1000 / 60 / 60 / 24) + 1;
		System.out.println("��һ��" + dayDiff + "�죡");
		
		
//		System.out.println(year + "-" + month + "-" + day);
//		cal.set(2017, 11, 26 );
		
//		Date currDay = cal.getTime();
//		System.out.println(currDay.toLocaleString());
//		
//		//���ڵĸ�ʽ����
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:sss");
//		String strDay = format.format(currDay);
//		System.out.println(strDay);
//		
//		//���ַ���ת��ΪDate����
//		Date newDate = format.parse("2012-11-22 12:12:12:012");
//		System.out.println(newDate.toLocaleString());
	}

}
